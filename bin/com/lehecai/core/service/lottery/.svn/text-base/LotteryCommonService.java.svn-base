/**
 * 
 */
package com.lehecai.core.service.lottery;

import com.lehecai.core.api.lottery.LotteryConfig;
import com.lehecai.core.lottery.LotteryType;

/**
 * @author sunshow
 *
 */
public interface LotteryCommonService {

	/**
	 * 获取指定彩种的彩种配置
	 * @param lotteryType
	 * @return
	 */
	public LotteryConfig getLotteryConfig(LotteryType lotteryType);
	
	/**
	 * 从缓存中获取指定彩种的彩种配置，如果缓存不存在，自动建立缓存
	 * @param lotteryType
	 * @return
	 */
	public LotteryConfig getLotteryConfigFromCache(LotteryType lotteryType);

	/**
	 * 清空全部的彩种缓存
	 */
	public void removeAllLotteryConfigCache();
}
