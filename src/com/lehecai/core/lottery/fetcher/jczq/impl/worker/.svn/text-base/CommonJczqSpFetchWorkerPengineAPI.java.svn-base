package com.lehecai.core.lottery.fetcher.jczq.impl.worker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jczq.AbstractJczqSpFetchWorker;
import com.lehecai.core.lottery.fetcher.jczq.JczqSpItem;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreHttpUtils;
import com.lehecai.core.util.CoreJSONUtils;
import com.lehecai.core.util.lottery.JczqUtil;

/**
 * 通用竞彩足球sp抓取实现类
 * @author qatang
 *
 */
public class CommonJczqSpFetchWorkerPengineAPI extends AbstractJczqSpFetchWorker{
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private static final String PROCESS_CODE = "10002"; 
	
	private static final String URL_PENGINE_API = "http://phase.lehecai.com:16041/JczqServlet";
	//private static final String URL_PENGINE_API = "http://172.16.10.195:8080/pengine/JczqServlet";

	@SuppressWarnings("unchecked")
	public List<JczqSpItem> fetchJczqSp(String officialDate){
		if (officialDate == null || "".equals(officialDate)) {
			logger.error("竞彩足球抓取官方sp时，officialDate为空");
			return null;
		}
		
		List<String> list = null;
		try {
			list = CoreHttpUtils.getUrl(URL_PENGINE_API, "ProcessCode=" + PROCESS_CODE + "&officialDate=" + officialDate, CharsetConstant.CHARSET_UTF8, 100000);
		} catch (Exception e) {
			logger.error("竞彩足球抓取官方sp失败", e);
			return null;
		}
		if (list == null || list.size() == 0) {
			logger.error("竞彩足球抓取官方sp失败");
			return null;
		}
		String matches = list.get(0);
		if (matches == null || "".equals(matches)) {
			logger.error("未获取到竞彩足球官方sp");
			return null;
		}
		JSONArray jsonArray = JSONArray.fromObject(matches);
		if (jsonArray.isEmpty()) {
			logger.error("未获取到竞彩足球官方sp");
			return null;
		}
		List<JczqSpItem> jczqSpItems = new ArrayList<JczqSpItem>();
		for (Iterator iterator = jsonArray.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			if (object == null) {
				return null;
			}
			JczqSpItem item = new JczqSpItem();
			
			item.setMatchNum(CoreJSONUtils.getString(object, "matchNum"));
			item.setOfficialNum(CoreJSONUtils.getString(object, "officialNum"));
			item.setOfficialDate(CoreJSONUtils.getDate(object, "officialDate", "yyyyMMdd"));
			item.setMatchName(JczqUtil.convertMatchName(CoreJSONUtils.getString(object, "matchName"), LotteryType.JCZQ_SPF, FetcherType.T_PENGINEAPI));
			item.setMatchDate(CoreJSONUtils.getDate(object, "matchDate", "yyyyMMddHHmmss"));
			item.setHomeTeam(CoreJSONUtils.getString(object, "homeTeam"));
			item.setAwayTeam(CoreJSONUtils.getString(object, "awayTeam"));
			item.setPrizeSpf(CoreJSONUtils.getString(object, "prizeSpf"));
			item.setPrizeBf(CoreJSONUtils.getString(object, "prizeBf"));
			item.setPrizeJqs(CoreJSONUtils.getString(object, "prizeJqs"));
			item.setPrizeBqc(CoreJSONUtils.getString(object, "prizeBqc"));
			item.setFirstHalf(CoreJSONUtils.getString(object, "firstHalf"));
			item.setSecondHalf(CoreJSONUtils.getString(object, "secondHalf"));
			item.setFinalScore(CoreJSONUtils.getString(object, "finalScore"));
			jczqSpItems.add(item);
		}
		return jczqSpItems;
	}
}
