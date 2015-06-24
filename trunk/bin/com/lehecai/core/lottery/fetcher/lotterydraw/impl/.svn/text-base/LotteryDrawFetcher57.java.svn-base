package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.AbstractLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.LotteryDrawFetch57WorkerOfficial;
import com.lehecai.core.util.CoreFetcherUtils;

public class LotteryDrawFetcher57 extends BaseLotteryDrawFetcher{

	protected LotteryDraw fetchOfficial(String phase) {
		AbstractLotteryDrawFetchWorker fetchWorker = new LotteryDrawFetch57WorkerOfficial();
		LotteryDraw resultListObj = new LotteryDraw();
		//抓取结果页面
		if(phase == null||"".equals(phase)){
			resultListObj = fetchWorker.fetchResult(phase);
		}
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
