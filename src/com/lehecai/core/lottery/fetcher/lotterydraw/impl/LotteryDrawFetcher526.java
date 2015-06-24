package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.AbstractLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.LotteryDrawFetchWorkerGDFC;
import com.lehecai.core.util.CoreFetcherUtils;

/**
 * 南粤风采26选5数据抓取实现类
 * @author yanweijie
 *
 */
public class LotteryDrawFetcher526 extends BaseLotteryDrawFetcher{

	public LotteryDraw fetchOfficial(String phase) {
		AbstractLotteryDrawFetchWorker fetchWorker = new LotteryDrawFetchWorkerGDFC(LotteryType.A_NYFC26);
		
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
