package com.lehecai.core.lottery.validator.impl.lotterydraw;

import net.sf.json.JSONObject;

import com.lehecai.core.exception.ValidateFailedException;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.lotteryconfig.ResultTemplateItem;

/**
 * 校验开奖号码是否在指定的范围内
 * @author sunshow
 *
 */
public abstract class AbstractLotteryDrawResultRegionValidator extends AbstractLotteryDrawResultValidator {
	
	/**
	 * 校验号码是否在指定的范围内
	 * @return
	 */
	@Override
	abstract protected void validate(LotteryType lotteryType, JSONObject resultObject,
			ResultTemplateItem resultTemplateItem)
			throws ValidateFailedException;

}
