package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.PlotRemoteLotteryDrawFetcher;

/**
 * 测试Plot远程抓取开奖结果
 * @author leiming
 *
 */
public class PlotRemoteFetcherTest {

	private static final Logger logger = LoggerFactory.getLogger(PlotRemoteFetcherTest.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			LotteryType lotteryType = null;
			LotteryDraw lotteryDraw = null;
			ILotteryDrawFetcher lotteryFetcher = null;
			
			lotteryType = LotteryType.SSQ;
			lotteryFetcher = new PlotRemoteLotteryDrawFetcher(lotteryType);
			
			lotteryDraw = lotteryFetcher.fetch(null,FetcherType.T_PLOTREMOTE);
			logger.info(FetcherType.T_PLOTREMOTE.getName()+"抓取<"+lotteryType.getName()+">最新期({})的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			logger.info(lotteryDraw.getLotteryOpenResultLogMsg());
			
			lotteryDraw = lotteryFetcher.fetch("2011015",FetcherType.T_PLOTREMOTE);
			logger.info(FetcherType.T_PLOTREMOTE.getName()+"抓取<"+lotteryType.getName()+">第({})期的开奖结果为({})", lotteryDraw.getPhase(), lotteryDraw.getResult());
			logger.info(lotteryDraw.getLotteryOpenResultLogMsg());
			
			logger.info("================================");
			logger.info("==测试结束==");
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
		
	}

}
