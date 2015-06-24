package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.AbstractLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.LotteryDrawFetchWorkerShiShiCai;
import com.lehecai.core.util.CoreFetcherUtils;
/**
 * 时时彩网 开奖结果抓取
 * 主要抓取 广东快乐十分
 * @author leiming
 *
 */
public class ShiShiCaiLotteryDrawFetcher extends BaseLotteryDrawFetcher {
	
	private LotteryType lotteryType;
	
	protected LotteryType getLotteryType() {
		return lotteryType;
	}
	
	protected ShiShiCaiLotteryDrawFetcher() {
		
	}
	
	public ShiShiCaiLotteryDrawFetcher(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}
	
	public ShiShiCaiLotteryDrawFetcher(Integer lotteryTypeId) {
		LotteryType lotteryType = LotteryType.getItem(lotteryTypeId);
		this.lotteryType = lotteryType;
	}
	
	@Override
	protected FetcherType getDefaultFetcherType() {
		return FetcherType.T_SHISHICAI;
	}
	
	protected LotteryDraw fetchShiShiCai(String phase) {
		AbstractLotteryDrawFetchWorker fetchWorker = new LotteryDrawFetchWorkerShiShiCai(lotteryType);
		//抓取结果页面
		//LotteryDraw resultListObj = fetchWorker.fetchResult(phase);
		//抓取详情页面
		LotteryDraw resultDetailObj = fetchWorker.fetchResultDetail(phase);
		LotteryDraw returnObj = CoreFetcherUtils.getComparedResult(null, resultDetailObj);
		
		return returnObj;
	}

}
