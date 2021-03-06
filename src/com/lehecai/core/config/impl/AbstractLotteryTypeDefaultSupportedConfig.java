/**
 * 
 */
package com.lehecai.core.config.impl;

import java.util.Map;

import com.lehecai.core.lottery.LotteryType;


/**
 * 带默认配置和彩种列表支持的配置
 * @author sunshow
 *
 */
public abstract class AbstractLotteryTypeDefaultSupportedConfig<T extends AbstractDefaultSupportedConfigItem> extends AbstractDefaultSupportedConfig<T> {

	private static final long serialVersionUID = 1L;

	/**
	 * 每个彩种对应的配置
	 */
	private Map<LotteryType, T> lotteryTypeConfigItem;

	public Map<LotteryType, T> getLotteryTypeConfigItem() {
		return lotteryTypeConfigItem;
	}
	public void setLotteryTypeConfigItem(Map<LotteryType, T> lotteryTypeConfigItem) {
		this.lotteryTypeConfigItem = lotteryTypeConfigItem;
	}

}
