package com.lehecai.core.lottery.fetcher.jczq.impl.worker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.api.ApiConstant;
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

/**
 * 通用竞彩足球猜冠亚军赛程抓取实现类
 * @author qatang
 *
 */
public class CommonJczqChampionSecondScheduleFetchWorkerOfficial extends AbstractJczqChampionSecondScheduleFetchWorker{
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	protected static final String SCHEDULE_URL = "http://info.sporttery.cn/interface/interface.php";
	
	protected static Map<String, String> phaseToActionMap = new HashMap<String, String>();
	
	static {
		//猜冠亚军彩期对应官方抓取地址参数值
		phaseToActionMap.put("201201", "euro_list2012");
	}
 	
	@Override
	public List<JczqChampionSecondScheduleItem> fetchJczqChampionSecondSchedule(String phase)
			throws FetchFailedException {
		if (StringUtils.isEmpty(phase)) {
			throw new FetchFailedException("通用竞彩足球猜冠亚军赛程官方抓取实现类抓取失败：参数phase不能为空");
		}
		String action = phaseToActionMap.get(phase);
		if (StringUtils.isEmpty(phase)) {
			throw new FetchFailedException("通用竞彩足球猜冠亚军赛程官方抓取实现类抓取失败：未找到对应phase=" + phase + "的官方action参数");
		}
		Map<String, String> params = new HashMap<String, String>();
		params.put("action", action);
		params.put("round", String.valueOf(new Random().nextInt()));
		
		List<String> result = null;
		try {
			result = CoreHttpUtils.postUrl(SCHEDULE_URL, params, CharsetConstant.CHARSET_GB2312, ApiConstant.API_REQUEST_TIME_OUT_LONG);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		if (result == null || result.size() == 0) {
			throw new FetchFailedException("通用竞彩足球猜冠亚军赛程官方抓取实现类抓取失败：phase=" + phase + "，官方action=" + action + "未抓取到任何赛程");
		}
		String jsonStr = result.get(0);
		if (result == null || result.size() == 0) {
			throw new FetchFailedException("通用竞彩足球猜冠亚军赛程官方抓取实现类抓取失败：phase=" + phase + "，官方action=" + action + "已抓取成功但是结果为空");
		}
		JSONObject jsonObject = null;
		try {
			jsonObject = JSONObject.fromObject(jsonStr);
		} catch (Exception e) {
			logger.error("通用竞彩足球猜冠亚军赛程官方抓取实现类抓取失败：抓取结果转换为json对象错误，jsonStr={}", jsonStr);
		}
		if (jsonObject == null) {
			throw new FetchFailedException("通用竞彩足球猜冠亚军赛程官方抓取实现类抓取失败：抓取结果转换为json对象失败，jsonStr=" + jsonStr + "");
		}
		String raceStr = null;
		try {
			raceStr = jsonObject.getString("second");
		} catch (Exception e) {
			logger.error("通用竞彩足球猜冠亚军赛程官方抓取实现类抓取失败：json对象没有champion属性");
		}
		if (StringUtils.isEmpty(raceStr)) {
			throw new FetchFailedException("通用竞彩足球猜冠亚军赛程官方抓取实现类抓取失败：json对象的champion属性对应的值为空");
		}
		
		String[] raceArray = StringUtils.split(raceStr, "|");
		if (raceArray == null || raceArray.length == 0) {
			throw new FetchFailedException("通用竞彩足球猜冠亚军赛程官方抓取实现类抓取失败：按照|拆分赛程后结果数组为空");
		}
		
		List<JczqChampionSecondScheduleItem> jczqChampionSecondScheduleItemList = new ArrayList<JczqChampionSecondScheduleItem>();
		for (String race : raceArray) {
			String[] propertyArray = StringUtils.split(race, "-");
			if (propertyArray == null || propertyArray.length == 0) {
				throw new FetchFailedException("通用竞彩足球猜冠亚军赛程官方抓取实现类抓取失败：按照-拆分单个属性后结果数组为空");
			}
			JczqChampionSecondScheduleItem item = new JczqChampionSecondScheduleItem();
			try {
				item.setPhase(phase);
				item.setMatchNum(Integer.valueOf(propertyArray[0]) + "");
				item.setOfficialNum(propertyArray[0]);
				String[] teamArray =  StringUtils.splitByWholeSeparator(propertyArray[1], "―");
				item.setHomeTeam(teamArray[0]);
				item.setAwayTeam(teamArray[1]);
				boolean flag = false;
				for (String statusName : propertyArray) {
					if (StringUtils.contains(statusName, "开售")) {
						flag = true;
						break;
					}
				}
				if (flag) {
					item.setStatus(JczqRaceStatus.OPEN);
				} else {
					item.setStatus(JczqRaceStatus.CLOSE);
				}
			} catch (Exception e) {
				throw new FetchFailedException("通用竞彩足球猜冠亚军赛程官方抓取实现类抓取失败：生成JczqChampionSecondScheduleItem对象时出错，请检查抓取结果数据结构jsonStr=" + jsonStr + "");
			}
			jczqChampionSecondScheduleItemList.add(item);
		}
		return jczqChampionSecondScheduleItemList;
	}
	public static void main(String[] args) {
		IJczqChampionSecondScheduleFetcher fetcher = new CommonJczqChampionSecondScheduleFetcher();
		List<JczqChampionSecondScheduleItem> jczqChampionSecondScheduleItemList = null;
		try {
			jczqChampionSecondScheduleItemList = fetcher.fetch("201201", FetcherType.T_OFFICIAL);
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
