package com.lehecai.core.lottery.fetcher.football.impl.worker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.football.AbstractFootballScheduleFetchWorker;
import com.lehecai.core.lottery.fetcher.football.FootballScheduleItem;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreFetcherUtils;
import com.lehecai.core.util.CoreStringUtils;



/**
 * Plot 远程 6场半进球赛 程数据抓取
 * @author leiming
 *
 */
public class FootballScheduleFetch10WorkerPlotRemote extends AbstractFootballScheduleFetchWorker {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private final static String FETCHER_URL_PLOT_REMOTE = "http://www.lehecai.com/api/match_schedule/schedule.php";
	protected String siteName = "Plot Remote";

	@Override
	public List<FootballScheduleItem> fetchFootballSchedule(String phase) {
		String fetchLotteryInfo = "["+getLotteryType().getName().trim()+" 足球赛程]";//抓取彩票信息

		this.setFetchPhase(phase);
		String url = this.getScheduleUrl();
		if(url==null||url.isEmpty()){
			logger.error(siteName+"==抓取==期号:"+phase+"==地址url:"+url+"不存在，返回null");
			return null;
		}
		String encoding = CharsetConstant.CHARSET_UTF8;
		String phaseInfo = "第<"+phase+">期";//彩期信息
		String logHeader = siteName+fetchLotteryInfo+"=="+url+"==抓取=="+phaseInfo+"==";
		
		logger.info(logHeader+"开始==");
		
		String data=null;
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("lotteryType", String.valueOf(getLotteryType().getValue()));
		if(phase != null){
			params.put("phase", phase);
		}else{
			params.put("phase", "");
		}
		params.put("action", "get6cMatch");
		
		data = CoreFetcherUtils.URLGet(url, params, encoding);
		if (data == null || data.indexOf(CoreFetcherUtils.PLOT_REMOTE_FETCH_ERROR) >= 0 || data.isEmpty()) {
			logger.error(logHeader+"data is null or "+CoreFetcherUtils.PLOT_REMOTE_FETCH_ERROR);
			return null;
		}
		data = CoreStringUtils.unicodeToString(data);
		List<FootballScheduleItem> footballScheduleItems = CoreFetcherUtils.getScheduleListFromPlot(data);
		
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
		return FETCHER_URL_PLOT_REMOTE;
	}

}
