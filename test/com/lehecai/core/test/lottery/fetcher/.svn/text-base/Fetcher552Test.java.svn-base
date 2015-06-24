package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.LotteryDrawFetcher552;

/**
 * 北京体彩33选7数据抓取测试类
 * @author yanweijie
 *
 */
public class Fetcher552Test {
	private static final Logger logger = LoggerFactory.getLogger(Fetcher533Test.class.getName());
	
	public static void main(String[] args){
		LotteryDraw lotteryDraw = null;
		try {
			ILotteryDrawFetcher lotteryDrawFetcher = new LotteryDrawFetcher552();
			lotteryDraw = lotteryDrawFetcher.fetch("10347", FetcherType.T_OFFICIAL);
			System.out.println(lotteryDraw.getLotteryOpenResultLogMsg());
		} catch (UnsupportedFetcherTypeException e) {
			logger.error("抓取北京体彩33选7数据异常",e);
		}
	}
}
