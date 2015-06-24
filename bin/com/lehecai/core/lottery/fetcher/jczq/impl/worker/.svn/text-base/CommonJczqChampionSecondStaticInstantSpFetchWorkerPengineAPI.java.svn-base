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
import com.lehecai.core.lottery.fetcher.jczq.AbstractJczqChampionSecondStaticInstantSpFetchWorker;
import com.lehecai.core.lottery.fetcher.jczq.IJczqChampionSecondStaticInstantSpFetcher;
import com.lehecai.core.lottery.fetcher.jczq.JczqChampionSecondStaticInstantSpItem;
import com.lehecai.core.lottery.fetcher.jczq.impl.CommonJczqChampionSecondStaticInstantSpFetcher;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreHttpUtils;
import com.lehecai.core.util.CoreJSONUtils;

/**
 * 竞彩足球猜冠亚军固定奖金即时sp抓取实现类
 * @author qatang
 *
 */
public class CommonJczqChampionSecondStaticInstantSpFetchWorkerPengineAPI extends AbstractJczqChampionSecondStaticInstantSpFetchWorker{
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private static final String PROCESS_CODE = "10004"; 
	private static final String PROCESS_TYPE = "jczqGyj"; 
	
	private static final String URL_PENGINE_API = "http://phase.lehecai.com:16041/JcServlet";
	//private static final String URL_PENGINE_API = "http://172.16.8.71:8080/devpengine/JcServlet";

	@SuppressWarnings("unchecked")
	public List<JczqChampionSecondStaticInstantSpItem> fetchJczqSp(String phase, LotteryType lotteryType){
		if (StringUtils.isEmpty(phase)) {
			logger.error("竞彩足球猜冠亚军抓取官方sp时，phase为空");
			return null;
		}
		
		List<String> list = null;
		try {
			list = CoreHttpUtils.getUrl(URL_PENGINE_API, "ProcessCode=" + PROCESS_CODE + "&phase=" + phase + "&type=" + PROCESS_TYPE, CharsetConstant.CHARSET_UTF8, 100000);
		} catch (Exception e) {
			logger.error("竞彩足球猜冠亚军抓取官方固定奖金即时sp失败", e);
			return null;
		}
		if (list == null || list.size() == 0) {
			logger.error("竞彩足球猜冠亚军抓取官方固定奖金即时sp失败");
			return null;
		}
		String matches = list.get(0);
		if (matches == null || "".equals(matches)) {
			logger.error("未获取到竞彩足球猜冠亚军官方固定奖金即时sp");
			return null;
		}
		JSONArray jsonArray = JSONArray.fromObject(matches);
		if (jsonArray.isEmpty()) {
			logger.error("未获取到竞彩足球猜冠亚军官方固定奖金即时sp");
			return null;
		}
		List<JczqChampionSecondStaticInstantSpItem> jczqChampionSecondStaticInstantSpItems = new ArrayList<JczqChampionSecondStaticInstantSpItem>();
		for (Iterator iterator = jsonArray.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			if (object == null) {
				return null;
			}
			JczqChampionSecondStaticInstantSpItem item = new JczqChampionSecondStaticInstantSpItem();
			
			item.setMatchNum(CoreJSONUtils.getString(object, "matchNum"));
			item.setPhase(phase);
			item.setHomeTeam(CoreJSONUtils.getString(object, "homeTeam"));
			item.setAwayTeam(CoreJSONUtils.getString(object, "awayTeam"));
			
			String spmap = CoreJSONUtils.getString(object, "spmap");
			JSONObject spObj = JSONObject.fromObject(spmap);
			
			Map<JczqSPType, String> map = new HashMap<JczqSPType, String>();
			map.put(JczqSPType.GYJ, CoreJSONUtils.getString(spObj, "sp"));
				
			item.setSpmap(map);
			jczqChampionSecondStaticInstantSpItems.add(item);
		}
		return jczqChampionSecondStaticInstantSpItems;
	}
	
	public static void main(String[] args) {
		IJczqChampionSecondStaticInstantSpFetcher fetcher = new CommonJczqChampionSecondStaticInstantSpFetcher();
		List<JczqChampionSecondStaticInstantSpItem> jczqChampionSecondStaticInstantSpItemList = null;
		try {
			jczqChampionSecondStaticInstantSpItemList = fetcher.fetch("201201", FetcherType.T_PENGINEAPI, LotteryType.JCZQ_GYJ);
		} catch (UnsupportedFetcherTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		for (JczqChampionSecondStaticInstantSpItem item : jczqChampionSecondStaticInstantSpItemList) {
			System.out.println(item.getSpmap());
		}
	}
}
