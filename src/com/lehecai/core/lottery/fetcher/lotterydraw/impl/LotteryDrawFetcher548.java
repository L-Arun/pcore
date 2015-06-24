package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.AbstractLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.LotteryDrawFetch548WorkerOfficial;
import com.lehecai.core.util.CoreFetcherUtils;

/**
 * 四川扑克彩十分乐数据抓取实现类
 * @author yanweijie
 *
 */
public class LotteryDrawFetcher548 extends BaseLotteryDrawFetcher {

	public LotteryDraw fetchOfficial(String phase) {
		AbstractLotteryDrawFetchWorker fetchWorker = new LotteryDrawFetch548WorkerOfficial(LotteryType.A_PKCSFL);
		
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
