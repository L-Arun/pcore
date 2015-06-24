/**
 * 
 */
package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;

/**
 * @author Sunshow
 *
 */
public abstract class AbstractLotteryDrawFetchWorker {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	private LotteryType lotteryType;
	
	abstract public LotteryDraw fetchResult(String phase);
	abstract public LotteryDraw fetchResultDetail(String phase);
	
	abstract protected String getResultDetailUrl(String phase);
	abstract protected String getResultUrl(String phase);
	
	protected AbstractLotteryDrawFetchWorker() {
		
	}
	
	protected AbstractLotteryDrawFetchWorker(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}
	
	public LotteryType getLotteryType() {
		return lotteryType;
	}
}
