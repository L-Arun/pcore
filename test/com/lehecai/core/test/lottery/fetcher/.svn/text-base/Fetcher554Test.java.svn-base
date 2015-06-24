package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.LotteryDrawFetcher554;

public class Fetcher554Test {
	private static final Logger logger = LoggerFactory.getLogger(Fetcher554Test.class.getName());
	
	public static void main(String [] args) {
		try{
			logger.info("==========抓取 好运彩3开始");
			ILotteryDrawFetcher fetcher = new LotteryDrawFetcher554();
			LotteryDraw lotterDraw = fetcher.fetch(null, FetcherType.T_OFFICIAL);
			LotteryDraw lotterDraw1 = fetcher.fetch("2011104", FetcherType.T_OFFICIAL);
			LotteryDraw lotterDraw2 = fetcher.fetch("2011103", FetcherType.T_OFFICIAL);
			logger.info(lotterDraw.getLotteryOpenResultLogMsg());
			logger.info(lotterDraw1.getLotteryOpenResultLogMsg());
			logger.info(lotterDraw2.getLotteryOpenResultLogMsg());
			logger.info("==========抓取 好运彩3结束");
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
	}

}
