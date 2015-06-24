package com.lehecai.core.lottery.validator.impl.lotterydraw;

import net.sf.json.JSONObject;

import com.lehecai.core.exception.ValidateFailedException;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.lotteryconfig.ResultTemplateItem;

public abstract class AbstractLotteryDrawResultDuplicatedValidator extends AbstractLotteryDrawResultValidator {

	/**
	 * 校验号码是否可以有重复数字
	 * @return
	 */
	@Override
	abstract protected void validate(LotteryType lotteryType, JSONObject resultObject, ResultTemplateItem resultTemplateItem) throws ValidateFailedException;

}
