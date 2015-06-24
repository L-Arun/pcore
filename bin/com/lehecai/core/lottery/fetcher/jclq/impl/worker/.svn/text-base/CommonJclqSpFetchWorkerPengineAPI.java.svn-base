package com.lehecai.core.lottery.fetcher.jclq.impl.worker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jclq.AbstractJclqSpFetchWorker;
import com.lehecai.core.lottery.fetcher.jclq.JclqSpItem;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreHttpUtils;
import com.lehecai.core.util.CoreJSONUtils;
import com.lehecai.core.util.lottery.JclqUtil;

/**
 * 通用竞彩篮球sp抓取实现类
 * @author qatang
 *
 */
public class CommonJclqSpFetchWorkerPengineAPI extends AbstractJclqSpFetchWorker{
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private static final String PROCESS_CODE = "10002"; 
	
	private static final String URL_PENGINE_API = "http://phase.lehecai.com:16041/JclqServlet";
	//private static final String URL_PENGINE_API = "http://172.16.10.195:8080/pengine/JclqServlet";

	@SuppressWarnings("unchecked")
	public List<JclqSpItem> fetchJclqSp(String officialDate){
		if (officialDate == null || "".equals(officialDate)) {
			logger.error("竞彩篮球抓取官方sp时，officialDate为空");
			return null;
		}
		
		List<String> list = null;
		try {
			list = CoreHttpUtils.getUrl(URL_PENGINE_API, "ProcessCode=" + PROCESS_CODE + "&officialDate=" + officialDate, CharsetConstant.CHARSET_UTF8, 100000);
		} catch (Exception e) {
			logger.error("竞彩篮球抓取官方sp失败", e);
			return null;
		}
		if (list == null || list.size() == 0) {
			logger.error("竞彩篮球抓取官方sp失败");
			return null;
		}
		String matches = list.get(0);
		if (matches == null || "".equals(matches)) {
			logger.error("未获取到竞彩篮球官方sp");
			return null;
		}
		JSONArray jsonArray = JSONArray.fromObject(matches);
		if (jsonArray.isEmpty()) {
			logger.error("未获取到竞彩篮球官方sp");
			return null;
		}
		
		List<JclqSpItem> jclqSpItems = new ArrayList<JclqSpItem>();
		for (Iterator iterator = jsonArray.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			
			if (object == null) {
				return null;
			}
			JclqSpItem item = new JclqSpItem();
			
			item.setMatchNum(CoreJSONUtils.getString(object, "matchNum"));
			item.setOfficialNum(CoreJSONUtils.getInt(object, "officialNum"));
			item.setOfficialDate(CoreJSONUtils.getDate(object, "officialDate", "yyyyMMdd"));
			item.setMatchName(JclqUtil.convertMatchName(CoreJSONUtils.getString(object, "matchName"), LotteryType.JCLQ_SF, FetcherType.T_PENGINEAPI));
			item.setMatchDate(CoreJSONUtils.getDate(object, "matchDate", "yyyyMMddHHmmss"));
			item.setHomeTeam(CoreJSONUtils.getString(object, "homeTeam"));
			item.setAwayTeam(CoreJSONUtils.getString(object, "awayTeam"));
			item.setPrizeSf(CoreJSONUtils.getString(object, "prizeSf"));
			item.setPrizeRfsf(CoreJSONUtils.getString(object, "prizeRfsf"));
			item.setPrizeSfc(CoreJSONUtils.getString(object, "prizeSfc"));
			item.setPrizeDxf(CoreJSONUtils.getString(object, "prizeDxf"));
			item.setFirstQuarter(CoreJSONUtils.getString(object, "firstQuarter"));
			item.setSecondQuarter(CoreJSONUtils.getString(object, "secondQuarter"));
			item.setThirdQuarter(CoreJSONUtils.getString(object, "thirdQuarter"));
			item.setFourthQuarter(CoreJSONUtils.getString(object, "fourthQuarter"));
			item.setFinalScore(CoreJSONUtils.getString(object, "finalScore"));
			
			jclqSpItems.add(item);
		}
		
		return jclqSpItems;
	}
}
