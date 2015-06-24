package com.lehecai.core.lottery.fetcher.dc.impl.worker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.SfggSPType;
import com.lehecai.core.lottery.fetcher.dc.AbstractSfggInstantSPFetcherWorker;
import com.lehecai.core.lottery.fetcher.dc.SfggInstantSPItem;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreHttpUtils;
import com.lehecai.core.util.CoreJSONUtils;

/**
 * 胜负过关pengineAPI抓取实现类
 * @author qatang
 *
 */
public class CommonSfggInstantSPFetchWorkerPengineAPI extends AbstractSfggInstantSPFetcherWorker{
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private static final String PROCESS_CODE = "20002"; 
	
	//private static final String URL_PENGINE_API = "http://phase.lehecai.com:16041/LsshServlet";
	private static final String URL_PENGINE_API = "http://172.16.8.71:8080/devpengine/LsshServlet";

	@SuppressWarnings("unchecked")
	public List<SfggInstantSPItem> fetchSfggInstantSP(String phase){
		List<String> list = null;
		try {
			list = CoreHttpUtils.getUrl(URL_PENGINE_API, "ProcessCode=" + PROCESS_CODE + "&phase=" + phase, CharsetConstant.CHARSET_UTF8, 100000);
		} catch (Exception e) {
			logger.error("胜负过关抓取官方即时sp失败", e);
			return null;
		}
		if (list == null || list.size() == 0) {
			logger.error("胜负过关抓取官方即时sp失败");
			return null;
		}
		String matches = list.get(0);
		if (matches == null || "".equals(matches)) {
			logger.error("未获取到胜负过关官方即时sp");
			return null;
		}
		JSONArray jsonArray = JSONArray.fromObject(matches);
		if (jsonArray.isEmpty()) {
			logger.error("未获取到胜负过关官方即时sp");
			return null;
		}
		List<SfggInstantSPItem> spList = new ArrayList<SfggInstantSPItem>();
		for (Iterator iterator = jsonArray.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			
			if (object == null) {
				return null;
			}
			SfggInstantSPItem item = new SfggInstantSPItem();
			
			item.setPhase(object.getString("phase"));
			item.setMatchIndex(object.getInt("matchIndex"));
			item.setLeague(object.getString("league"));
			item.setHomeTeam(object.getString("homeTeam"));
			item.setAwayTeam(object.getString("awayTeam"));
			item.setMatchDesc(object.getString("matchDesc"));
			
			String spmap = object.getString("spmap");
			JSONObject spObj = JSONObject.fromObject(spmap);
			
			Map<SfggSPType, String> map = new HashMap<SfggSPType, String>();
			map.put(SfggSPType.SFP_S, CoreJSONUtils.getString(spObj, "sf_s"));
			map.put(SfggSPType.SFP_F, CoreJSONUtils.getString(spObj, "sf_f"));
				
			item.setSpmap(map);
			
			spList.add(item);
		}
		return spList;
	}
	
	public static void main(String[] args) {
		AbstractSfggInstantSPFetcherWorker worker = new CommonSfggInstantSPFetchWorkerPengineAPI();
		List<SfggInstantSPItem> raceList = worker.fetchSfggInstantSP("120703");
		for (SfggInstantSPItem item : raceList) {
			System.out.println(item.getMatchIndex());
		}
	}
}
