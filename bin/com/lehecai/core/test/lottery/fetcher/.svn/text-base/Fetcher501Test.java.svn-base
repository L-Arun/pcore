package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.LotteryDrawFetcher501;

public class Fetcher501Test {
	private static final Logger logger = LoggerFactory.getLogger(Fetcher501Test.class.getName());
	public static void main(String[] args) {
		try{
			logger.info("==========抓取 两步彩开始");
			ILotteryDrawFetcher fetcher = new LotteryDrawFetcher501();
			LotteryDraw lotterDraw = fetcher.fetch(null, FetcherType.T_OFFICIAL);
			LotteryDraw lotterDraw1 = fetcher.fetch("2011043", FetcherType.T_OFFICIAL);
			LotteryDraw lotterDraw2 = fetcher.fetch("2011045", FetcherType.T_OFFICIAL);
			logger.info(lotterDraw.getLotteryOpenResultLogMsg());
			logger.info(lotterDraw1.getLotteryOpenResultLogMsg());
			logger.info(lotterDraw2.getLotteryOpenResultLogMsg());
			logger.info("==========抓取 两步彩结束");
		}catch(Exception e){
				logger.error(e.getMessage(),e);
		}
	}

}
