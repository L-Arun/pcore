package com.lehecai.core.test.lottery.fetcher.dc;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.dc.IDcLotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.dc.impl.CommonDcLotteryDrawFetcher;

public class CommonDcLotteryDrawFetchWorker500WanTest {

	/**
	 * @param args
	 * @throws UnsupportedFetcherTypeException 
	 */
	public static void main(String[] args) throws UnsupportedFetcherTypeException {
		IDcLotteryDrawFetcher fetcher = new CommonDcLotteryDrawFetcher();
		String phase = "101013";
		fetcher.fetch(phase,FetcherType.T_500WAN);
		
		phase = null;
		fetcher.fetch(phase,FetcherType.T_500WAN);
	}

}
