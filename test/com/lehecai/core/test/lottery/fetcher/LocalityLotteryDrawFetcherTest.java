/**
 * 
 */
package com.lehecai.core.test.lottery.fetcher;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.LocalityLotteryDrawFetcher;

/**
 * 测试
 *
 */
public class LocalityLotteryDrawFetcherTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ILotteryDrawFetcher fetcher = null;
		LotteryDraw lotteryDraw = null;
		try {
			fetcher = new LocalityLotteryDrawFetcher(LotteryType.A_FJ22);
			lotteryDraw = fetcher.fetch(null, FetcherType.T_STARLOTT);
			System.out.println(lotteryDraw.getLotteryOpenResultLogMsg());
		} catch (UnsupportedFetcherTypeException e1) {
			e1.printStackTrace();
		}
		
	}

}
