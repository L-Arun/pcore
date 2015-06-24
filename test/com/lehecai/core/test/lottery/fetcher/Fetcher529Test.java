package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.LotteryDrawFetcher529;

/**
 * 黑龙江p62数据抓取测试类
 * @author yanweijie
 *
 */
public class Fetcher529Test {
	private static final Logger logger = LoggerFactory.getLogger(Fetcher533Test.class.getName());
	
	public static void main(String[] args){
		try {
			logger.info("===========黑龙江p62开奖结果抓取开始==============");
			ILotteryDrawFetcher fetcher = new LotteryDrawFetcher529();
			LotteryDraw lotteryDraw = fetcher.fetch(null, FetcherType.T_OFFICIAL);
			LotteryDraw lotteryDraw1 = fetcher.fetch("2009340", FetcherType.T_OFFICIAL);
			logger.info("不指定彩期的抓取结果："+lotteryDraw.getLotteryOpenResultLogMsg());
			logger.info("指定彩期的抓取结果："+lotteryDraw1.getLotteryOpenResultLogMsg());
			logger.info("===========黑龙江p62抓取开奖结果结束==============");
		} catch (UnsupportedFetcherTypeException e) {
			logger.error(e.getMessage(),e);
		}
	}
}
