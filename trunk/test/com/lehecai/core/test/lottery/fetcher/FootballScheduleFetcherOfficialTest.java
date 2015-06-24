package com.lehecai.core.test.lottery.fetcher;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.lottery.fetcher.football.FootballScheduleItem;
import com.lehecai.core.lottery.fetcher.football.impl.FootballScheduleFetcher10;
import com.lehecai.core.lottery.fetcher.football.impl.FootballScheduleFetcher7;
import com.lehecai.core.lottery.fetcher.football.impl.FootballScheduleFetcher9;

public class FootballScheduleFetcherOfficialTest {
	private static final Logger logger = LoggerFactory.getLogger(FootballScheduleFetcherTest.class.getName());
	
	public static void main(String[] args){
		try{
			FootballScheduleFetcher10 footballScheduleFetcher10 = new FootballScheduleFetcher10();
			List<FootballScheduleItem> footballScheduleItems5 = footballScheduleFetcher10.fetchOfficial(null);
			List<FootballScheduleItem> footballScheduleItems6 = footballScheduleFetcher10.fetchOfficial("11131");
			System.out.println(FootballScheduleItem.toJSONArray(footballScheduleItems5));
			System.out.println(FootballScheduleItem.toJSONArray(footballScheduleItems6));
			logger.info("==========抓取 6场半全场 足球赛程测试结束");
			
			FootballScheduleFetcher9 footballScheduleFetcher9 = new FootballScheduleFetcher9();
			List<FootballScheduleItem> footballScheduleItems3 = footballScheduleFetcher9.fetchOfficial(null);
			List<FootballScheduleItem> footballScheduleItems4 = footballScheduleFetcher9.fetchOfficial("11136");
			System.out.println(FootballScheduleItem.toJSONArray(footballScheduleItems3));
			System.out.println(FootballScheduleItem.toJSONArray(footballScheduleItems4));
			logger.info("==========抓取 4场进球 足球赛程测试结束");
			
			FootballScheduleFetcher7 footballScheduleFetcher7 = new FootballScheduleFetcher7();
			List<FootballScheduleItem> footballScheduleItems1 = footballScheduleFetcher7.fetchOfficial(null);
			List<FootballScheduleItem> footballScheduleItems2 = footballScheduleFetcher7.fetchOfficial("11095");
			System.out.println(FootballScheduleItem.toJSONArray(footballScheduleItems1));
			System.out.println(FootballScheduleItem.toJSONArray(footballScheduleItems2));
			logger.info("==========抓取 胜负彩 足球赛程测试结束");
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
	}
}
