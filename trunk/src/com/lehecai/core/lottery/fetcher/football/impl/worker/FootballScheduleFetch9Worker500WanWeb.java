package com.lehecai.core.lottery.fetcher.football.impl.worker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.tags.LinkTag;
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
import com.lehecai.core.util.CoreStringUtils;
/**
 * 4场进球 足球赛程 500WanWeb 抓取worker
 * @author liurd
 *
 */
public class FootballScheduleFetch9Worker500WanWeb extends AbstractFootballScheduleFetchWorker{
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	//protected final static String BQC_SCHEDULE_FETCH_URL_500WAN = "http://trade.500wan.com/static/public/zc6/daigou/shtml/%s.shtml";//无赛事名称,废弃
	protected final static String BQC_SCHEDULE_FETCH_URL_500WAN = "http://zc.trade.500wan.com/jq4/project_fq_fsyt.php?lotid=17&playid=1&expect=";
	protected String siteName = "500WanWeb";
	
	
	@Override
	public List<FootballScheduleItem> fetchFootballSchedule(String phase) {
		String fetchLotteryInfo = "["+getLotteryType().getName().trim()+" 足球赛程]";//抓取彩票信息
		this.setFetchPhase(phase);
		String url = this.getScheduleUrl();
		if (phase == null) {
			phase = getFetchPhase();
		}
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
			data = CoreFetcherUtils.URLGet(url, null, encoding);
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
			NodeFilter filter = new HasAttributeFilter("id", "vsTable");		
			NodeList nodeList = parser.extractAllNodesThatMatch(filter);
			if (nodeList == null || nodeList.size() == 0) {
				logger.error(logHeader+"未抓到" + getLotteryType().getName().trim() + "赛程数据");
				return null;
			}
			TableTag tableTag = (TableTag) nodeList.elementAt(0);
			TableRow[] tableRows = tableTag.getRows();
			footballScheduleItems = new ArrayList<FootballScheduleItem>();
			for (int i = 0 ; i < tableRows.length - 1; i=i+2) {
				FootballScheduleItem footballScheduleItem = new FootballScheduleItem();
				TableRow tableRow = tableRows[i + 1];
				TableColumn[] tableColumns = tableRow.getColumns();
				footballScheduleItem.setMatchIndex(Integer.parseInt(tableColumns[0].toPlainTextString()));
				footballScheduleItem.setLeague(CoreStringUtils.trimAll(tableColumns[1].toPlainTextString()));
				
				//比赛时间判断是否是今年的比赛 抓取历史数据时可能年份出错
				char[] phaseChars = phase.toCharArray();
				String year = "" + phaseChars[0] + phaseChars[1];
				Date now = new Date();
				Calendar match = Calendar.getInstance();
				match.setTime(CoreDateUtils.parseDate("20" + year + "-" + tableColumns[2].toPlainTextString() + ":00"));
				Calendar nowCal = Calendar.getInstance();
				nowCal.setTime(now);
				if ((nowCal.getTimeInMillis() - match.getTimeInMillis()) > (3600000L * 24 * 30)) {
					match.set(Calendar.YEAR, match.get(Calendar.YEAR) + 1);
				}
				if ((nowCal.getTimeInMillis() - match.getTimeInMillis()) < -(3600000L * 24 * 200)) {
					match.set(Calendar.YEAR, match.get(Calendar.YEAR) - 1);
				}
				footballScheduleItem.setMatchTime(CoreDateUtils.parseDate(match.get(Calendar.YEAR) + "-" + tableColumns[2].toPlainTextString() + ":00", CoreDateUtils.DATETIME));
				String home = tableColumns[3].toPlainTextString().replace("主", "").replace(" ", "");
				String away = tableRows[i + 2].getColumns()[0].toPlainTextString().replace("客", "").replace(" ", "");
				footballScheduleItem.setHomeTeam(CoreStringUtils.trimAll(home));
				footballScheduleItem.setPhase(phase);
				footballScheduleItem.setAwayTeam(CoreStringUtils.trimAll(away));
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
	
	@Override
	public String getScheduleUrl() {
		String link = "";
		String phase = getFetchPhase();
		if (phase != null && !"".equals(phase)) {
			link = BQC_SCHEDULE_FETCH_URL_500WAN + phase;
			return link;
		}
		String url = BQC_SCHEDULE_FETCH_URL_500WAN;
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
		NodeFilter filter = new HasAttributeFilter("class", "on");		
		NodeList nodeList = null;
		
		try {
			nodeList = parser.extractAllNodesThatMatch(filter);
			LinkTag linkTag = (LinkTag) nodeList.elementAt(0);
			this.setFetchPhase(linkTag.toPlainTextString().replace("当前","").replace("期", ""));
			if (getFetchPhase() == null || "".equals(getFetchPhase())) {
				logger.error("获取当前期出错");
				return null;
			}
			link = BQC_SCHEDULE_FETCH_URL_500WAN + getFetchPhase();
		} catch (ParserException e) {
			logger.error("获取抓取地址错误" + e.getMessage(), e);
			return null;
		}
		return link;
	}
}
