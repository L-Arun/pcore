package com.lehecai.core.test.lottery.fetcher.dc;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.dc.IDcScheduleFetcher;
import com.lehecai.core.lottery.fetcher.dc.impl.CommonDcScheduleFetcher;

public class CommonDcScheduleFetchWorker500WanTest {
	public static void main(String[] args) throws UnsupportedFetcherTypeException{
		IDcScheduleFetcher fetcher = new CommonDcScheduleFetcher();
		String phase="120301";
		fetcher.fetch(phase, FetcherType.T_500WAN);
		
		phase = null;
		fetcher.fetch(phase, FetcherType.T_500WAN);
		
//		phase = "10";
//		fetcher.fetch(phase, FetcherType.T_500WAN);
	}
}
