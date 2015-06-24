package com.lehecai.core.config.impl.engine;

import com.lehecai.core.api.setting.SettingConstant;
import com.lehecai.core.config.impl.AbstractLotteryTypeDefaultSupportedConfig;
/**
 * engine调用地址配置
 * @author yanweijie
 *
 */
public class EngineAddressConfig extends AbstractLotteryTypeDefaultSupportedConfig<EngineAddressConfigItem> {

	private static final long serialVersionUID = 3282022117581388536L;

	@Override
	public String getGroup() {
		return SettingConstant.GROUP_ENGINE_ADDRESS_CONFIG;
	}


}
