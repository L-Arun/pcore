package com.lehecai.core.lottery.validator.lotterydraw;

import net.sf.json.JSONArray;

import com.lehecai.core.api.lottery.LotteryConfig;
import com.lehecai.core.exception.ValidateFailedException;
import com.lehecai.core.lottery.LotteryType;

/**
 * 开奖结果号码校验
 */
public interface ILotteryDrawResultValidator {
	/**
	 * @param resultArr 入库保存的JSON格式开奖号码
	 * @param lotteryConfig 彩种配置
	 * @throws ValidateFailedException
	 */
	public void validate(LotteryType lotteryType, JSONArray resultArr, LotteryConfig lotteryConfig) throws ValidateFailedException;
}
