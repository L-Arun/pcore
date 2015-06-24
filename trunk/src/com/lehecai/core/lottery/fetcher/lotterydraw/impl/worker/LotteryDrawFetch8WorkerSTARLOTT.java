package com.lehecai.core.lottery.fetcher.lotterydraw.impl.worker;

import com.lehecai.core.lottery.LotteryType;


public class LotteryDrawFetch8WorkerSTARLOTT extends LotteryDrawFetch7WorkerSTARLOTT{
	public LotteryDrawFetch8WorkerSTARLOTT(){
		super(LotteryType.SFR9);
		this.volumeOfSalesName="CathMoney_R9";
		this.lotteryMiddleKeyValue=LotteryType.SFR9.getName();
	}
}
