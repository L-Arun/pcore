/**
 * 
 */
package com.lehecai.core.lottery.cache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.PlayType;

/**
 * @author qatang
 *
 */
public class JclqLottery {

private static Map<LotteryType, Boolean> lotteryMap = null;
	
	private static List<LotteryType> lotteryList = null;
	
	static {
		Map<LotteryType, Boolean> _map = new HashMap<LotteryType, Boolean>();
		_map.put(LotteryType.JCLQ_SF, true);
		_map.put(LotteryType.JCLQ_RFSF, true);
		_map.put(LotteryType.JCLQ_SFC, true);
		_map.put(LotteryType.JCLQ_DXF, true);
		
		lotteryMap = Collections.unmodifiableMap(_map);

		List<LotteryType> _list = new ArrayList<LotteryType>();
		_list.add(LotteryType.JCLQ_SF);
		_list.add(LotteryType.JCLQ_RFSF);
		_list.add(LotteryType.JCLQ_SFC);
		_list.add(LotteryType.JCLQ_DXF);
		
		lotteryList = Collections.unmodifiableList(_list);
	}

	/**
	 * 获得竞彩篮球彩种列表
	 * @return
	 */
	public static List<LotteryType> getList(){
		return lotteryList;
	}
	
	public static boolean contains(LotteryType lotteryType) {
		return lotteryMap.containsKey(lotteryType);
	}

	public static boolean isDynamicPrize(LotteryType lotteryType, PlayType playType) {
		if (lotteryType == null || !contains(lotteryType)) {
			return false;
		}
		
		if (playType == null) {
			return false;
		}
		
		if (!contains(playType.getLotteryType())) {
			return false;
		}
		
		// 是本彩种非固定奖金，则为浮动奖金
		return !isStaicPrize(lotteryType, playType);
	}
	
	public static boolean isStaicPrize(LotteryType lotteryType, PlayType playType) {
		if (lotteryType == null || !contains(lotteryType)) {
			return false;
		}
		
		// 如果是胜分差，都是固定奖金
		if (lotteryType.getValue() == LotteryType.JCLQ_SFC.getValue()) {
			return true;
		}
		
		// 其他几个玩法，单关为浮动奖金，过关为固定奖金
		if (playType == null) {
			return false;
		}
		
		if (!contains(playType.getLotteryType())) {
			return false;
		}
		
		if (playType.getValue() == PlayType.JCLQ_SF_FD_1.getValue()
				|| playType.getValue() == PlayType.JCLQ_RFSF_FD_1.getValue()
				|| playType.getValue() == PlayType.JCLQ_DXF_FD_1.getValue()) {
			return false;
		}
		
		return true;
	}

}
