package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.football.impl.FootballScheduleFetcher10;
import com.lehecai.core.lottery.fetcher.football.impl.FootballScheduleFetcher7;
import com.lehecai.core.lottery.fetcher.football.impl.FootballScheduleFetcher9;
/**
 * Plot远程 足球赛程抓取测试类
 * @author leiming
 *
 */
public class PlotRemoteFootballScheduleFetcherTest {
	private static final Logger logger = LoggerFactory.getLogger(PlotRemoteFootballScheduleFetcherTest.class.getName());
	public static void main(String[] args){
		try{
			FootballScheduleFetcher7 footballScheduleFetcher7 = new FootballScheduleFetcher7();
			footballScheduleFetcher7.fetchPlotRemote("11013");
			footballScheduleFetcher7.fetchPlotRemote("02098");
			footballScheduleFetcher7.fetchPlotRemote(null);
			footballScheduleFetcher7.fetchPlotRemote("09048");
			logger.info("==========抓取 胜负彩 足球赛程测试结束");
			FootballScheduleFetcher9 footballScheduleFetcher9 = new FootballScheduleFetcher9();
			footballScheduleFetcher9.fetchPlotRemote("11013");
			footballScheduleFetcher9.fetchPlotRemote("02098");
			footballScheduleFetcher9.fetchPlotRemote(null);
			footballScheduleFetcher9.fetchPlotRemote("09048");
			logger.info("==========抓取 4场进球 足球赛程测试结束");
			FootballScheduleFetcher10 footballScheduleFetcher10 = new FootballScheduleFetcher10();
			footballScheduleFetcher10.fetchPlotRemote("11013");
			footballScheduleFetcher10.fetchPlotRemote("02098");
			footballScheduleFetcher10.fetchPlotRemote(null);
			footballScheduleFetcher10.fetchPlotRemote("09048");
			logger.info("==========抓取 6场半全场 足球赛程测试结束");
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
		
	}
}
