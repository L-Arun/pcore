package com.lehecai.core.lottery.fetcher.football.impl.worker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.CssSelectorNodeFilter;
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
import com.lehecai.core.util.CoreXmlUtils;
/**
 * 4场进球 足球赛程 500Wan 抓取worker
 * @author leiming
 *
 */
public class FootballScheduleFetch9Worker500Wan extends AbstractFootballScheduleFetchWorker{
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	//protected final static String JQC_SCHEDULE_FETCH_URL_500WAN = "http://trade.500wan.com/static/public/jq4/daigou/shtml/%s.shtml";//无赛事名称,废弃
	protected final static String JQC_SCHEDULE_FETCH_URL_500WAN = "http://www.500wan.com/static/info/odds/xml/lottery/jq4/%s_2.xml";
	
	protected final static String JQC_SCHEDULE_FETCH_PHP_URL_500WAN = "http://trade.500wan.com/jq4/index.php?lotid=17&playid=1&expect=%s";
	
	protected String siteName = "500wan";
	
	
	@Override
	public List<FootballScheduleItem> fetchFootballSchedule(String phase) {
		String fetchLotteryInfo = "["+getLotteryType().getName().trim()+" 足球赛程]";//抓取彩票信息
		if(phase==null){
			logger.error(siteName+fetchLotteryInfo+"==抓取指定期号为"+phase+",期号不存在，返回null");
			return null;
		}
		this.setFetchPhase(phase);
		
		
		String logHeader = siteName+fetchLotteryInfo+"==抓取==第<"+getFetchPhase()+">期==";
		
		logger.info(logHeader+"开始==");
		
		List<FootballScheduleItem> footballScheduleItems = null;
		
		// 从500万的xml的地址抓取
		footballScheduleItems = fetch500WanXmlScheduleList();
		
		if(footballScheduleItems!=null){
			logger.info(logHeader+"抓取足球赛程共"+footballScheduleItems.size()+"场。");
		}else{
			footballScheduleItems = fetch500WanPhpScheduleList();
			if(footballScheduleItems!=null){
				logger.info(logHeader+"抓取足球赛程为空。");
			}
		}
		
		logger.info(logHeader+"结束==");
		return footballScheduleItems;
	}
	@Override
	public String getScheduleUrl() {
		//判断是否在抓取列表页面时赋予了地址信息
		if(scheduleUrl==null||scheduleUrl.isEmpty()){
			//未指定情况
			if(getFetchPhase()==null||getFetchPhase().isEmpty()){
				return null;
			}else{
				scheduleUrl = String.format(JQC_SCHEDULE_FETCH_URL_500WAN, getFetchPhase());
				return scheduleUrl;
			}
		}else{
			//已指定
			return scheduleUrl;
		}
	}
	/**
	 * 从500万xml地址抓取
	 * @return
	 */
	protected List<FootballScheduleItem> fetch500WanXmlScheduleList(){
		String fetchLotteryInfo = "["+getLotteryType().getName().trim()+" 足球赛程]";//抓取彩票信息
		String url = this.getScheduleUrl();
		String logHeader = siteName+fetchLotteryInfo+"=="+url+"==抓取==第<"+getFetchPhase()+">期==";
		if(url==null||url.isEmpty()){
			logger.error(siteName+"==抓取==期号:"+getFetchPhase()+"==地址url:"+url+"不存在，返回null");
			return null;
		}
		String encoding = "GBK";
		
		String data=null;
		
		data = CoreFetcherUtils.URLGet(url, null, encoding);
		if (data == null || data.indexOf("404 Not Found") >= 0) {
			logger.error(logHeader+"data is null or 404 Not Found");
			return null;
		}
		logger.info(logHeader);
		/*此段为读取html内容,由于html内容中没有赛事,废弃,采用解析xml数据方式 delete by lm
		try{
			Parser parser = Parser.createParser(data, encoding);
			NodeFilter cssFilter = new CssSelectorNodeFilter("#matchList");
			//NodeFilter ulFilter = new TagNameFilter("ul");
			NodeList nodeList = parser.extractAllNodesThatMatch(cssFilter);
			footballScheduleItems = CoreFetcherUtils.getFootballScheduleItemListByHtmlData4JQCAndBQCFrom500Wan(nodeList.toHtml(), encoding,phase);
		}catch(Exception e){
			logger.error(logHeader+"解析4场进球足球赛程发生错误"+e.getMessage(),e);
			return null;
		}
		*/
		List<FootballScheduleItem> footballScheduleItems = CoreXmlUtils.getSFCScheduleList(data, getFetchPhase(), encoding);
		return footballScheduleItems;
	}
	/**
	 * 从500万php地址抓
	 * @return
	 */
	protected List<FootballScheduleItem> fetch500WanPhpScheduleList(){

		List<FootballScheduleItem> phpScheduleList = null;
		String fetchLotteryInfo = "["+getLotteryType().getName().trim()+" 足球赛程]";//抓取彩票信息
		String url = this.getSchedulePhpUrl();
		String logHeader = siteName+fetchLotteryInfo+"=="+url+"==抓取==第<"+getFetchPhase()+">期==";
		if(url==null||url.isEmpty()){
			logger.error(siteName+"==抓取==期号:"+getFetchPhase()+"==地址url:"+url+"不存在，返回null");
			return null;
		}
		String encoding = "GBK";
		
		String data=null;
		
		data = CoreFetcherUtils.URLGet(url, null, encoding);
		if (data == null || data.indexOf("404 Not Found") >= 0) {
			logger.error(logHeader+"data is null or 404 Not Found");
			return null;
		}
		Parser parser = Parser.createParser(data,  encoding);
		
		NodeFilter cssFilter = new CssSelectorNodeFilter("table[id='vsTable']");
		NodeList nodeList = null;
		try {
			nodeList = parser.extractAllNodesThatMatch(cssFilter);
		} catch (ParserException e2){
			logger.error(logHeader+"数据解析错误=="+e2.getMessage(), e2);
			return null;
		}
		FootballScheduleItem footballScheduleItem = null;
		phpScheduleList = new ArrayList<FootballScheduleItem>();
		
		int matchIndex; // 场次顺序
		String league; // 联赛或赛事名称
		Date matchTime; // 比赛时间
		
		String homeTeam; // 主队
		String awayTeam; // 客队
		
		try{
			TableTag tableTag = (TableTag)nodeList.elementAt(0);
			TableRow[] rowsPhase=tableTag.getRows();
			TableColumn[] columnPhase = null;
			boolean wholeVsFlag = true;//是否完整对阵比赛
			for(int i=1;i<rowsPhase.length;i++){
				if(wholeVsFlag){
					footballScheduleItem = new FootballScheduleItem();
				}
				columnPhase=rowsPhase[i].getColumns();
				// 奇数行 一般为9列
				if(columnPhase.length>4){
					// 场次序列号   0
					String matchIndexStr = columnPhase[0].getStringText().trim();
					if(matchIndexStr != null && !matchIndexStr.isEmpty()){
						matchIndex = Integer.parseInt(matchIndexStr);
						footballScheduleItem.setMatchIndex(matchIndex);
					}else{
						logger.error("{}发生错误,表格内容不合法,可能赛程不存在,请确认,本次500万的php方式抓取结束",logHeader);
						break;
					}
					
					// 赛事    1
					league = columnPhase[1].toPlainTextString().trim();
					league = CoreStringUtils.trimAll(league); 
					footballScheduleItem.setLeague(league);
					
					// 比赛时间   2
					String matchTimeStr = columnPhase[2].toPlainTextString().trim();
					String yearHead = "20"+getFetchPhase().substring(0,2);
					matchTimeStr = yearHead + "-" + matchTimeStr + ":00";
					matchTime = CoreDateUtils.parseLongDate(matchTimeStr);
					footballScheduleItem.setMatchTime(matchTime);
					
					// 主队名称   3
					//homeTeam = columnPhase[3].getChildren().elementAt(0).getChildren().elementAt(1).toPlainTextString().trim();
					homeTeam = getTableColumnChildText(columnPhase[3]);
					homeTeam = homeTeam.replaceAll("\\&nbsp;", "");
					footballScheduleItem.setHomeTeam(homeTeam);
					
					// 彩期
					footballScheduleItem.setPhase(getFetchPhase());
					
					wholeVsFlag = false;
				}
				// 偶数行一般为4列
				else{
					awayTeam = getTableColumnChildText(columnPhase[0]);
					awayTeam = awayTeam.replaceAll("\\&nbsp;", "");
					footballScheduleItem.setAwayTeam(awayTeam);
					
					wholeVsFlag = true;//解析完数行才是一场完整的比赛
					if(footballScheduleItem != null){
						phpScheduleList.add(footballScheduleItem);
					}
					
				}
			}//end for
		}catch(Exception e1){
			logger.error(logHeader+"页面错误=="+e1.getMessage(),e1);
			return null;
		}
		
		
		return phpScheduleList;
	}
	/**
	 * 获取500wan的Php赛程地址
	 * @return
	 */
	protected String getSchedulePhpUrl(){
		String phpUrl = String.format(JQC_SCHEDULE_FETCH_PHP_URL_500WAN, getFetchPhase());
		return phpUrl;
	}
	/**
	 * 获取表格列的内部文本 <br/>
	 * <!--ex:<td><a href="http://liansai.500wan.com/team_data.php?teamid=704" target="_blank"><span class="gray">主</span> 博尔顿</a></td>-->
	 * <!-- 返回 博尔顿 -->
	 * @param column
	 * @return  
	 */
	protected String getTableColumnChildText(TableColumn column){
		String s = null;
		if(column != null){
			NodeList nl = column.getChildren();
			if(nl != null && nl.size()>0){
				Node n = nl.elementAt(0);
				if(n != null && n instanceof LinkTag){
					NodeList childList = n.getChildren();
					if(childList != null && childList.size()>=2 ){
						Node childNode = childList.elementAt(1);
						s = childNode.toPlainTextString().trim();
					}
				}
			}
		}
		return s;
	}
}
