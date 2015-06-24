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
import com.lehecai.core.lottery.fetcher.jczq.AbstractJczqChampionScheduleFetchWorker;
import com.lehecai.core.lottery.fetcher.jczq.IJczqChampionScheduleFetcher;
import com.lehecai.core.lottery.fetcher.jczq.JczqChampionScheduleItem;
import com.lehecai.core.lottery.fetcher.jczq.impl.CommonJczqChampionScheduleFetcher;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreHttpUtils;
import com.lehecai.core.util.CoreJSONUtils;

/**
 * 通用竞彩足球猜冠军赛程抓取实现类
 * @author qatang
 *
 */
public class CommonJczqChampionScheduleFetchWorkerPengineAPI extends AbstractJczqChampionScheduleFetchWorker{
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private static final String PROCESS_CODE = "10001"; 
	private static final String PROCESS_TYPE = "jczqGj";
	
	private static final String URL_PENGINE_API = "http://phase.lehecai.com:16041/JcServlet";
	//private static final String URL_PENGINE_API = "http://172.16.8.71:8080/devpengine/JcServlet";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<JczqChampionScheduleItem> fetchJczqChampionSchedule(String phase)
			throws FetchFailedException {
		List<String> list = null;
		try {
			list = CoreHttpUtils.getUrl(URL_PENGINE_API, "ProcessCode=" + PROCESS_CODE + "&phase=" + phase + "&type=" + PROCESS_TYPE, CharsetConstant.CHARSET_UTF8, 100000);
		} catch (Exception e) {
			logger.error("竞彩足球猜冠军抓取官方赛程失败", e);
			throw new FetchFailedException(e.getMessage());
		}
		if (list == null || list.size() == 0) {
			logger.error("未获取到竞彩足球猜冠军官方赛程");
			throw new FetchFailedException("未获取到竞彩足球猜冠军官方赛程");
		}
		String matches = list.get(0);
		if (matches == null || "".equals(matches)) {
			logger.error("未获取到竞彩足球猜冠军官方赛程");
			throw new FetchFailedException("未获取到竞彩足球猜冠军官方赛程");
		}
		JSONArray jsonArray = null;
		try {
			jsonArray = JSONArray.fromObject(matches);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		if (jsonArray == null) {
			logger.error("转换竞彩足球猜冠军官方赛程出错");
			throw new FetchFailedException("转换竞彩足球猜冠军官方赛程出错");
		}
		if (jsonArray.isEmpty()) {
			logger.warn("竞彩足球猜冠军官方赛程为空");
			return null;
		}
		List<JczqChampionScheduleItem> jczqChampionScheduleItems = new ArrayList<JczqChampionScheduleItem>();
		for (Iterator iterator = jsonArray.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			if (object == null) {
				throw new FetchFailedException("转换竞彩足球猜冠军官方赛程出错");
			}
			JczqChampionScheduleItem item = new JczqChampionScheduleItem();
			
			item.setMatchNum(CoreJSONUtils.getInt(object, "matchNum") + "");
			item.setOfficialNum(CoreJSONUtils.getString(object, "officialNum"));
			item.setPhase(phase);
			item.setStatus(JczqRaceStatus.getItem(CoreJSONUtils.getInt(object, "status")));
			item.setTeam(CoreJSONUtils.getString(object, "teamName"));
			jczqChampionScheduleItems.add(item);
		}
		return jczqChampionScheduleItems;
	}
	public static void main(String[] args) {
		IJczqChampionScheduleFetcher fetcher = new CommonJczqChampionScheduleFetcher();
		List<JczqChampionScheduleItem> jczqChampionScheduleItemList = null;
		try {
			jczqChampionScheduleItemList = fetcher.fetch("201201", FetcherType.T_PENGINEAPI);
		} catch (UnsupportedFetcherTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FetchFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (JczqChampionScheduleItem item : jczqChampionScheduleItemList) {
			System.out.println(item.getJczqScheduleInfo());
		}
	}
}
