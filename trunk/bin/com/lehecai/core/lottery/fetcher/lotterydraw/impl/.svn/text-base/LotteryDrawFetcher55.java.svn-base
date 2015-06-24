package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.AbstractLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.LocalityLotteryDrawFetchWorkerSTARLOTT;
import com.lehecai.core.util.CoreFetcherUtils;

/**
 * 15选5 结果抓取
 * @author leiming
 *
 */
public class LotteryDrawFetcher55 extends LocalityLotteryDrawFetcher{
	public LotteryDrawFetcher55(){
		super(LotteryType.HD15X5);
	}
	//重写星彩抓取,星彩的彩期号是5位,要做处理
	@Override
	protected LotteryDraw fetchSTARLOTT(String phase) {
		String queryPhase = phase;
		
		// 将系统期号转换成和STARLOTT匹配的期号
		if (phase != null && phase.length() == 7) {
			queryPhase = phase.substring(2);
		}
		//星彩网全国抓取页面
		AbstractLotteryDrawFetchWorker fetchWorker = new LocalityLotteryDrawFetchWorkerSTARLOTT(this.getLotteryType());
		
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
