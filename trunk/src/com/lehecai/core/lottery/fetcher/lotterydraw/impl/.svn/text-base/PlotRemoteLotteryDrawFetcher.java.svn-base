/**
 * 
 */
package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.AbstractLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.LotteryDrawFetchWorkerPlotRemote;
import com.lehecai.core.util.CoreFetcherUtils;
/**
 * Plot 远程开奖结果抓取
 * @author leiming
 *
 */
public class PlotRemoteLotteryDrawFetcher extends BaseLotteryDrawFetcher {
	
	private LotteryType lotteryType;
	
	protected LotteryType getLotteryType() {
		return lotteryType;
	}
	
	protected PlotRemoteLotteryDrawFetcher() {
		
	}
	
	public PlotRemoteLotteryDrawFetcher(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}
	
	public PlotRemoteLotteryDrawFetcher(Integer lotteryTypeId) {
		LotteryType lotteryType = LotteryType.getItem(lotteryTypeId);
		this.lotteryType = lotteryType;
	}
	
	@Override
	protected FetcherType getDefaultFetcherType() {
		return FetcherType.T_PLOTREMOTE;
	}
	
	protected LotteryDraw fetchPlotRemote(String phase) {
		AbstractLotteryDrawFetchWorker fetchWorker = new LotteryDrawFetchWorkerPlotRemote(this.getLotteryType());
		//抓取结果页面
		LotteryDraw resultListObj = fetchWorker.fetchResult(phase);
		//抓取详情页面
		//LotteryDraw resultDetailObj = fetchWorker.fetchResultDetail(phase);
		LotteryDraw returnObj = CoreFetcherUtils.getComparedResult(resultListObj, null);
		return returnObj;
	}

}
