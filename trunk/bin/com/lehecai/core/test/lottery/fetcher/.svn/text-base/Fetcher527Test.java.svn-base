package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.LotteryDrawFetcher527;

public class Fetcher527Test {
	private static final Logger logger = LoggerFactory.getLogger(Fetcher527Test.class.getName());
	public static void main(String[] args){
		try{
			logger.info("==========抓取 黑龙江36选7测试开始");
			ILotteryDrawFetcher fetcher = new LotteryDrawFetcher527();
			LotteryDraw lotterDraw = fetcher.fetch("2012063", FetcherType.T_OFFICIAL);
			LotteryDraw lotterDraw1 = fetcher.fetch(null, FetcherType.T_OFFICIAL);
			logger.info(lotterDraw.getLotteryOpenResultLogMsg());
			logger.info(lotterDraw1.getLotteryOpenResultLogMsg());
			logger.info("==========抓取 黑龙江36选7测试结束");
		}catch(Exception e){
				logger.error(e.getMessage(),e);
		}
	}
}
