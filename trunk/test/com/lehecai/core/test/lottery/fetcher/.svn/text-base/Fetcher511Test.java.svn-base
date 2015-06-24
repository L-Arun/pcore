package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.LotteryDrawFetcher511;

public class Fetcher511Test {
	private static final Logger logger = LoggerFactory.getLogger(Fetcher511Test.class.getName());
	
	public static void main(String [] args) {
		try{
			logger.info("==========抓取 楚天风采22选5开始");
			ILotteryDrawFetcher fetcher = new LotteryDrawFetcher511();
			LotteryDraw lotterDraw = fetcher.fetch(null, FetcherType.T_OFFICIAL);
			LotteryDraw lotterDraw1 = fetcher.fetch("12002", FetcherType.T_OFFICIAL);
			LotteryDraw lotterDraw2 = fetcher.fetch("12031", FetcherType.T_OFFICIAL);
			logger.info(lotterDraw.getLotteryOpenResultLogMsg());
			logger.info(lotterDraw1.getLotteryOpenResultLogMsg());
			logger.info(lotterDraw2.getLotteryOpenResultLogMsg());
		
			logger.info("==========抓取 楚天风采22选5结束");
		}catch(Exception e){
				logger.error(e.getMessage(),e);
		}
	}

}
