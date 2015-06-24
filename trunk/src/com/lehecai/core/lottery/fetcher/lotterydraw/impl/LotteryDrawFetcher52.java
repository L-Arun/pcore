package com.lehecai.core.lottery.fetcher.lotterydraw.impl;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.fetcher.lotterydraw.LotteryDraw;

/**
 * 福彩3D 结果抓取
 * @author leiming
 *
 */
public class LotteryDrawFetcher52 extends CountryLotteryDrawFetcher{
	public LotteryDrawFetcher52(){
		super(LotteryType.FC3D);
	}
	
	@Override
	protected LotteryDraw fetch500Wan(String phase) {
		String queryPhase = phase;

		
		LotteryDraw resultObj = super.fetch500Wan(queryPhase);
		
		// 将抓取的期号转换回系统期号
		if (phase != null && phase.length() == 7) {
			resultObj.setPhase(phase);
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
		
		return resultObj;
	}
}
