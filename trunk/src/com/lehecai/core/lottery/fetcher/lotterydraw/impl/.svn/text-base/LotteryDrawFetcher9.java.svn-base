package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.AbstractLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.LotteryDrawFetch9Worker500Wan;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.LotteryDrawFetch9WorkerSTARLOTT;
import com.lehecai.core.util.CoreFetcherUtils;

/**
 * 4场进球 结果抓取
 * @author leiming
 *
 */
public class LotteryDrawFetcher9 extends BaseLotteryDrawFetcher{
	
	protected LotteryDraw fetch500Wan(String phase) {
		String queryPhase = phase;
		
		// 将系统期号转换成和500wan匹配的期号
		if (phase != null && phase.length() == 7) {
			queryPhase = phase.substring(2);
		}
		//500w地方列表抓取
		AbstractLotteryDrawFetchWorker fetchWorker = new LotteryDrawFetch9Worker500Wan();
		
		LotteryDraw resultListObj = fetchWorker.fetchResult(queryPhase);
		LotteryDraw resultDetailObj = fetchWorker.fetchResultDetail(queryPhase);
		
		LotteryDraw resultObj = CoreFetcherUtils.getComparedResult(resultListObj, resultDetailObj);
		// 将抓取的期号转换回系统期号
		if (phase != null && phase.length() == 7) {
			resultObj.setPhase(phase);
		}
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
		//星彩网全国抓取页面
		AbstractLotteryDrawFetchWorker fetchWorker = new LotteryDrawFetch9WorkerSTARLOTT();
		
		LotteryDraw resultListObj = fetchWorker.fetchResult(queryPhase);
		LotteryDraw resultDetailObj = fetchWorker.fetchResultDetail(queryPhase);
		
		LotteryDraw resultObj = CoreFetcherUtils.getComparedResult(resultListObj, resultDetailObj);
		
		// 将抓取的期号转换回系统期号
		if (phase != null && phase.length() == 7) {
			resultObj.setPhase(phase);
		}
		return resultObj;
	}
}
