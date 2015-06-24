package com.lehecai.core.lottery.fetcher.football.impl.worker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.InputTag;
import org.htmlparser.tags.OptionTag;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.football.AbstractFootballScheduleFetchWorker;
import com.lehecai.core.lottery.fetcher.football.FootballScheduleItem;
import com.lehecai.core.util.CoreDateUtils;
import com.lehecai.core.util.CoreFetcherUtils;
/**
 * 4场进球 足球赛程官方抓取worker
 * @author liurd
 *
 */
public class FootballScheduleFetch9WorkerOfficial extends AbstractFootballScheduleFetchWorker{
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	protected final static String BQC_SCHEDULE_FETCH_URL_OFFICIAL = "http://www.lottery.gov.cn/lottery/jqc/JQC.aspx";
	protected String siteName = "official";
	
	private String phaseValue;
	
	@Override
	public List<FootballScheduleItem> fetchFootballSchedule(String phase) {
		String fetchLotteryInfo = "["+getLotteryType().getName().trim()+" 足球赛程]";//抓取彩票信息
		this.setFetchPhase(phase);
		if (phase == null) {
			phaseValue = this.getScheduleUrl();
			phase = getFetchPhase();
		} else {
			phaseValue = this.getPhaseValue();
		}
		if (phaseValue == null) {
			logger.error("获取抓取信息出错");
			return null;
		}
		String url = BQC_SCHEDULE_FETCH_URL_OFFICIAL;
		if(url==null||url.isEmpty()){
			logger.error(siteName+"==抓取==期号:"+phase+"==地址url:"+url+"不存在，返回null");
			return null;
		}
		String encoding = "GBK";
		String phaseInfo = "第<"+phase+">期";//彩期信息
		String logHeader = siteName+fetchLotteryInfo+"=="+url+"==抓取=="+phaseInfo+"==";
		
		logger.info(logHeader+"开始==");
		List<FootballScheduleItem> footballScheduleItems = null;
		
		String data=null;
		
		try {
			data = CoreFetcherUtils.URLGet(BQC_SCHEDULE_FETCH_URL_OFFICIAL, null, encoding);
			Map<String, String> headerParams = new HashMap<String, String>();
			headerParams.put("Referer", "http://www.lottery.gov.cn/lottery/sfc/SFC.aspx");
			headerParams.put("user-agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.8) Gecko/20100722 Firefox/3.6.8");
			
			Parser parserTmp = Parser.createParser(data, encoding);
			NodeFilter filterValidation = new HasAttributeFilter("id", "__EVENTVALIDATION");
			NodeList nodeValidation = parserTmp.extractAllNodesThatMatch(filterValidation);
			parserTmp.reset();
			NodeFilter filterViewState = new HasAttributeFilter("id", "__VIEWSTATE");
			NodeList nodeViewState = parserTmp.extractAllNodesThatMatch(filterViewState);
			String validation = ((InputTag)nodeValidation.elementAt(0)).getAttribute("value");
			String viewState = ((InputTag)nodeViewState.elementAt(0)).getAttribute("value");
			
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("DropDownListEvents", phaseValue);
			params.put("__EVENTVALIDATION", validation);
			params.put("__EVENTARGUMENT", "");
			params.put("__EVENTTARGET", "DropDownListEvents");
			params.put("__LASTFOCUS", "");
			params.put("__EVENTARGUMENT", "");
			params.put("__VIEWSTATE", viewState);
			data = CoreFetcherUtils.URLPostWithHeaderParams(BQC_SCHEDULE_FETCH_URL_OFFICIAL, headerParams, params, encoding);
		} catch (Exception e) {
			logger.error("获取网页数据异常");
			return null;
		}
		if (data == null || data.indexOf("404 Not Found") > 0) {
			logger.error(logHeader+"data is null or 404 Not Found");
			return null;
		}
		try{
			Parser parser = Parser.createParser(data, encoding);
			NodeFilter filter = new TagNameFilter("table");
			NodeList nodeList = parser.extractAllNodesThatMatch(filter);
			if (nodeList == null || nodeList.size() == 0) {
				logger.error(logHeader+"未抓到" + getLotteryType().getName().trim() + "赛程数据");
				return null;
			}
			TableTag tableTag = (TableTag) nodeList.elementAt(0);
			TableRow[] tableRows = tableTag.getRows();
			TableTag table = (TableTag) tableRows[1].getChildren().elementAt(1).getChildren().elementAt(1);
			TableRow[] rows = table.getRows();
			footballScheduleItems = new ArrayList<FootballScheduleItem>();
			
			for (int i = 1; i < rows.length; i=i+2) {
				TableColumn[] tableColumns = rows[i].getColumns();
				FootballScheduleItem footballScheduleItem = new FootballScheduleItem();
				footballScheduleItem.setMatchIndex(Integer.parseInt(tableColumns[0].toPlainTextString().trim()));
				footballScheduleItem.setLeague(tableColumns[1].toPlainTextString().trim());
				footballScheduleItem.setHomeTeam(tableColumns[3].toPlainTextString().replace("　", "").replace(" ", "").replace("&nbsp;", ""));
				footballScheduleItem.setAwayTeam(rows[i+1].getColumns()[0].toPlainTextString().replace("　", "").replace(" ", "").replace("&nbsp;", ""));
				footballScheduleItem.setPhase(phase);
				//比赛时间判断是否是今年的比赛 抓取历史数据时可能年份出错
				char[] phaseChars = phase.toCharArray();
				String year = "" + phaseChars[0] + phaseChars[1];
				Date now = new Date();
				Calendar match = Calendar.getInstance();
				String dateStr= tableColumns[2].toPlainTextString().trim().replace("月", "-").replace("日", "");
				match.setTime(CoreDateUtils.parseDate("20" + year + "-" + dateStr + ":00"));
				Calendar nowCal = Calendar.getInstance();
				nowCal.setTime(now);
				if (nowCal.compareTo(match) > 200) {
					match.set(Calendar.YEAR, match.get(Calendar.YEAR) + 1);
				}
				footballScheduleItem.setMatchTime(CoreDateUtils.parseDate(match.get(Calendar.YEAR) + "-" + dateStr + ":00", CoreDateUtils.DATETIME));
				footballScheduleItems.add(footballScheduleItem);
			}
		}catch(Exception e){
			logger.error(logHeader+"解析" + getLotteryType().getName().trim() + "足球赛程发生错误"+e.getMessage(),e);
			return null;
		}
		if(footballScheduleItems!=null){
			logger.info(logHeader+"抓取足球赛程共"+footballScheduleItems.size()+"场。");
		}else{
			logger.info(logHeader+"抓取足球赛程为空。");
		}
		logger.info(logHeader+"结束==");
		return footballScheduleItems;
	}
	
