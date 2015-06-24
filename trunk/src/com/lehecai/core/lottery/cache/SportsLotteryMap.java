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
public class SportsLotteryMap {

	private static Map<Integer, LotteryType> _map = new HashMap<Integer, LotteryType>();
	
	static {
		_map.put(LotteryType.SFC.getValue(), LotteryType.SFC);
		_map.put(LotteryType.SFR9.getValue(), LotteryType.SFR9);
		_map.put(LotteryType.JQC.getValue(), LotteryType.JQC);
		_map.put(LotteryType.BQC.getValue(), LotteryType.BQC);
		
		_map.put(LotteryType.DC_SFP.getValue(), LotteryType.DC_SFP);
		_map.put(LotteryType.DC_SXDS.getValue(), LotteryType.DC_SXDS);
		_map.put(LotteryType.DC_JQS.getValue(), LotteryType.DC_JQS);
		_map.put(LotteryType.DC_BF.getValue(), LotteryType.DC_BF);
		_map.put(LotteryType.DC_BCSFP.getValue(), LotteryType.DC_BCSFP);
		_map.put(LotteryType.DC_SFGG.getValue(), LotteryType.DC_SFGG);
		
		_map.put(LotteryType.JCLQ_SF.getValue(), LotteryType.JCLQ_SF);
		_map.put(LotteryType.JCLQ_RFSF.getValue(), LotteryType.JCLQ_RFSF);
		_map.put(LotteryType.JCLQ_SFC.getValue(), LotteryType.JCLQ_SFC);
		_map.put(LotteryType.JCLQ_DXF.getValue(), LotteryType.JCLQ_DXF);
		
		_map.put(LotteryType.JCZQ_SPF.getValue(), LotteryType.JCZQ_SPF);
		_map.put(LotteryType.JCZQ_BF.getValue(), LotteryType.JCZQ_BF);
		_map.put(LotteryType.JCZQ_JQS.getValue(), LotteryType.JCZQ_JQS);
		_map.put(LotteryType.JCZQ_BQC.getValue(), LotteryType.JCZQ_BQC);
		_map.put(LotteryType.JCZQ_GJ.getValue(), LotteryType.JCZQ_GJ);
		_map.put(LotteryType.JCZQ_GYJ.getValue(), LotteryType.JCZQ_GYJ);
	}
	
	public static Map<Integer, LotteryType> get() {
		return _map;
	}

}
