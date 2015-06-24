package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.AbstractLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.LotteryDrawFetch549WorkerOfficial;
import com.lehecai.core.util.CoreFetcherUtils;

/**
 * 海南体彩彩网 开奖结果抓取
 * 
 * @author 
 *
 */
public class LotteryDrawFetcher549 extends BaseLotteryDrawFetcher{

	protected LotteryDraw fetchOfficial(String phase) {
		AbstractLotteryDrawFetchWorker fetchWorker = new LotteryDrawFetch549WorkerOfficial();
		LotteryDraw resultListObj = fetchWorker.fetchResult(phase);
		//抓取详情页面
		LotteryDraw resultDetailObj = fetchWorker.fetchResultDetail(phase);
		
		LotteryDraw returnObj = CoreFetcherUtils.getComparedResult(resultListObj, resultDetailObj);
		
		return returnObj;
	}

	@Override
	protected FetcherType getDefaultFetcherType() {
		return FetcherType.T_OFFICIAL;
	}
}
