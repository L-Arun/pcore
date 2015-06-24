package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.LotteryDrawFetcher512;

public class Fetcher512Test {
	private static final Logger logger = LoggerFactory.getLogger(Fetcher512Test.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			logger.info("==========抓取 中原风采22选5测试开始");
			ILotteryDrawFetcher fetcher = new LotteryDrawFetcher512();
			LotteryDraw lotterDraw = fetcher.fetch("2011084", FetcherType.T_OFFICIAL);
			LotteryDraw lotterDraw1 = fetcher.fetch(null, FetcherType.T_OFFICIAL);
			logger.info(lotterDraw.getLotteryOpenResultLogMsg());
			logger.info(lotterDraw1.getLotteryOpenResultLogMsg());
			logger.info("==========抓取 中原风采22选5测试结束");
		}catch(Exception e){
				logger.error(e.getMessage(),e);
		}
	}

}
