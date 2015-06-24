package com.lehecai.core.test.lottery.fetcher;

import com.lehecai.core.lottery.fetcher.FetcherType;
import com.lehecai.core.lottery.fetcher.lotterydraw.ILotteryDrawFetcher;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.impl.LotteryDrawFetcher518;

public class Fetcher518Test {
	
	public static void main(String [] args) {
		try{
			ILotteryDrawFetcher fetcher = new LotteryDrawFetcher518();
			LotteryDraw lotterDraw = fetcher.fetch(null, FetcherType.T_500WAN);
			System.out.println(lotterDraw.getLotteryOpenResultLogMsg());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
