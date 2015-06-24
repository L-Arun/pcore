package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.football.impl.FootballScheduleFetcher10;
import com.lehecai.core.lottery.fetcher.football.impl.FootballScheduleFetcher7;
import com.lehecai.core.lottery.fetcher.football.impl.FootballScheduleFetcher9;

public class FootballScheduleFetcherOkoooTest {
	private static final Logger logger = LoggerFactory.getLogger(FootballScheduleFetcherTest.class.getName());
	
	public static void main(String[] args){
		try{
			FootballScheduleFetcher7 footballScheduleFetcher7 = new FootballScheduleFetcher7();
			footballScheduleFetcher7.fetchOkooo(null);
			footballScheduleFetcher7.fetchOkooo("12023");
			logger.info("==========抓取 胜负彩 足球赛程测试结束");
			
			FootballScheduleFetcher9 footballScheduleFetcher9 = new FootballScheduleFetcher9();
			footballScheduleFetcher9.fetchOkooo(null);
			footballScheduleFetcher9.fetchOkooo("12023");
			logger.info("==========抓取 4场进球 足球赛程测试结束");
			
			FootballScheduleFetcher10 footballScheduleFetcher10 = new FootballScheduleFetcher10();
			footballScheduleFetcher10.fetchOkooo(null);
			footballScheduleFetcher10.fetchOkooo("12023");
			logger.info("==========抓取 6场半全场 足球赛程测试结束");
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
	}
}
