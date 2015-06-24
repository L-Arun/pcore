package com.lehecai.core.lottery.fetcher.football.impl.worker;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.football.AbstractFootballScheduleFetchWorker;
import com.lehecai.core.lottery.fetcher.football.FootballScheduleItem;
import com.lehecai.core.util.CoreFetcherUtils;
import com.lehecai.core.util.CoreXmlUtils;
/**
 * 6场半进球 足球赛程 500Wan 抓取worker
 * @author leiming
 *
 */
public class FootballScheduleFetch10Worker500Wan extends AbstractFootballScheduleFetchWorker{
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	//protected final static String BQC_SCHEDULE_FETCH_URL_500WAN = "http://trade.500wan.com/static/public/zc6/daigou/shtml/%s.shtml";//无赛事名称,废弃
	protected final static String BQC_SCHEDULE_FETCH_URL_500WAN = "http://www.500wan.com/static/info/odds/xml/lottery/zc6/%s_3.xml";
	protected String siteName = "500wan";
	
	
	@Override
	public List<FootballScheduleItem> fetchFootballSchedule(String phase) {
		String fetchLotteryInfo = "["+getLotteryType().getName().trim()+" 足球赛程]";//抓取彩票信息
		if(phase==null){
			logger.error(siteName+fetchLotteryInfo+"==抓取指定期号为"+phase+",期号不存在，返回null");
			return null;
		}
		this.setFetchPhase(phase);
		String url = this.getScheduleUrl();
		if(url==null||url.isEmpty()){
			logger.error(siteName+"==抓取==期号:"+phase+"==地址url:"+url+"不存在，返回null");
			return null;
		}
		String encoding = "GBK";
		String phaseInfo = "第<"+phase+">期";//彩期信息
		String logHeader = siteName+fetchLotteryInfo+"=="+url+"==抓取=="+phaseInfo+"==";
		
		logger.info(logHeader+"开始==");
		List<FootballScheduleItem> footballScheduleItems=null;
		
		String data=null;
		
		data = CoreFetcherUtils.URLGet(url, null, encoding);
		if (data == null || data.indexOf("404 Not Found") > 0) {
			logger.error(logHeader+"data is null or 404 Not Found");
			return null;
		}
		/* 此段为读取html内容,由于html内容中没有赛事,废弃,采用解析xml数据方式 delete by lm
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
		footballScheduleItems = CoreXmlUtils.getSFCScheduleList(data, phase, encoding);
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
		//判断是否在抓取列表页面时赋予了地址信息
		if(scheduleUrl==null||scheduleUrl.isEmpty()){
			//未指定情况
			if(getFetchPhase()==null||getFetchPhase().isEmpty()){
				return null;
			}else{
				scheduleUrl = String.format(BQC_SCHEDULE_FETCH_URL_500WAN, getFetchPhase());
				return scheduleUrl;
			}
		}else{
			//已指定
			return scheduleUrl;
		}
	}
}
