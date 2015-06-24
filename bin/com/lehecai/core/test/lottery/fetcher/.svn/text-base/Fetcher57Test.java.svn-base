package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.LotteryDrawFetcher57;
import com.lehecai.core.test.lottery.fetcher.HaiNanTiCaiFetcherTest.PlotRemoteFootballScheduleFetcherTest;

public class Fetcher57Test {
	private static final Logger logger = LoggerFactory.getLogger(PlotRemoteFootballScheduleFetcherTest.class.getName());
	public static void main(String[] args){
		try{
			logger.info("==========抓取 广东体彩网36选7测试开始");
			ILotteryDrawFetcher fetcher = new LotteryDrawFetcher57();
			LotteryDraw lotteryDraw = fetcher.fetch(null, FetcherType.T_OFFICIAL);
			//lotteryDrawFetcher57.fetchOfficial("11024");
			System.out.println(lotteryDraw.getLotteryOpenResultLogMsg());
			logger.info("==========抓取 广东体彩网36选7测试结束");
		}catch(Exception e){
				logger.error(e.getMessage(),e);
		}
	}

}
