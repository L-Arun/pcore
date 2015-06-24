package com.lehecai.core.test.lottery.fetcher.dc;

import java.util.List;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.dc.DcAverageSPItem;
import com.lehecai.core.lottery.fetcher.dc.IDcAverageSPFetcher;
import com.lehecai.core.lottery.fetcher.dc.impl.CommonDcAverageSPFetcher;

public class CommonDcAverageSPFetcherTest {

	/**
	 * @param args
	 * @throws UnsupportedFetcherTypeException 
	 */
	public static void main(String[] args) throws UnsupportedFetcherTypeException {
		IDcAverageSPFetcher fetcher = new CommonDcAverageSPFetcher();
		List<DcAverageSPItem> list = fetcher.fetch(null);
		for(DcAverageSPItem item : list){
			System.out.println("Phase " + item.getPhase());
			System.out.println("MatchIndex " + item.getMatchIndex());
			System.out.println("League " + item.getLeague());
			System.out.println("HomeTeam " + item.getHomeTeam());
			System.out.println("AwayTeam " + item.getAwayTeam());
			System.out.println("平均欧赔-胜 " + item.getAverageSP_S());
			System.out.println("平均欧赔-平 " + item.getAverageSP_P());
			System.out.println("平均欧赔-负 " + item.getAverageSP_F());
			System.out.println("\n\n");
		}
	}

}
