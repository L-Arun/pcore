package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.AbstractLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.LotteryDrawFetch533WorkerOfficial;
import com.lehecai.core.util.CoreFetcherUtils;

public class LotteryDrawFetcher533 extends BaseLotteryDrawFetcher {

	protected LotteryDraw fetchOfficial(String phase) {
		
		AbstractLotteryDrawFetchWorker fetchWorker = new LotteryDrawFetch533WorkerOfficial();
		
		LotteryDraw resultListObj = fetchWorker.fetchResult(phase);//抓取7位数
		
		LotteryDraw resultDetailObj = fetchWorker.fetchResultDetail(phase);//抓取7位数历史数据
		
		LotteryDraw returnObj = CoreFetcherUtils.getComparedResult(resultListObj, resultDetailObj);
		
		return returnObj;
	}


	@Override
	protected FetcherType getDefaultFetcherType() {
		return FetcherType.T_OFFICIAL;
	}

}
