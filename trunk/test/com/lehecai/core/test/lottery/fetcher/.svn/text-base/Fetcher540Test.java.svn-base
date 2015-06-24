/**
 * 
 */
package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.LotteryDrawFetcher540;

/**
 * 浙江体彩20选5测试
 *
 */
public class Fetcher540Test {

	private static final Logger logger = LoggerFactory.getLogger(Fetcher540Test.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			
			LotteryDraw lotteryDraw = null;
			ILotteryDrawFetcher fetcher = new LotteryDrawFetcher540();
			lotteryDraw = fetcher.fetch(null, FetcherType.T_OFFICIAL);
			logger.info(lotteryDraw.getLotteryOpenResultLogMsg());
			
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
		
	}

}
