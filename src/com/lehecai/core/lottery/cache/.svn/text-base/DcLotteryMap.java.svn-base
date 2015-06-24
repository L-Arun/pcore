/**
 * 
 */
package com.lehecai.core.lottery.cache;

import java.util.HashMap;
import java.util.Map;

import com.lehecai.core.lottery.LotteryType;

/**
 * @author Sunshow
 *
 */
public class DcLotteryMap {

	private static Map<Integer, LotteryType> _map = new HashMap<Integer, LotteryType>();
	
	static {
		_map.put(LotteryType.DC_SFP.getValue(), LotteryType.DC_SFP);
		_map.put(LotteryType.DC_SXDS.getValue(), LotteryType.DC_SXDS);
		_map.put(LotteryType.DC_JQS.getValue(), LotteryType.DC_JQS);
		_map.put(LotteryType.DC_BF.getValue(), LotteryType.DC_BF);
		_map.put(LotteryType.DC_BCSFP.getValue(), LotteryType.DC_BCSFP);
	}
	
	/* 
	 * 返回北单彩种Map
	 */
	public static Map<Integer, LotteryType> get() {
		return _map;
	}

}
