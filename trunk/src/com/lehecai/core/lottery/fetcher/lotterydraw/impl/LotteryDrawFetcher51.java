package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;

/**
 * 七乐彩 结果抓取
 * @author leiming
 *
 */
public class LotteryDrawFetcher51 extends CountryLotteryDrawFetcher{
	public LotteryDrawFetcher51(){
		super(LotteryType.QLC);
	}
	
	@Override
	protected LotteryDraw fetch500Wan(String phase) {
		String queryPhase = phase;
		
		// 将系统期号转换成和500wan匹配的期号
		if (phase != null && phase.length() == 7) {
			queryPhase = phase.substring(2);
		}
		
		LotteryDraw resultObj = super.fetch500Wan(queryPhase);
		
		// 将抓取的期号转换回系统期号
		if (phase != null && phase.length() == 7) {
			resultObj.setPhase(phase);
		}
		if(phase==null&& resultObj.getPhase().length() == 5){
			resultObj.setPhase("20"+resultObj.getPhase());
		}
		return resultObj;
	}
	
	@Override
	protected LotteryDraw fetchSTARLOTT(String phase) {
		String queryPhase = phase;
		
		// 将系统期号转换成和STARLOTT匹配的期号
		if (phase != null && phase.length() == 7) {
			queryPhase = phase.substring(2);
		}
		
		LotteryDraw resultObj = super.fetchSTARLOTT(queryPhase);
		
		// 将抓取的期号转换回系统期号
		if (phase != null && phase.length() == 7) {
			resultObj.setPhase(phase);
		}
		if(phase==null&& resultObj.getPhase().length() == 5){
			resultObj.setPhase("20"+resultObj.getPhase());
		}
		return resultObj;
	}
}
