package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.LotteryDrawFetcher513;

public class Fetcher513Test {
	private static final Logger logger = LoggerFactory.getLogger(Fetcher513Test.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			logger.info("==========抓取 燕赵风采排列7测试开始");
			ILotteryDrawFetcher fetcher = new LotteryDrawFetcher513();
			LotteryDraw lotterDraw = fetcher.fetch("2011033", FetcherType.T_OFFICIAL);
			LotteryDraw lotterDraw1 = fetcher.fetch(null, FetcherType.T_OFFICIAL);
			LotteryDraw lotterDraw2 = fetcher.fetch("2011047", FetcherType.T_OFFICIAL);
			
			logger.info(lotterDraw.getLotteryOpenResultLogMsg());
			logger.info(lotterDraw1.getLotteryOpenResultLogMsg());
			logger.info(lotterDraw2.getLotteryOpenResultLogMsg());
			logger.info("==========抓取 燕赵风采排列7测试结束");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}
