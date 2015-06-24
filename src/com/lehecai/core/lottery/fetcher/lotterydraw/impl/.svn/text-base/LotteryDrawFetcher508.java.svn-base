package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.AbstractLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.LotteryDrawFetch508WorkerOfficial;
import com.lehecai.core.util.CoreFetcherUtils;

public class LotteryDrawFetcher508 extends BaseLotteryDrawFetcher{

	protected LotteryDraw fetchOfficial(String phase) {
		AbstractLotteryDrawFetchWorker fetchWorker = new LotteryDrawFetch508WorkerOfficial();
		//抓取结果页面
		//LotteryDraw resultListObj = fetchWorker.fetchResult(phase);
		//抓取详情页面
		LotteryDraw resultDetailObj = fetchWorker.fetchResultDetail(phase);
		LotteryDraw returnObj = CoreFetcherUtils.getComparedResult(null, resultDetailObj);
		
		return returnObj;
	}

	@Override
	protected FetcherType getDefaultFetcherType() {
		return FetcherType.T_OFFICIAL;
	}
}
