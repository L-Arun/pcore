package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.LotteryDrawFetcher549;

public class HaiNanTiCaiFetcherTest {

	/**
	 * 海南体彩网抓取测试类
	 * @author 
	 *
	 */
	public static class PlotRemoteFootballScheduleFetcherTest {
		private static final Logger logger = LoggerFactory.getLogger(PlotRemoteFootballScheduleFetcherTest.class.getName());
		public static void main(String[] args){
			try{
				logger.info("==========抓取 海南体彩网测试开始");
				ILotteryDrawFetcher fetcher = new LotteryDrawFetcher549();
				LotteryDraw  lotterDraw = fetcher.fetch(null);
				System.out.println(lotterDraw.getLotteryOpenResultLogMsg());
				LotteryDraw  lotterDraw2 = fetcher.fetch("11025");
				System.out.println(lotterDraw2.getLotteryOpenResultLogMsg());
				logger.info("==========抓取 海南体彩网测试结束");
				
//				logger.info("==========抓取 福建体彩网测试开始");
//				FuJianTiCaiLotteryDrawFetcher fuJianTiCaiLotteryDrawFetcher = new FuJianTiCaiLotteryDrawFetcher();
//				fuJianTiCaiLotteryDrawFetcher.fetchFuJianTiCai("11060");
//				logger.info("==========抓取 福建体彩网测试结束");
//				
//				FootballScheduleFetcher7 footballScheduleFetcher7 = new FootballScheduleFetcher7();
//				footballScheduleFetcher7.fetchPlotRemote("11013");
//				footballScheduleFetcher7.fetchPlotRemote("02098");
//				footballScheduleFetcher7.fetchPlotRemote(null);
//				footballScheduleFetcher7.fetchPlotRemote("09048");
//				logger.info("==========抓取 胜负彩 足球赛程测试结束");
//				FootballScheduleFetcher9 footballScheduleFetcher9 = new FootballScheduleFetcher9();
//				footballScheduleFetcher9.fetchPlotRemote("11013");
//				footballScheduleFetcher9.fetchPlotRemote("02098");
//				footballScheduleFetcher9.fetchPlotRemote(null);
//				footballScheduleFetcher9.fetchPlotRemote("09048");
//				logger.info("==========抓取 4场进球 足球赛程测试结束");
//				FootballScheduleFetcher10 footballScheduleFetcher10 = new FootballScheduleFetcher10();
//				footballScheduleFetcher10.fetchPlotRemote("11013");
//				footballScheduleFetcher10.fetchPlotRemote("02098");
//				footballScheduleFetcher10.fetchPlotRemote(null);
//				footballScheduleFetcher10.fetchPlotRemote("09048");
//				logger.info("==========抓取 6场半全场 足球赛程测试结束");
			}catch(Exception e){
				logger.error(e.getMessage(),e);
			}
		}
	}


}
