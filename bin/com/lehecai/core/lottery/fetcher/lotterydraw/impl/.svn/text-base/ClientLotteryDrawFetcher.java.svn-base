package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.AbstractLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.LotteryDrawFetchWorkerClient;
import com.lehecai.core.util.CoreFetcherUtils;

public class ClientLotteryDrawFetcher extends BaseLotteryDrawFetcher {
	
	private LotteryType lotteryType;
	
	protected LotteryType getLotteryType() {
		return lotteryType;
	}

	protected ClientLotteryDrawFetcher() {
		
	}
	
	public ClientLotteryDrawFetcher(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}
	
	public ClientLotteryDrawFetcher(Integer lotteryTypeId) {
		LotteryType lotteryType = LotteryType.getItem(lotteryTypeId);
		this.lotteryType = lotteryType;
	}

	@Override
	protected FetcherType getDefaultFetcherType() {
		return FetcherType.T_CLIENT;
	}
	
	protected LotteryDraw fetchClient(String phase) {
		AbstractLotteryDrawFetchWorker fetchWorker = new LotteryDrawFetchWorkerClient(this.getLotteryType());
		//抓取结果页面
		LotteryDraw resultListObj = fetchWorker.fetchResult(phase);
		//抓取详情页面
		//LotteryDraw resultDetailObj = fetchWorker.fetchResultDetail(phase);
		LotteryDraw returnObj = CoreFetcherUtils.getComparedResult(resultListObj, null);
		return returnObj;
	}
}
