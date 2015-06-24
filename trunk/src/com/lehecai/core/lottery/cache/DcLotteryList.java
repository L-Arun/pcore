package com.lehecai.core.lottery.cache;

import java.util.ArrayList;
import java.util.List;

import com.lehecai.core.lottery.LotteryType;

public class DcLotteryList {
	private static List<LotteryType> _dcList = new ArrayList<LotteryType>();
	
	static {
		_dcList.add(LotteryType.DC_SFP);
		_dcList.add(LotteryType.DC_SXDS);
		_dcList.add(LotteryType.DC_JQS);
		_dcList.add(LotteryType.DC_BF);
		_dcList.add(LotteryType.DC_BCSFP);
		
	}
	/**
	 * 获得单场彩种列表
	 * @return
	 */
	public static List<LotteryType> getList(){
		return _dcList;
	}
}
