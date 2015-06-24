package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import java.util.ArrayList;
import java.util.List;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDrawPrizeItem;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.AbstractLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.LotteryDrawFetch8Worker500Wan;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.LotteryDrawFetch8WorkerSTARLOTT;
import com.lehecai.core.util.CoreFetcherUtils;

/**
 * 胜负任9 结果抓取
 * @author leiming
 *
 */
public class LotteryDrawFetcher8 extends BaseLotteryDrawFetcher{
	
	protected LotteryDraw fetch500Wan(String phase) {
		String queryPhase = phase;
		
		// 将系统期号转换成和500wan匹配的期号
		if (phase != null && phase.length() == 7) {
			queryPhase = phase.substring(2);
		}
		//500w地方列表抓取
		AbstractLotteryDrawFetchWorker fetchWorker = new LotteryDrawFetch8Worker500Wan();
		
		LotteryDraw resultListObj = fetchWorker.fetchResult(queryPhase);
		LotteryDraw resultDetailObj = fetchWorker.fetchResultDetail(queryPhase);
		
		LotteryDraw resultObj = CoreFetcherUtils.getComparedResult(resultListObj, resultDetailObj);
		// 将抓取的期号转换回系统期号
		if (phase != null && phase.length() == 7) {
			resultObj.setPhase(phase);
		}
		// start 胜负彩任九特殊处理奖项
		handleLotteryDraw(resultObj);
		// end 胜负彩任九特殊处理奖项
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
		AbstractLotteryDrawFetchWorker fetchWorker = new LotteryDrawFetch8WorkerSTARLOTT();
		
		LotteryDraw resultListObj = fetchWorker.fetchResult(queryPhase);
		LotteryDraw resultDetailObj = fetchWorker.fetchResultDetail(queryPhase);
		
		LotteryDraw resultObj = CoreFetcherUtils.getComparedResult(resultListObj, resultDetailObj);
		
		// 将抓取的期号转换回系统期号
		if (phase != null && phase.length() == 7) {
			resultObj.setPhase(phase);
		}
		// start 胜负彩任九特殊处理奖项
		handleLotteryDraw(resultObj);
		// end 胜负彩任九特殊处理奖项
		return resultObj;
	}
	/**
	 * 处理彩票开奖结果
	 * @param lotteryDraw
	 * @return
	 */
	protected void handleLotteryDraw(LotteryDraw lotteryDraw){
		if(lotteryDraw != null){
			List<LotteryDrawPrizeItem> prizeItems = lotteryDraw.getResultDetail();
			List<LotteryDrawPrizeItem> finalPrizeItems = null;
			if(prizeItems != null && prizeItems.size() == 3){
				finalPrizeItems = new ArrayList<LotteryDrawPrizeItem>();
				finalPrizeItems.add(prizeItems.get(2));//去除前两项,只保留任九
				lotteryDraw.setResultDetail(finalPrizeItems);
			}
		}
	}
}
