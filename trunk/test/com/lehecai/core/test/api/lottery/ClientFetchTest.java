package com.lehecai.core.test.api.lottery;

import com.lehecai.core.exception.UnsupportedFetcherTypeException;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.ClientLotteryDrawFetcher;

public class ClientFetchTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//			LotteryDraw lotteryDraw = test(LotteryType.getItem(3),"10265");
//			System.out.println(lotteryDraw.getLotteryOpenResultLogMsg());
//			
//			LotteryDraw lotteryDraw2 = test(LotteryType.getItem(4),"10265");
//			System.out.println(lotteryDraw2.getLotteryOpenResultLogMsg());
//			
//			LotteryDraw lotteryDraw3 = test(LotteryType.getItem(7),"10088");
//			System.out.println(lotteryDraw3.getLotteryOpenResultLogMsg());
//			
//			LotteryDraw lotteryDraw4 = test(LotteryType.getItem(8),"10088");
//			System.out.println(lotteryDraw4.getLotteryOpenResultLogMsg());
			
			LotteryDraw lotteryDraw5 = test(LotteryType.getItem(10),null);
			System.out.println(lotteryDraw5.getLotteryOpenResultLogMsg());
			
//			LotteryDraw lotteryDraw6 = test(LotteryType.getItem(3),"09256");
//			System.out.println(lotteryDraw6.getLotteryOpenResultLogMsg());
//			
//			LotteryDraw lotteryDraw7 = test(LotteryType.getItem(4),"09256");
//			System.out.println(lotteryDraw7.getLotteryOpenResultLogMsg());
			
		} catch (UnsupportedFetcherTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static LotteryDraw test(LotteryType lotteryType, String phase) throws UnsupportedFetcherTypeException{
		ClientLotteryDrawFetcher clientLotteryDrawFetcher = new ClientLotteryDrawFetcher(lotteryType);
		LotteryDraw lotteryDraw = clientLotteryDrawFetcher.fetch(phase, FetcherType.T_CLIENT);
		return lotteryDraw;
	}
}
