package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.AbstractLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.LotteryDrawFetchWorkerAiCaiPiao;
/**
 * 爱彩票 开奖结果抓取
 * @author Sunshow
 *
 */
public class AiCaiPiaoLotteryDrawFetcher extends BaseLotteryDrawFetcher {
	
	private LotteryType lotteryType;
	
	protected LotteryType getLotteryType() {
		return lotteryType;
	}
	
	protected AiCaiPiaoLotteryDrawFetcher() {
		
	}
	
	public AiCaiPiaoLotteryDrawFetcher(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}
	
	public AiCaiPiaoLotteryDrawFetcher(Integer lotteryTypeId) {
		LotteryType lotteryType = LotteryType.getItem(lotteryTypeId);
		this.lotteryType = lotteryType;
	}
	@Override
	protected FetcherType getDefaultFetcherType() {
		return FetcherType.T_AICAIPIAO;
	}
	
	protected LotteryDraw fetchAiCaiPiao(String phase) {
		AbstractLotteryDrawFetchWorker fetchWorker = new LotteryDrawFetchWorkerAiCaiPiao(this.getLotteryType());
		
		return fetchWorker.fetchResult(phase);
	}

}