	private String getPhaseValue() {
		String phaseValue = "";
		String phase = getFetchPhase();
		String url = BQC_SCHEDULE_FETCH_URL_OFFICIAL;
		String data = null;
		String encoding = "utf-8";
		try {
			data = CoreFetcherUtils.URLGet(url, null, encoding);
		} catch (Exception e) {
			logger.error("获取html数据失败" + e.getMessage());
			return null;
		}
		
		if (data == null || data.indexOf("404 Not Found") > 0 || data.isEmpty()) {
			logger.error("data is null or 404 Not Found");
			return null;
		}	
		Parser parser = null;
		try {
			parser = Parser.createParser(data,  encoding);
		} catch (Exception e) {
			logger.error("解析html页面失败" + e.getMessage());
			return null;
		}
		NodeFilter filter = new TagNameFilter("option");		
		NodeList nodeList = null;
		
		try {
			nodeList = parser.extractAllNodesThatMatch(filter);
			for (int i = 0; i < nodeList.size(); i++) {
				if (nodeList.elementAt(i).toPlainTextString() != null && nodeList.elementAt(i).toPlainTextString().equals(phase)) {
					phaseValue = ((OptionTag)nodeList.elementAt(i)).getAttribute("value");
				}
			}
		} catch (ParserException e) {
			logger.error("获取抓取地址错误" + e.getMessage(), e);
			return null;
		}
		return phaseValue;
	}

	@Override
	public String getScheduleUrl() {
		String phaseValue = "";
		String url = BQC_SCHEDULE_FETCH_URL_OFFICIAL;
		String data = null;
		String encoding = "utf-8";
		try {
			data = CoreFetcherUtils.URLGet(url, null, encoding);
		} catch (Exception e) {
			logger.error("获取html数据失败" + e.getMessage());
			return null;
		}
		
		if (data == null || data.indexOf("404 Not Found") > 0 || data.isEmpty()) {
			logger.error("data is null or 404 Not Found");
			return null;
		}	
		Parser parser = null;
		try {
			parser = Parser.createParser(data,  encoding);
		} catch (Exception e) {
			logger.error("解析html页面失败" + e.getMessage());
			return null;
		}
		NodeFilter filter = new HasAttributeFilter("selected");		
		NodeList nodeList = null;
		
		try {
			nodeList = parser.extractAllNodesThatMatch(filter);
			this.setFetchPhase(nodeList.elementAt(0).toPlainTextString());
			if (getFetchPhase() == null || "".equals(getFetchPhase())) {
				logger.error("获取当前期出错");
				return null;
			}
			phaseValue = ((OptionTag)nodeList.elementAt(0)).getAttribute("value");
		} catch (ParserException e) {
			logger.error("获取抓取地址错误" + e.getMessage(), e);
			return null;
		}
		return phaseValue;
	}
}
