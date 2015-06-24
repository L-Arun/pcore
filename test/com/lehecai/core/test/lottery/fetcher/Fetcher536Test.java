package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.LotteryDrawFetcher536;

/**
 * 南粤风采36选7数据抓取实现类
 * @author yanweijie
 *
 */
public class Fetcher536Test {
	private static final Logger logger = LoggerFactory.getLogger(Fetcher536Test.class.getName());
	
	
	public static void main(String[] args) {
		try{
			logger.info("==========抓取 南粤风采36选7测试开始");
			ILotteryDrawFetcher fetcher = new LotteryDrawFetcher536();
			LotteryDraw lotterDraw = fetcher.fetch("2009225", FetcherType.T_OFFICIAL);
			logger.info(lotterDraw.getLotteryOpenResultLogMsg());
			logger.info("==========抓取 南粤风采36选7测试结束");
		}catch(Exception e){
				logger.error(e.getMessage(),e);
		}
	}

}
