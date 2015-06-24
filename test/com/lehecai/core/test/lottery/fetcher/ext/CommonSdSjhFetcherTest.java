package com.lehecai.core.test.lottery.fetcher.ext;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.ext.LotteryExtendItem;
import com.lehecai.core.lottery.fetcher.ext.impl.FC3DExtendSJHFetcher;

public class CommonSdSjhFetcherTest {

	/**
	 * @param args
	 * @throws UnsupportedFetcherTypeException 
	 */
	public static void main(String[] args) throws UnsupportedFetcherTypeException {
		LotteryExtendItem item = new FC3DExtendSJHFetcher().fetch(null);
		System.out.println(item.getExtendInfo());
	}

}
