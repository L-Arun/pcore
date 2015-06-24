package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import java.util.HashMap;
import java.util.Map;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.AbstractLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.CountryLotteryDrawFetchWorkerSTARLOTT;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.LocalityLotteryDrawFetchWorker500Wan;
import com.lehecai.core.util.CoreFetcherUtils;

/**
 * 东方6+1 结果抓取
 * @author leiming
 *
 */
public class LotteryDrawFetcher54 extends BaseLotteryDrawFetcher{
	
	private static final LotteryType lotteryType = LotteryType.DF6J1;
	
	private static final Map<String, String> shengxiaoMap = new HashMap<String, String>();
	
	static {
		shengxiaoMap.put("鼠", "01");
		shengxiaoMap.put("牛", "02");
		shengxiaoMap.put("虎", "03");
		shengxiaoMap.put("兔", "04");
		shengxiaoMap.put("龙", "05");
		shengxiaoMap.put("蛇", "06");
		shengxiaoMap.put("马", "07");
		shengxiaoMap.put("羊", "08");
		shengxiaoMap.put("猴", "09");
		shengxiaoMap.put("鸡", "10");
		shengxiaoMap.put("狗", "11");
		shengxiaoMap.put("猪", "12");
	}
	
	protected LotteryDraw fetch500Wan(String phase) {
		String queryPhase = phase;
		
		
		//500w地方列表抓取东方6+1
		AbstractLotteryDrawFetchWorker fetchWorker = new LocalityLotteryDrawFetchWorker500Wan(lotteryType);
		
		LotteryDraw resultListObj = fetchWorker.fetchResult(queryPhase);
		LotteryDraw resultDetailObj = fetchWorker.fetchResultDetail(queryPhase);
		
		LotteryDraw resultObj = CoreFetcherUtils.getComparedResult(resultListObj, resultDetailObj);
		// 将抓取的期号转换回系统期号
		if (phase != null && phase.length() == 7) {
			resultObj.setPhase(phase);
		}
		//处理生肖
		resultObj = handleLotteryDraw(resultObj);
		return resultObj;
	}

	@Override
	protected FetcherType getDefaultFetcherType() {
		// 默认使用500wan抓取
		return FetcherType.T_500WAN;
	}
	
	protected LotteryDraw fetchSTARLOTT(String phase) {
		String queryPhase = phase;
		
		// 将系统期号转换成和STARLOTT匹配的期号
		if (phase != null && phase.length() == 7) {
			queryPhase = phase.substring(2);
		}
		//星彩网全国抓取页面东方6+1
		AbstractLotteryDrawFetchWorker fetchWorker = new CountryLotteryDrawFetchWorkerSTARLOTT(lotteryType);
		
		LotteryDraw resultListObj = fetchWorker.fetchResult(queryPhase);
		LotteryDraw resultDetailObj = fetchWorker.fetchResultDetail(queryPhase);
		
		LotteryDraw resultObj = CoreFetcherUtils.getComparedResult(resultListObj, resultDetailObj);
		
		// 将抓取的期号转换回系统期号
		if (phase != null && phase.length() == 7) {
			resultObj.setPhase(phase);
		}
		//处理生肖
		resultObj = handleLotteryDraw(resultObj);
		return resultObj;
	}
	
	/**
	 * 处理彩票开奖结果
	 * @param lotteryDraw
	 * @return
	 */
	protected LotteryDraw handleLotteryDraw(LotteryDraw lotteryDraw){
		if(lotteryDraw==null){
			return null;
		}
		String result = lotteryDraw.getResult();
		if(result!=null){
			String[] resultArray = result.split(",");
			resultArray[resultArray.length-1] = getAnimalNumber(resultArray[resultArray.length-1]);
			result = CoreFetcherUtils.mergeStringArray(resultArray, ",");
			lotteryDraw.setResult(result);
		}
		return lotteryDraw;
	}
	/**
	 * 获取生肖编号
	 * @param animalName
	 * @return
	 */
	protected String getAnimalNumber(String animalName) {
		if (animalName == null || animalName.isEmpty()) {
			return null;
		}
		return shengxiaoMap.get(animalName.trim()).toString();
	}
}
