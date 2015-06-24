package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import org.apache.commons.lang.StringUtils;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.AbstractLotteryDrawFetchWorker;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker.LocalityLotteryDrawFetchWorker500Wan;
import com.lehecai.core.util.CoreFetcherUtils;

public class LotteryDrawFetcher518 extends BaseLotteryDrawFetcher {	
	@Override
	protected FetcherType getDefaultFetcherType() {
		return FetcherType.T_500WAN;
	}
	protected LotteryDraw fetch500Wan(String phase) {
		AbstractLotteryDrawFetchWorker fetchWorker = new LocalityLotteryDrawFetchWorker500Wan(LotteryType.A_QLFC23);
		
		LotteryDraw resultListObj = fetchWorker.fetchResult(phase);
		LotteryDraw resultDetailObj = fetchWorker.fetchResultDetail(phase);
		LotteryDraw returnObj = CoreFetcherUtils.getComparedResult(resultListObj, resultDetailObj, new CommonLotteryDrawComparator() {

			@Override
			protected LotteryDraw compareLatest(LotteryDraw result1,
					LotteryDraw result2) {
				long phase1 = 0L;
				try {
					phase1 = Long.parseLong(StringUtils.replace(result1.getPhase(), "W", ""));
				} catch (NumberFormatException e) {
					logger.error("期号({})转换错误", result1.getPhase());
					logger.error(e.getMessage(), e);
				}
				long phase2 = 0L;
				try {
					phase2 = Long.parseLong(StringUtils.replace(result2.getPhase(), "W", ""));
				} catch (NumberFormatException e) {
					logger.error("期号({})转换错误", result2.getPhase());
					logger.error(e.getMessage(), e);
				}
				if (phase1 > phase2) {
					return result1;
				} else {
					return result2;
				}
			}
			
		});
		
		return returnObj;
	}
}
