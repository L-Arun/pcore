package com.lehecai.core.test.lottery.fetcher.dc;

import java.util.List;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.dc.DcLotteryDrawItem;
import com.lehecai.core.lottery.fetcher.dc.impl.CommonDcLotteryDrawFetcher;

public class CommonDcLotteryDrawFetcherTest {

	/**
	 * @param args
	 * @throws UnsupportedFetcherTypeException 
	 */
	public static void main(String[] args) throws UnsupportedFetcherTypeException {
		fetch(null);
		fetch("120312");
	}
	
	private static void fetch(String phase) throws UnsupportedFetcherTypeException{
		List<DcLotteryDrawItem> items = new CommonDcLotteryDrawFetcher().fetch(phase, FetcherType.T_OKOOO);
		for( DcLotteryDrawItem item : items){
			System.out.println(item.getLogInfo());
			System.out.println("****************************");
		}
	}

}
