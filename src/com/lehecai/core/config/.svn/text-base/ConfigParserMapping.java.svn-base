/**
 * 
 */
package com.lehecai.core.config;

import java.util.HashMap;
import java.util.Map;

import com.lehecai.core.api.setting.SettingConstant;
import com.lehecai.core.config.impl.engine.EngineAddressConfigParser;
import com.lehecai.core.config.impl.lottery.LotterySettingConfigParser;
import com.lehecai.core.config.impl.lottery.LotteryStopSellConfigParser;
import com.lehecai.core.config.impl.lotterychase.ChaseCancelSMSConfigParser;
import com.lehecai.core.config.impl.lotterychase.ChaseCompleteSMSConfigParser;
import com.lehecai.core.config.impl.lotterychase.ChaseDrawFailedSMSConfigParser;
import com.lehecai.core.config.impl.lotterychase.ChaseStoppedSMSConfigParser;
import com.lehecai.core.config.impl.lotteryreward.RewardSMSConfigParser;

/**
 * @author sunshow
 *
 */
public class ConfigParserMapping {

	private static Map<String, IConfigParser> groupMapping = new HashMap<String, IConfigParser>();
	
	static {
		groupMapping.put(SettingConstant.GROUP_ENGINE_ADDRESS_CONFIG, new EngineAddressConfigParser());
		groupMapping.put(SettingConstant.GROUP_LOTTERY_CONFIG, new LotterySettingConfigParser());
		groupMapping.put(SettingConstant.GROUP_LOTTERY_STOP_SELL_CONFIG, new LotteryStopSellConfigParser());
		groupMapping.put(SettingConstant.GROUP_REWARD_SMS_CONFIG, new RewardSMSConfigParser());
		groupMapping.put(SettingConstant.GROUP_CHASE_CANCEL_SMS_CONFIG, new ChaseCancelSMSConfigParser());
		groupMapping.put(SettingConstant.GROUP_CHASE_COMPLETE_SMS_CONFIG, new ChaseCompleteSMSConfigParser());
		groupMapping.put(SettingConstant.GROUP_CHASE_DRAW_FAILED_SMS_CONFIG, new ChaseDrawFailedSMSConfigParser());
		groupMapping.put(SettingConstant.GROUP_CHASE_STOPPED_SMS_CONFIG, new ChaseStoppedSMSConfigParser());
		
	}
	
	public static IConfigParser getByGroup(String group) {
		if (groupMapping.containsKey(group)) {
			return groupMapping.get(group);
		}
		return null;
	}
}
