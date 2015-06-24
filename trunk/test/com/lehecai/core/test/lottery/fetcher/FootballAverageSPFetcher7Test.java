package com.lehecai.core.test.lottery.fetcher;

import java.util.List;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.football.FootballAverageSPItem;
import com.lehecai.core.lottery.fetcher.football.IFootballAverageSPFetcher;
import com.lehecai.core.lottery.fetcher.football.impl.FootballAverageSPFetcher7;

public class FootballAverageSPFetcher7Test {

	/**
	 * @param args
	 * @throws UnsupportedFetcherTypeException 
	 */
	public static void main(String[] args) throws UnsupportedFetcherTypeException {
		IFootballAverageSPFetcher fetcher = new FootballAverageSPFetcher7();
		List<FootballAverageSPItem> list = fetcher.fetch("10098");
		if( list == null ){
			return ;
		}
		for(FootballAverageSPItem item : list){
			System.out.println("胜负彩");
			System.out.println("彩期号 " + item.getPhase());
			System.out.println("场次 " + item.getMatchIndex());
			System.out.println("平均欧指-胜 " + item.getAverageSP_S());
			System.out.println("平均欧指-平 " + item.getAverageSP_P());
			System.out.println("平均欧指-负 " + item.getAverageSP_F());
			System.out.println();
		}
	}

}
