package com.lehecai.core.test.lottery.fetcher.dc;

import java.util.List;
import java.util.Map;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.DcSPType;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.dc.DcInstantSPItem;
import com.lehecai.core.lottery.fetcher.dc.IDcInstantSPFetcher;
import com.lehecai.core.lottery.fetcher.dc.impl.CommonDcInstantSPFetcher;

public class CommonDcInstantSPFetcherTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IDcInstantSPFetcher fetcher = new CommonDcInstantSPFetcher();
		
		try {
			List<DcInstantSPItem>  list = fetcher.fetch("110712", FetcherType.T_PENGINEAPI, LotteryType.DC_BF);
			for(DcInstantSPItem item : list){
				System.out.println("Phase " + item.getPhase());           
				System.out.println("MatchIndex " + item.getMatchIndex());
				System.out.println("HomeTeam " + item.getHomeTeam());
				System.out.println("AwayTeam " + item.getAwayTeam());
				System.out.println("League " + item.getLeague());
				
				Map<DcSPType,String> spmap = item.getSpmap();
				for(Map.Entry<DcSPType, String> entry : spmap.entrySet()){
					String name = entry.getKey().getName();
					String value = entry.getValue();
					System.out.print(name + "=" + value + " ");
				}
				System.out.println("\n\n\n");
			}
		} catch (UnsupportedFetcherTypeException e) {
			e.printStackTrace();
		}
	}

}
