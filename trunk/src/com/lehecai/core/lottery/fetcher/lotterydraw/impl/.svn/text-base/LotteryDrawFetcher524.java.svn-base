package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.AbstractLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.LocalityLotteryDrawFetchWorkerSTARLOTT;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.LotteryDrawFetch524Worker500Wan;
import com.lehecai.core.util.CoreFetcherUtils;

/**
 * 上海天天彩选4数据抓取实现类
 * @author qatang
 *
 */
public class LotteryDrawFetcher524 extends BaseLotteryDrawFetcher{

	public LotteryDraw fetch500Wan(String phase) {
		AbstractLotteryDrawFetchWorker fetchWorker = new LotteryDrawFetch524Worker500Wan(LotteryType.A_SHTTLX4);
		
		LotteryDraw resultListObj = fetchWorker.fetchResult(phase);	
		LotteryDraw resultDetailObj = fetchWorker.fetchResultDetail(phase);
		
		LotteryDraw returnObj = CoreFetcherUtils.getComparedResult(resultListObj, resultDetailObj);
		return returnObj;
	}
	
	protected LotteryDraw fetchSTARLOTT(String phase) {
		AbstractLotteryDrawFetchWorker fetchWorker = new LocalityLotteryDrawFetchWorkerSTARLOTT(LotteryType.A_SHTTLX4);
		
		LotteryDraw resultListObj = fetchWorker.fetchResult(phase);
		LotteryDraw resultDetailObj = fetchWorker.fetchResultDetail(phase);
		
		LotteryDraw returnObj = CoreFetcherUtils.getComparedResult(resultListObj, resultDetailObj);
		return returnObj;
	}
	
	@Override
	protected FetcherType getDefaultFetcherType() {
		return FetcherType.T_500WAN;
	}

}
