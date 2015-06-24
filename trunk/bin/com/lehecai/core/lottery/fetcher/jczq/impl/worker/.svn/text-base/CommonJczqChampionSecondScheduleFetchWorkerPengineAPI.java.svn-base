package com.lehecai.core.lottery.fetcher.jczq.impl.worker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.FetchFailedException;
import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.JczqRaceStatus;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.jczq.AbstractJczqChampionSecondScheduleFetchWorker;
import com.lehecai.core.lottery.fetcher.jczq.IJczqChampionSecondScheduleFetcher;
import com.lehecai.core.lottery.fetcher.jczq.JczqChampionSecondScheduleItem;
import com.lehecai.core.lottery.fetcher.jczq.impl.CommonJczqChampionSecondScheduleFetcher;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreHttpUtils;
import com.lehecai.core.util.CoreJSONUtils;

/**
 * 通用竞彩足球猜冠亚军赛程抓取实现类
 * @author qatang
 *
 */
public class CommonJczqChampionSecondScheduleFetchWorkerPengineAPI extends AbstractJczqChampionSecondScheduleFetchWorker{
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	

	private static final String PROCESS_CODE = "10001"; 
	private static final String PROCESS_TYPE = "jczqGyj";
	
	private static final String URL_PENGINE_API = "http://phase.lehecai.com:16041/JcServlet";
	//private static final String URL_PENGINE_API = "http://172.16.8.71:8080/devpengine/JcServlet";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<JczqChampionSecondScheduleItem> fetchJczqChampionSecondSchedule(String phase)
			throws FetchFailedException {
		List<String> list = null;
		try {
			list = CoreHttpUtils.getUrl(URL_PENGINE_API, "ProcessCode=" + PROCESS_CODE + "&phase=" + phase + "&type=" + PROCESS_TYPE, CharsetConstant.CHARSET_UTF8, 100000);
		} catch (Exception e) {
			logger.error("竞彩足球猜冠亚军抓取官方赛程失败", e);
			throw new FetchFailedException(e.getMessage());
		}
		if (list == null || list.size() == 0) {
			logger.error("未获取到竞彩足球猜冠亚军官方赛程");
			throw new FetchFailedException("未获取到竞彩足球猜冠亚军官方赛程");
		}
		String matches = list.get(0);
		if (matches == null || "".equals(matches)) {
			logger.error("未获取到竞彩足球猜冠亚军官方赛程");
			throw new FetchFailedException("未获取到竞彩足球猜冠亚军官方赛程");
		}
		JSONArray jsonArray = null;
		try {
			jsonArray = JSONArray.fromObject(matches);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		if (jsonArray == null) {
			logger.error("转换竞彩足球猜冠亚军官方赛程出错");
			throw new FetchFailedException("转换竞彩足球猜冠亚军官方赛程出错");
		}
		if (jsonArray.isEmpty()) {
			logger.warn("竞彩足球猜冠亚军官方赛程为空");
			return null;
		}
		List<JczqChampionSecondScheduleItem> jczqChampionSecondScheduleItems = new ArrayList<JczqChampionSecondScheduleItem>();
		for (Iterator iterator = jsonArray.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			if (object == null) {
				throw new FetchFailedException("转换竞彩足球猜冠亚军官方赛程出错");
			}
			JczqChampionSecondScheduleItem item = new JczqChampionSecondScheduleItem();
			
			item.setMatchNum(CoreJSONUtils.getInt(object, "matchNum") + "");
			item.setOfficialNum(CoreJSONUtils.getString(object, "officialNum"));
			item.setPhase(phase);
			item.setStatus(JczqRaceStatus.getItem(CoreJSONUtils.getInt(object, "status")));
			item.setHomeTeam(CoreJSONUtils.getString(object, "homeTeam"));
			item.setAwayTeam(CoreJSONUtils.getString(object, "awayTeam"));
			jczqChampionSecondScheduleItems.add(item);
		}
		return jczqChampionSecondScheduleItems;
	}
	public static void main(String[] args) {
		IJczqChampionSecondScheduleFetcher fetcher = new CommonJczqChampionSecondScheduleFetcher();
		List<JczqChampionSecondScheduleItem> jczqChampionSecondScheduleItemList = null;
		try {
			jczqChampionSecondScheduleItemList = fetcher.fetch("201201", FetcherType.T_PENGINEAPI);
		} catch (UnsupportedFetcherTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FetchFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (JczqChampionSecondScheduleItem item : jczqChampionSecondScheduleItemList) {
			System.out.println(item.getJczqScheduleInfo());
		}
	}
}
