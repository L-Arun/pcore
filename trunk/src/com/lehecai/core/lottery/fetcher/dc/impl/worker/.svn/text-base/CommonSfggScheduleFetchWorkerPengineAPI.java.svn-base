package com.lehecai.core.lottery.fetcher.dc.impl.worker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.dc.AbstractSfggScheduleFetchWorker;
import com.lehecai.core.lottery.fetcher.dc.SfggScheduleItem;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreDateUtils;
import com.lehecai.core.util.CoreHttpUtils;

public class CommonSfggScheduleFetchWorkerPengineAPI extends
		AbstractSfggScheduleFetchWorker {

	protected final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass().getName());
	private static final String PROCESS_CODE = "20003"; 
	
	//private static final String URL_PENGINE_API = "http://phase.lehecai.com:16041/LsshServlet";
	private static final String URL_PENGINE_API = "http://172.16.8.71:8080/devpengine/LsshServlet";

	@SuppressWarnings("unchecked")
	@Override
	public List<SfggScheduleItem> fetchSfggSchedule(String phase) {
		List<String> list = null;
		try {
			list = CoreHttpUtils.getUrl(URL_PENGINE_API, "ProcessCode=" + PROCESS_CODE + "&phase=" + phase, CharsetConstant.CHARSET_UTF8, 100000);
		} catch (Exception e) {
			logger.error("胜负过关抓取赛程失败", e);
			return null;
		}
		if (list == null || list.size() == 0) {
			logger.error("胜负过关抓取赛程失败");
			return null;
		}
		String matches = list.get(0);
		if (matches == null || "".equals(matches)) {
			logger.error("未获取到胜负过关赛程");
			return null;
		}
		JSONArray jsonArray = JSONArray.fromObject(matches);
		if (jsonArray.isEmpty()) {
			logger.error("未获取到胜负过关赛程");
			return null;
		}
		List<SfggScheduleItem> raceList = new ArrayList<SfggScheduleItem>();
		for (Iterator iterator = jsonArray.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			
			if (object == null) {
				return null;
			}
			SfggScheduleItem item = new SfggScheduleItem();
			
			item.setPhase(object.getString("phase"));
			item.setMatchIndex(object.getInt("matchIndex"));
			item.setLeague(object.getString("league"));
			item.setHomeTeam(object.getString("homeTeam"));
			item.setAwayTeam(object.getString("awayTeam"));
			item.setMatchTime(CoreDateUtils.parseLongDate(object.getString("matchTime")));
			item.setHandicap(object.getString("handicap"));
			item.setMatchDesc(object.getString("matchDesc"));
			
			raceList.add(item);
		}
		return raceList;
	}
	public static void main(String[] args) {
		AbstractSfggScheduleFetchWorker worker = new CommonSfggScheduleFetchWorkerPengineAPI();
		List<SfggScheduleItem> raceList = worker.fetchSfggSchedule("120703");
		for (SfggScheduleItem item : raceList) {
			System.out.println(item.getSfggScheduleInfo());
		}
	}
}
