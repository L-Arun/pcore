package com.lehecai.core.test.lottery.fetcher.ext;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.ext.LotteryExtendItem;
import com.lehecai.core.lottery.fetcher.ext.impl.FC3DExtendSJHFetcher;

public class CommonSdSjhFetcherZHCWTest {

	/**
	 * @param args
	 * @throws UnsupportedFetcherTypeException 
	 */
	public static void main(String[] args) throws UnsupportedFetcherTypeException {
		LotteryExtendItem lotteryExtendItem = new FC3DExtendSJHFetcher().fetch(null, FetcherType.T_ZHCW);
		LotteryExtendItem lotteryExtendItem1 = new FC3DExtendSJHFetcher().fetch("2011106", FetcherType.T_ZHCW);
		LotteryExtendItem lotteryExtendItem2 = new FC3DExtendSJHFetcher().fetch("2011186", FetcherType.T_ZHCW);
		
		if (lotteryExtendItem != null) {
			System.out.println(lotteryExtendItem.getExtendInfo());
		}
		if (lotteryExtendItem1 != null) {
			System.out.println(lotteryExtendItem1.getExtendInfo());
		}
		if (lotteryExtendItem2 != null) {
			System.out.println(lotteryExtendItem2.getExtendInfo());
		}
	}

}
