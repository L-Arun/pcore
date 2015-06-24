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
public class NumericLotteryMap {

	private static Map<Integer, LotteryType> _map = new HashMap<Integer, LotteryType>();
	
	static {
		_map.put(LotteryType.DLT.getValue(), LotteryType.DLT);
		_map.put(LotteryType.QXC.getValue(), LotteryType.QXC);
		_map.put(LotteryType.PL3.getValue(), LotteryType.PL3);
		_map.put(LotteryType.PL5.getValue(), LotteryType.PL5);
		_map.put(LotteryType.TC22X5.getValue(), LotteryType.TC22X5);
		
		_map.put(LotteryType.SSQ.getValue(), LotteryType.SSQ);
		_map.put(LotteryType.QLC.getValue(), LotteryType.QLC);
		_map.put(LotteryType.FC3D.getValue(), LotteryType.FC3D);
		_map.put(LotteryType.DF6J1.getValue(), LotteryType.DF6J1);
		_map.put(LotteryType.HD15X5.getValue(), LotteryType.HD15X5);
		
		_map.put(LotteryType.BJTC33X7.getValue(), LotteryType.BJTC33X7);
		
	}
	
	public static Map<Integer, LotteryType> get() {
		return _map;
	}

}
