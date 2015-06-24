/**
 * 
 */
package com.lehecai.core.lottery.task;

import java.util.List;

import com.lehecai.core.YesNoStatus;
import com.lehecai.core.lottery.LotteryType;

/**
 * @author qatang
 *
 */
public interface ILotteryRewardTask {
	/**
	 * 获得任务编码
	 * @return
	 */
	public String getTaskId();
	/**
	 * 获得彩期号
	 * @return
	 */
	public String getPhaseNo();
	/**
	 * 获得彩种类型值
	 * @return
	 */
	public LotteryType getLotteryType();
	/**
	 * 是否指定奖金范围内方案自动派奖
	 * @return
	 */
	public YesNoStatus getPrizeScopeReward();
	/**
	 * 指定奖金范围
	 * @return
	 */
	public double getPrizeScope();
	/**
	 * 派奖方案列表
	 * @return
	 */
	public List<String> getPlanNoList();
}
