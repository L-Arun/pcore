package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.LotteryDrawFetcher548;

/**
 * 四川扑克彩十分乐数据抓取测试类
 * @author yanweijie
 *
 */
public class Fetcher548Test {
	private static final Logger logger = LoggerFactory.getLogger(Fetcher533Test.class.getName());
	
	public static void main(String[] args){
		LotteryDraw lotteryDraw = null;
		try {
			ILotteryDrawFetcher lotteryDrawFetcher = new LotteryDrawFetcher548();
			lotteryDraw = lotteryDrawFetcher.fetch(null, FetcherType.T_OFFICIAL);
			System.out.println(lotteryDraw.getLotteryOpenResultLogMsg());
		} catch (UnsupportedFetcherTypeException e) {
			logger.error("抓取四川扑克彩十分乐数据异常",e);
		}
	}
}
