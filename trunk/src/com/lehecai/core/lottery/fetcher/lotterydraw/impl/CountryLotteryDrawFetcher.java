/**
 * 
 */
package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.AbstractLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.CountryLotteryDrawFetchWorker500Wan;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.CountryLotteryDrawFetchWorkerSTARLOTT;
import com.lehecai.core.util.CoreFetcherUtils;
/**
 * 通用全国开奖结果抓取
 * @author leiming
 *
 */
public class CountryLotteryDrawFetcher extends BaseLotteryDrawFetcher {
	
	private LotteryType lotteryType;
	
	protected LotteryType getLotteryType() {
		return lotteryType;
	}
	
	protected CountryLotteryDrawFetcher() {
		
	}
	
	public CountryLotteryDrawFetcher(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}
	
	public CountryLotteryDrawFetcher(Integer lotteryTypeId) {
		LotteryType lotteryType = LotteryType.getItem(lotteryTypeId);
		this.lotteryType = lotteryType;
	}

	protected LotteryDraw fetch500Wan(String phase) {
		AbstractLotteryDrawFetchWorker fetchWorker = new CountryLotteryDrawFetchWorker500Wan(this.getLotteryType());
		//抓取结果页面
		LotteryDraw resultListObj = fetchWorker.fetchResult(phase);
		//抓取详情页面
		LotteryDraw resultDetailObj = fetchWorker.fetchResultDetail(phase);
		LotteryDraw returnObj = CoreFetcherUtils.getComparedResult(resultListObj, resultDetailObj);
		return returnObj;
	}

	protected LotteryDraw fetchSTARLOTT(String phase) {
		AbstractLotteryDrawFetchWorker fetchWorker = new CountryLotteryDrawFetchWorkerSTARLOTT(this.getLotteryType());
		//抓取结果页面
		LotteryDraw resultListObj = fetchWorker.fetchResult(phase);
		//抓取详情页面
		LotteryDraw resultDetailObj = fetchWorker.fetchResultDetail(phase);
		LotteryDraw returnObj = CoreFetcherUtils.getComparedResult(resultListObj, resultDetailObj);
		return returnObj;
	}

	@Override
	protected FetcherType getDefaultFetcherType() {
		return FetcherType.T_500WAN;
	}
	
}
