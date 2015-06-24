/**
 * 
 */
package com.lehecai.core.lottery.cache;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.lehecai.core.lottery.LotteryType;

/**
 * 支持彩票套餐的彩种列表定义
 * @author Sunshow
 *
 */
public class ComboLotteryMap {

	private static Map<LotteryType, LotteryType> _map;
	
	static {
		Map<LotteryType, LotteryType> map = new HashMap<LotteryType, LotteryType>();
		map.put(LotteryType.DLT, LotteryType.DLT);
		map.put(LotteryType.QXC, LotteryType.QXC);
		map.put(LotteryType.SSQ, LotteryType.SSQ);
		
		_map = Collections.unmodifiableMap(map);
	}
	
	public static boolean contain(LotteryType lotteryType) {
		return _map.containsKey(lotteryType);
	}
	
	/* 
	 * 返回北单彩种Map
	 */
	public static Map<LotteryType, LotteryType> get() {
		return _map;
	}

}
