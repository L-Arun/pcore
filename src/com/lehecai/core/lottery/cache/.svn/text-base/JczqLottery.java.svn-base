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
public class JczqLottery {

	private static Map<LotteryType, Boolean> lotteryMap = null;
	
	private static List<LotteryType> lotteryList = null;
	
	static {
		Map<LotteryType, Boolean> _map = new HashMap<LotteryType, Boolean>();
		_map.put(LotteryType.JCZQ_SPF, true);
		_map.put(LotteryType.JCZQ_BF, true);
		_map.put(LotteryType.JCZQ_JQS, true);
		_map.put(LotteryType.JCZQ_BQC, true);
		
		lotteryMap = Collections.unmodifiableMap(_map);

		List<LotteryType> _list = new ArrayList<LotteryType>();
		_list.add(LotteryType.JCZQ_SPF);
		_list.add(LotteryType.JCZQ_BF);
		_list.add(LotteryType.JCZQ_JQS);
		_list.add(LotteryType.JCZQ_BQC);
		
		lotteryList = Collections.unmodifiableList(_list);
	}

	/**
	 * 获得竞彩足球彩种列表
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
		
		// 如果是比分，都是固定奖金
		if (lotteryType.getValue() == LotteryType.JCZQ_BF.getValue()) {
			return true;
		}
		
		// 其他几个玩法，单关为浮动奖金，过关为固定奖金
		if (playType == null) {
			return false;
		}
		
		if (!contains(playType.getLotteryType())) {
			return false;
		}
		
		if (playType.getValue() == PlayType.JCZQ_SPF_FD_1.getValue()
				|| playType.getValue() == PlayType.JCZQ_JQS_FD_1.getValue()
				|| playType.getValue() == PlayType.JCZQ_BQC_FD_1.getValue()) {
			return false;
		}
		
		return true;
	}
}
