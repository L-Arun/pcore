package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.LotteryDrawFetcher508;
import com.lehecai.core.test.lottery.fetcher.HaiNanTiCaiFetcherTest.PlotRemoteFootballScheduleFetcherTest;

public class FuJianTiCaiFetcherTest {
	private static final Logger logger = LoggerFactory.getLogger(PlotRemoteFootballScheduleFetcherTest.class.getName());
	public static void main(String[] args){
		try{
			logger.info("==========抓取 福建体彩网22选5测试开始");
			ILotteryDrawFetcher fetcher = new LotteryDrawFetcher508();
			LotteryDraw lotterDraw = fetcher.fetch(null, FetcherType.T_OFFICIAL);
			System.out.println(lotterDraw.getLotteryOpenResultLogMsg());
			logger.info("==========抓取 福建体彩网22选5测试结束");
		}catch(Exception e){
				logger.error(e.getMessage(),e);
		}
	}

}
