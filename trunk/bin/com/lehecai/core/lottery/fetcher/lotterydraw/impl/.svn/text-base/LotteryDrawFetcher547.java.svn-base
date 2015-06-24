package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.AbstractLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.LotteryDrawFetch547WorkerOfficial;
import com.lehecai.core.util.CoreFetcherUtils;

public class LotteryDrawFetcher547 extends BaseLotteryDrawFetcher {

	protected LotteryDraw fetchOfficial(String phase) {
		AbstractLotteryDrawFetchWorker fetchWorker = new LotteryDrawFetch547WorkerOfficial();
		
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
