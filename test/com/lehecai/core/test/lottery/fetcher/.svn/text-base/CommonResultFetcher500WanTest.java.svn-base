package com.lehecai.core.test.lottery.fetcher;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.CountryLotteryDrawFetcher;

public class CommonResultFetcher500WanTest {
	public static void main(String[] args) throws UnsupportedFetcherTypeException{
		ILotteryDrawFetcher fetcher = new CountryLotteryDrawFetcher(LotteryType.QLC);
		System.out.println(fetcher.fetch(null).getLotteryOpenResultLogMsg());
	}
}
