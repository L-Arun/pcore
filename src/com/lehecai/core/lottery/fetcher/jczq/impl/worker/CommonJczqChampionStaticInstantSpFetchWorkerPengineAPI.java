package com.lehecai.core.lottery.fetcher.jczq.impl.worker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.JczqSPType;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jczq.AbstractJczqChampionStaticInstantSpFetchWorker;
import com.lehecai.core.lottery.fetcher.jczq.IJczqChampionStaticInstantSpFetcher;
import com.lehecai.core.lottery.fetcher.jczq.JczqChampionStaticInstantSpItem;
import com.lehecai.core.lottery.fetcher.jczq.impl.CommonJczqChampionStaticInstantSpFetcher;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreHttpUtils;
import com.lehecai.core.util.CoreJSONUtils;

/**
 * 竞彩足球猜冠军固定奖金即时sp抓取实现类
 * @author qatang
 *
 */
public class CommonJczqChampionStaticInstantSpFetchWorkerPengineAPI extends AbstractJczqChampionStaticInstantSpFetchWorker{
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private static final String PROCESS_CODE = "10004"; 
	private static final String PROCESS_TYPE = "jczqGj"; 
	
	private static final String URL_PENGINE_API = "http://phase.lehecai.com:16041/JcServlet";
	//private static final String URL_PENGINE_API = "http://172.16.8.71:8080/devpengine/JcServlet";

	@SuppressWarnings("unchecked")
	public List<JczqChampionStaticInstantSpItem> fetchJczqSp(String phase, LotteryType lotteryType){
		if (StringUtils.isEmpty(phase)) {
			logger.error("竞彩足球猜冠军抓取官方sp时，phase为空");
			return null;
		}
		
		List<String> list = null;
		try {
			list = CoreHttpUtils.getUrl(URL_PENGINE_API, "ProcessCode=" + PROCESS_CODE + "&phase=" + phase + "&type=" + PROCESS_TYPE, CharsetConstant.CHARSET_UTF8, 100000);
		} catch (Exception e) {
			logger.error("竞彩足球猜冠军抓取官方固定奖金即时sp失败", e);
			return null;
		}
		if (list == null || list.size() == 0) {
			logger.error("竞彩足球猜冠军抓取官方固定奖金即时sp失败");
			return null;
		}
		String matches = list.get(0);
		if (matches == null || "".equals(matches)) {
			logger.error("未获取到竞彩足球猜冠军官方固定奖金即时sp");
			return null;
		}
		JSONArray jsonArray = JSONArray.fromObject(matches);
		if (jsonArray.isEmpty()) {
			logger.error("未获取到竞彩足球猜冠军官方固定奖金即时sp");
			return null;
		}
		List<JczqChampionStaticInstantSpItem> jczqChampionStaticInstantSpItems = new ArrayList<JczqChampionStaticInstantSpItem>();
		for (Iterator iterator = jsonArray.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			if (object == null) {
				return null;
			}
			JczqChampionStaticInstantSpItem item = new JczqChampionStaticInstantSpItem();
			
			item.setMatchNum(CoreJSONUtils.getString(object, "matchNum"));
			item.setPhase(phase);
			item.setTeam(CoreJSONUtils.getString(object, "teamName"));
			
			String spmap = CoreJSONUtils.getString(object, "spmap");
			JSONObject spObj = JSONObject.fromObject(spmap);
			
			Map<JczqSPType, String> map = new HashMap<JczqSPType, String>();
			map.put(JczqSPType.GJ, CoreJSONUtils.getString(spObj, "sp"));
				
			item.setSpmap(map);
			jczqChampionStaticInstantSpItems.add(item);
		}
		return jczqChampionStaticInstantSpItems;
	}
	
	public static void main(String[] args) {
		IJczqChampionStaticInstantSpFetcher fetcher = new CommonJczqChampionStaticInstantSpFetcher();
		List<JczqChampionStaticInstantSpItem> jczqChampionStaticInstantSpItemList = null;
		try {
			jczqChampionStaticInstantSpItemList = fetcher.fetch("201201", FetcherType.T_PENGINEAPI, LotteryType.JCZQ_GJ);
		} catch (UnsupportedFetcherTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		for (JczqChampionStaticInstantSpItem item : jczqChampionStaticInstantSpItemList) {
			System.out.println(item.getSpmap());
		}
	}
}
