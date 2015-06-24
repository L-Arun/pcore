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
public class LotteryDrawFetcher23 extends ShiShiCaiLotteryDrawFetcher {
	
	public LotteryDrawFetcher23() {
		super(LotteryType.GD11X5);
	}
	
	@Override
	protected FetcherType getDefaultFetcherType() {
		return FetcherType.T_SHISHICAI;
	}

	@Override
	protected LotteryDraw fetchShiShiCai(String phase) {
		AbstractLotteryDrawFetchWorker fetchWorker = new LotteryDrawFetchWorkerShiShiCai(this.getLotteryType());
		
		String fetchPhase = phase;
		if (fetchPhase != null && fetchPhase.length() == 8) {
			fetchPhase = "20" + fetchPhase;
		}
		
		LotteryDraw resultDetailObj = fetchWorker.fetchResultDetail(fetchPhase);
		LotteryDraw returnObj = CoreFetcherUtils.getComparedResult(null, resultDetailObj);
		
		// 将抓取的期号转换回系统期号
		if (returnObj != null && returnObj.getPhase() != null && returnObj.getPhase().length() == 10) {
			returnObj.setPhase(returnObj.getPhase().substring(2));
		}
		
		return returnObj;
	}
	

}
