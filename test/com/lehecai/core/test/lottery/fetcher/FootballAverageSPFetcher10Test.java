package com.lehecai.core.test.lottery.fetcher;

import java.util.List;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.football.FootballAverageSPItem;
import com.lehecai.core.lottery.fetcher.football.IFootballAverageSPFetcher;
import com.lehecai.core.lottery.fetcher.football.impl.FootballAverageSPFetcher10;

public class FootballAverageSPFetcher10Test {

	/**
	 * @param args
	 * @throws UnsupportedFetcherTypeException 
	 */
	public static void main(String[] args) throws UnsupportedFetcherTypeException {
		IFootballAverageSPFetcher fetcher = new FootballAverageSPFetcher10();
		List<FootballAverageSPItem> list = fetcher.fetch("10119"); //"10119"
		if( list == null ){
			return ;
		}
		for(FootballAverageSPItem item : list){
			System.out.println("6场半全场");
			System.out.println("彩期号 " + item.getPhase());
			System.out.println("场次 " + item.getMatchIndex());
			System.out.println("平均欧指-胜 " + item.getAverageSP_S());
			System.out.println("平均欧指-平 " + item.getAverageSP_P());
			System.out.println("平均欧指-负 " + item.getAverageSP_F());
			System.out.println("平均欧指-半场-胜 " + item.getAverageSP_BC_S());
			System.out.println("平均欧指-半场-平 " + item.getAverageSP_BC_P());
			System.out.println("平均欧指-半场-负 " + item.getAverageSP_BC_F());
			System.out.println();
		}
	}

}
