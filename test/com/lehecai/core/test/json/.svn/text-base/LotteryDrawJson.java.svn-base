package com.lehecai.core.test.json;

import java.util.ArrayList;
import java.util.List;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDrawPrizeItem;
/**
 * 抓取开奖结果的json格式
 * @author leiming
 *
 */
public class LotteryDrawJson {
	public static void main(String[] args){
		LotteryDraw lotteryDraw = new LotteryDraw();
		lotteryDraw.setLotteryType(LotteryType.SSQ);
		lotteryDraw.setPhase("2011015");
		lotteryDraw.setJackpot("52332");
		lotteryDraw.setVolumeOfSales("123123123123");
		lotteryDraw.setTimeDraw("2011-02-14 15:20:35");
		lotteryDraw.setResult("1,2,3,4,5,6,7");
		
		LotteryDrawPrizeItem ld1 = new LotteryDrawPrizeItem();
		ld1.setName("一等奖");
		ld1.setPrizeAmount("12938912");
		ld1.setWinningCount("100");
		
		LotteryDrawPrizeItem ld2 = new LotteryDrawPrizeItem();
		ld2.setName("二等奖");
		ld2.setPrizeAmount("12938912");
		ld2.setWinningCount("500");
		
		List<LotteryDrawPrizeItem> lotteryDrawPrizeItems = new ArrayList<LotteryDrawPrizeItem>();
		lotteryDrawPrizeItems.add(ld1);
		lotteryDrawPrizeItems.add(ld2);
		
		lotteryDraw.setResultDetail(lotteryDrawPrizeItems);
		
		System.out.println(LotteryDraw.toJSON(lotteryDraw));
	}
}
