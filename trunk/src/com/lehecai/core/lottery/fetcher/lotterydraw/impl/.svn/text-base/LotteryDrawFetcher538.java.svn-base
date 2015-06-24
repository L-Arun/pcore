package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.AbstractLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.LotteryDrawFetchWorkerZJTC;
import com.lehecai.core.util.CoreFetcherUtils;

public class LotteryDrawFetcher538 extends BaseLotteryDrawFetcher {

	private static final LotteryType lotteryType = LotteryType.A_ZJ6;
	
	protected LotteryDraw fetchOfficial(String phase) {
		
		AbstractLotteryDrawFetchWorker fetchWorker = new LotteryDrawFetchWorkerZJTC(lotteryType);
		
		LotteryDraw resultListObj = fetchWorker.fetchResult(phase);
		LotteryDraw resultDetailObj = fetchWorker.fetchResultDetail(phase);
		
		LotteryDraw returnObj = CoreFetcherUtils.getComparedResult(resultListObj, resultDetailObj);
		
		return returnObj;
	}


	@Override
	protected FetcherType getDefaultFetcherType() {
		return FetcherType.T_OFFICIAL;
	}

}
