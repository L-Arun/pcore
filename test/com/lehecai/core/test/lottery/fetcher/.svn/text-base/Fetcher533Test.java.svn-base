/**
 * 
 */
package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.LotteryDrawFetcher533;

/**
 * 测试
 *
 */
public class Fetcher533Test {

	private static final Logger logger = LoggerFactory.getLogger(Fetcher533Test.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LotteryDraw lotteryDraw = null;
		try{
			//江苏体彩7位数
			ILotteryDrawFetcher fetcher = new LotteryDrawFetcher533();
			lotteryDraw = fetcher.fetch("11057", FetcherType.T_OFFICIAL);
			logger.info(lotteryDraw.getLotteryOpenResultLogMsg());

		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
		
	}

}
