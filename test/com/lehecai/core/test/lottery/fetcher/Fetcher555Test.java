package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.LotteryDrawFetcher555;

/**
 * 南粤风彩好彩1数据抓取测试类
 * @author yanweijie
 *
 */
public class Fetcher555Test {
	private static final Logger logger = LoggerFactory.getLogger(Fetcher533Test.class.getName());
	
	public static void main(String[] args){
		try {
			ILotteryDrawFetcher fetcher = new LotteryDrawFetcher555();
			LotteryDraw lotteryDraw = fetcher.fetch("2010106",FetcherType.T_OFFICIAL);
			logger.info(lotteryDraw.getLotteryOpenResultLogMsg());
		} catch (UnsupportedFetcherTypeException e) {
			logger.error(e.getMessage(),e);
		}
	}
}
