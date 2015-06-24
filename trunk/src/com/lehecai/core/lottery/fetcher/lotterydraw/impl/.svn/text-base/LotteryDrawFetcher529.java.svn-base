package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.AbstractLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.LotteryDrawFetch529WorkerOfficial;
import com.lehecai.core.util.CoreFetcherUtils;

/**
 * 黑龙江p62数据抓取
 * @author yanweijie
 *
 */
public class LotteryDrawFetcher529 extends BaseLotteryDrawFetcher {

	protected LotteryDraw fetchOfficial(String phase) {
		AbstractLotteryDrawFetchWorker fetchWorker = new LotteryDrawFetch529WorkerOfficial();
		
		LotteryDraw resultListObj = fetchWorker.fetchResult(phase);//抓取黑龙江p62开奖数据
		LotteryDraw resultDetailObj = fetchWorker.fetchResultDetail(phase);//抓取黑龙江p62开奖详情数据
		
		LotteryDraw returnObj = CoreFetcherUtils.getComparedResult(resultListObj, resultDetailObj);
		
		return returnObj;
	}


	@Override
	protected FetcherType getDefaultFetcherType() {
		return FetcherType.T_OFFICIAL;
	}

}
