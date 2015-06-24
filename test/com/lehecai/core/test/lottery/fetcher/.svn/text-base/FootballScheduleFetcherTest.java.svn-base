package com.lehecai.core.test.lottery.fetcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.football.impl.FootballScheduleFetcher10;
import com.lehecai.core.lottery.fetcher.football.impl.FootballScheduleFetcher7;
import com.lehecai.core.lottery.fetcher.football.impl.FootballScheduleFetcher9;
/**
 * 足球赛程抓取测试类
 * @author leiming
 *
 */
public class FootballScheduleFetcherTest {
	private static final Logger logger = LoggerFactory.getLogger(FootballScheduleFetcherTest.class.getName());
	public static void main(String[] args){
		try{
			FootballScheduleFetcher7 footballScheduleFetcher7 = new FootballScheduleFetcher7();
			footballScheduleFetcher7.fetch("10092");
			footballScheduleFetcher7.fetch("02098");
			footballScheduleFetcher7.fetch(null);
			footballScheduleFetcher7.fetch("09048");
			logger.info("==========抓取 胜负彩 足球赛程测试结束");
			FootballScheduleFetcher9 footballScheduleFetcher9 = new FootballScheduleFetcher9();
			footballScheduleFetcher9.fetch("10096");
			footballScheduleFetcher9.fetch("02098");
			footballScheduleFetcher9.fetch(null);
			footballScheduleFetcher9.fetch("09048");
			logger.info("==========抓取 4场进球 足球赛程测试结束");
			FootballScheduleFetcher10 footballScheduleFetcher10 = new FootballScheduleFetcher10();
			footballScheduleFetcher10.fetch("10108");
			footballScheduleFetcher10.fetch("02098");
			footballScheduleFetcher10.fetch(null);
			footballScheduleFetcher10.fetch("09048");
			logger.info("==========抓取 6场半全场 足球赛程测试结束");
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
		
	}
}
