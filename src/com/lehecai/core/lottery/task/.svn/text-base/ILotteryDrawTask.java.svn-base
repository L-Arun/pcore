package com.lehecai.core.lottery.task;

import com.lehecai.core.lottery.BetType;
import com.lehecai.core.lottery.DrawType;
import com.lehecai.core.lottery.LotteryType;

public interface ILotteryDrawTask {
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
	 * 投注类型
	 * @return
	 */
	public BetType getBetType();
	/**
	 * 开奖类型
	 * @return
	 */
	public DrawType getDrawType();
	
	/**
	 * 是否只开流产
	 * @return
	 */
	public boolean isForAbort();
}
