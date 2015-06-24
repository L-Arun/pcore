package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.AbstractLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.LocalityLotteryDrawFetchWorker500Wan;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.LocalityLotteryDrawFetchWorkerSTARLOTT;
import com.lehecai.core.util.CoreFetcherUtils;

/**
 * 通用地方开奖结果抓取
 * @author leiming
 *
 */
public class LocalityLotteryDrawFetcher extends BaseLotteryDrawFetcher{
	
	private LotteryType lotteryType;
	
	protected LotteryType getLotteryType() {
		return lotteryType;
	}
	
	protected LocalityLotteryDrawFetcher() {
		
	}
	
	public LocalityLotteryDrawFetcher(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}
	
	public LocalityLotteryDrawFetcher(Integer lotteryTypeId) {
		LotteryType lotteryType = LotteryType.getItem(lotteryTypeId);
		this.lotteryType = lotteryType;
	}
	
	protected LotteryDraw fetch500Wan(String phase) {
		AbstractLotteryDrawFetchWorker fetchWorker = new LocalityLotteryDrawFetchWorker500Wan(this.getLotteryType());
		LotteryDraw resultListObj = fetchWorker.fetchResult(phase);
		LotteryDraw resultDetailObj = fetchWorker.fetchResultDetail(phase);
		LotteryDraw returnObj = CoreFetcherUtils.getComparedResult(resultListObj, resultDetailObj);
		return returnObj;
	}

	protected LotteryDraw fetchSTARLOTT(String phase) {
		AbstractLotteryDrawFetchWorker fetchWorker = new LocalityLotteryDrawFetchWorkerSTARLOTT(this.getLotteryType());
		LotteryDraw resultListObj = fetchWorker.fetchResult(phase);
		LotteryDraw resultDetailObj = fetchWorker.fetchResultDetail(phase);
		LotteryDraw returnObj = CoreFetcherUtils.getComparedResult(resultListObj, resultDetailObj);
		return returnObj;
	}

	@Override
	protected FetcherType getDefaultFetcherType() {
		// 默认使用500wan抓取
		return FetcherType.T_500WAN;
	}
}
