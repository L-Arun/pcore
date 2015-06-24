package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.AbstractLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.FrequentLotteryDrawFetchWorker500Wan;
import com.lehecai.core.util.CoreFetcherUtils;

/**
 * 通用高频开奖结果抓取
 * @author leiming
 *
 */
public class FrequentLotteryDrawFetcher extends BaseLotteryDrawFetcher{
	
	private LotteryType lotteryType;
	
	protected LotteryType getLotteryType() {
		return lotteryType;
	}
	
	protected FrequentLotteryDrawFetcher() {
		
	}
	
	public FrequentLotteryDrawFetcher(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}
	
	public FrequentLotteryDrawFetcher(Integer lotteryTypeId) {
		LotteryType lotteryType = LotteryType.getItem(lotteryTypeId);
		this.lotteryType = lotteryType;
	}
	
	protected LotteryDraw fetch500Wan(String phase) {
		AbstractLotteryDrawFetchWorker fetchWorker = new FrequentLotteryDrawFetchWorker500Wan(this.getLotteryType());
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
