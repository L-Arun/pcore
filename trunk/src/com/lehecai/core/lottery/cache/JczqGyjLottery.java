/**
 * 
 */
package com.lehecai.core.lottery.cache;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.lehecai.core.lottery.LotteryType;

public class JczqGyjLottery {

	private static Map<LotteryType, Boolean> lotteryMap = null;
	
	static {
		Map<LotteryType, Boolean> _map = new HashMap<LotteryType, Boolean>();
		_map.put(LotteryType.JCZQ_GJ, true);
		_map.put(LotteryType.JCZQ_GYJ, true);
		
		lotteryMap = Collections.unmodifiableMap(_map);
	}
	
	/* 
	 * 返回竞彩足球冠亚军彩种Map
	 */
	public static boolean contains(LotteryType lotteryType) {
		return lotteryMap.containsKey(lotteryType);
	}
}
