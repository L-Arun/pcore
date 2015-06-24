package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.AbstractLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.LotteryDrawFetch552WorkerOfficial;

/**
 * 北京体彩33选7数据抓取实现类
 * @author yanweijie
 *
 */
public class LotteryDrawFetcher552 extends BaseLotteryDrawFetcher{

	public LotteryDraw fetchOfficial(String phase) {
		LotteryDraw lotteryDraw = null;
		
		AbstractLotteryDrawFetchWorker worker = new LotteryDrawFetch552WorkerOfficial();
		lotteryDraw = worker.fetchResultDetail(phase);
		
		return lotteryDraw;
	}
	
	@Override
	protected FetcherType getDefaultFetcherType() {
		return FetcherType.T_OFFICIAL;
	}

}
