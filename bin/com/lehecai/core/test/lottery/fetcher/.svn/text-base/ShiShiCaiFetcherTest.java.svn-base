/**
 * 
 */
package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.ShiShiCaiLotteryDrawFetcher;

/**
 * 测试
 *
 */
public class ShiShiCaiFetcherTest {

	private static final Logger logger = LoggerFactory.getLogger(ShiShiCaiFetcherTest.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			
			LotteryDraw lotteryDraw = null;
			ILotteryDrawFetcher fetcher = null;
			
			/*
			fetcher = new ShiShiCaiLotteryDrawFetcher(LotteryType.A_GDKLSF);
			lotteryDraw = fetcher.fetch(null);
			logger.info(lotteryDraw.getLotteryOpenResultLogMsg());
			lotteryDraw = fetcher.fetch("2011030510");
			logger.info(lotteryDraw.getLotteryOpenResultLogMsg());
			
			fetcher = new ShiShiCaiLotteryDrawFetcher(LotteryType.CQSSC);
			lotteryDraw = fetcher.fetch(null);
			logger.info(lotteryDraw.getLotteryOpenResultLogMsg());
			
			fetcher = new ShiShiCaiLotteryDrawFetcher(LotteryType.CQSSC);
			lotteryDraw = fetcher.fetch("20110305028");
			logger.info(lotteryDraw.getLotteryOpenResultLogMsg());
			
			fetcher = new ShiShiCaiLotteryDrawFetcher(LotteryType.SHSSL);
			lotteryDraw = fetcher.fetch("2012042323");
			logger.info(lotteryDraw.getLotteryOpenResultLogMsg());
			*/
			
			fetcher = new ShiShiCaiLotteryDrawFetcher(LotteryType.GXKL10);
			lotteryDraw = fetcher.fetch("201210806");
			logger.info(lotteryDraw.getLotteryOpenResultLogMsg());
			
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
		
	}

}
