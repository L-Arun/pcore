package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.LotteryDrawFetcher526;

/**
 * 南粤风彩26选5数据抓取测试类
 * @author yanweijie
 *
 */
public class Fetcher526Test {
	private static final Logger logger = LoggerFactory.getLogger(Fetcher533Test.class.getName());
	
	public static void main(String[] args){
		try {
			ILotteryDrawFetcher fetcher = new LotteryDrawFetcher526();
			LotteryDraw lotteryDraw = fetcher.fetch("2010052",FetcherType.T_OFFICIAL);
			logger.info(lotteryDraw.getLotteryOpenResultLogMsg());
		} catch (UnsupportedFetcherTypeException e) {
			logger.error(e.getMessage(),e);
		}
	}
}
