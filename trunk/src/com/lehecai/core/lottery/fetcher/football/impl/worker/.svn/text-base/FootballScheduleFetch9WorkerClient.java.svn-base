/**
 * 
 */
package com.lehecai.core.lottery.fetcher.football.impl.worker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.football.AbstractFootballScheduleFetchWorker;
import com.lehecai.core.lottery.fetcher.football.FootballScheduleItem;
import com.lehecai.core.queue.QueueConstant;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreDateUtils;
import com.lehecai.core.util.CoreHttpUtils;
import com.lehecai.core.util.CoreStringUtils;



/**
 * 老版客户端4场半赛程数据抓取
 * @author qatang
 *
 */
public class FootballScheduleFetch9WorkerClient extends AbstractFootballScheduleFetchWorker {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private final static String CLIENT_FETCHER_URL = "http://www.lehecai.com/lottery/lotteryTermQueryForJsonPrize.jhtml";

	@Override
	public List<FootballScheduleItem> fetchFootballSchedule(String phase) {
		// TODO Auto-generated method stub
		phase = phase == null ? "" : phase;
		List<String> result;
		try {
			result = CoreHttpUtils.postUrl(this.getScheduleUrl(), "action=get4cMatch&phase=" + phase, CharsetConstant.CHARSET_UTF8, QueueConstant.HTTP_TIME_OUT_DEFAULT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage(), e);
			return null;
		}
		if (result == null || result.isEmpty()) {
			logger.error("响应结果为空，非法");
			return null;
		}
		
		String responseStr = result.get(0);
		logger.info("Response string: {}", responseStr);
		
		// 转换unicode到可识别的中文
		responseStr = CoreStringUtils.unicodeToString(responseStr);
		
		JSONArray array = null;
		try {
			array = JSONArray.fromObject(responseStr);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
		List<FootballScheduleItem> list = new ArrayList<FootballScheduleItem>();
		for(Object obj : array){
			JSONObject json = (JSONObject)obj;
			FootballScheduleItem footballScheduleItem = new FootballScheduleItem();
			footballScheduleItem.setPhase(json.getString("phase"));
			footballScheduleItem.setMatchIndex(json.getInt("matchIndex"));
			footballScheduleItem.setLeague(json.getString("league"));
			footballScheduleItem.setHomeTeam(json.getString("homeTeam"));
			footballScheduleItem.setAwayTeam(json.getString("awayTeam"));
			if(json.getString("matchTime") != null && !"".equals(json.getString("matchTime"))){	
				footballScheduleItem.setMatchTime(CoreDateUtils.parseDate(json.getString("matchTime"), "yyyy-MM-dd HH:mm"));
			}
			list.add(footballScheduleItem);
		}
		return list;
	}
	@Override
	public String getScheduleUrl() {
		// TODO Auto-generated method stub
		return CLIENT_FETCHER_URL;
	}

}
