package com.lehecai.core.test.api.lottery;

import java.util.List;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.football.FootballScheduleItem;
import com.lehecai.core.lottery.fetcher.football.impl.FootballScheduleFetcher10;
import com.lehecai.core.lottery.fetcher.football.impl.FootballScheduleFetcher7;
import com.lehecai.core.lottery.fetcher.football.impl.FootballScheduleFetcher9;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.ClientLotteryDrawFetcher;

public class ClientFootballFetchTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			LotteryDraw lotteryDraw3 = test(LotteryType.getItem(7),"10088");
			System.out.println(lotteryDraw3.getLotteryOpenResultLogMsg());
			List<FootballScheduleItem> list = testSfp("10088");
			for(FootballScheduleItem f : list){
				System.out.println(f.getLogInfo());
			}
			
			LotteryDraw lotteryDraw4 = test(LotteryType.getItem(8),"10088");
			System.out.println(lotteryDraw4.getLotteryOpenResultLogMsg());
			List<FootballScheduleItem> list2 = testSfp("10088");
			for(FootballScheduleItem f : list2){
				System.out.println(f.getLogInfo());
			}
			
			LotteryDraw lotteryDraw5 = test(LotteryType.getItem(9),"10097");
			System.out.println(lotteryDraw5.getLotteryOpenResultLogMsg());
			List<FootballScheduleItem> list3 = test4c("10097");
			for(FootballScheduleItem f : list3){
				System.out.println(f.getLogInfo());
			}
			
			LotteryDraw lotteryDraw6 = test(LotteryType.getItem(10),"10097");
			System.out.println(lotteryDraw6.getLotteryOpenResultLogMsg());
			List<FootballScheduleItem> list4 = test6c("10097");
			for(FootballScheduleItem f : list4){
				System.out.println(f.getLogInfo());
			}
			
		} catch (UnsupportedFetcherTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static LotteryDraw test(LotteryType lotteryType, String phase) throws UnsupportedFetcherTypeException{
		ClientLotteryDrawFetcher clientLotteryDrawFetcher = new ClientLotteryDrawFetcher(lotteryType);
		LotteryDraw lotteryDraw = clientLotteryDrawFetcher.fetch(phase, FetcherType.T_CLIENT);
		return lotteryDraw;
	}
	public static  List<FootballScheduleItem> testSfp(String phase) throws UnsupportedFetcherTypeException{
		FootballScheduleFetcher7 footballClientScheduleFetcher7 = new FootballScheduleFetcher7();	
		return footballClientScheduleFetcher7.fetch(phase, FetcherType.T_CLIENT);
	}
	public static  List<FootballScheduleItem> test4c(String phase) throws UnsupportedFetcherTypeException{
		FootballScheduleFetcher9 footballClientScheduleFetcher9 = new FootballScheduleFetcher9();	
		return footballClientScheduleFetcher9.fetch(phase, FetcherType.T_CLIENT);
	}
	public static  List<FootballScheduleItem> test6c(String phase) throws UnsupportedFetcherTypeException{
		FootballScheduleFetcher10 footballClientScheduleFetcher10 = new FootballScheduleFetcher10();	
		return footballClientScheduleFetcher10.fetch(phase, FetcherType.T_CLIENT);
	}
}
