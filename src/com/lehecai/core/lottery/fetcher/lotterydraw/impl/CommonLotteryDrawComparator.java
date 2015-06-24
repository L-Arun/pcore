/**
 * 
 */
package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawComparator;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;

/**
 * @author Sunshow
 *
 */
public class CommonLotteryDrawComparator implements ILotteryDrawComparator {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/* (non-Javadoc)
	 * @see com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawComparator#compare(com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw, com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw)
	 */
	@Override
	public LotteryDraw compare(LotteryDraw result1, LotteryDraw result2) {
		if (result1 == null && result2 == null) {
			logger.error("两个都没有取到开奖结果");
			return null;
		}
		if (result1 == null) {
			return result2;
		}
		if (result2 == null) {
			return result1;
		}
		
		/* 两个都有结果，比较期号 */
		if (!result1.getPhase().equals(result2.getPhase())) {
			return compareLatest(result1, result2);
		}
		if(result1.getResult()==null){
			return result2;
		}
		if(result2.getResult()==null){
			return result1;
		}
		if (result1.getResult()!=null&&result2.getResult()!=null&&!result1.getResult().equals(result2.getResult())) {
			logger.error("两个开奖结果不一致，以第二个为准,({}),({})", result1.getResult(), result2.getResult());
		}
		return result2;
	}
	
	protected LotteryDraw compareLatest(LotteryDraw result1, LotteryDraw result2) {
		long phase1 = 0L;
		try {
			phase1 = Long.parseLong(result1.getPhase());
		} catch (NumberFormatException e) {
			logger.error("期号({})转换错误", result1.getPhase());
			logger.error(e.getMessage(), e);
		}
		long phase2 = 0L;
		try {
			phase2 = Long.parseLong(result2.getPhase());
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

}
