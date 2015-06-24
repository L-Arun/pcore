package com.lehecai.core.lottery.validator.impl.lotterydraw;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.lottery.LotteryConfig;
import com.lehecai.core.exception.ValidateFailedException;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.lotteryconfig.ResultTemplateItem;

public class CommonLotteryDrawResultCountValidator extends AbstractLotteryDrawResultCountValidator {

	
	@Override
	protected void validate(LotteryType lotteryType, JSONObject resultObject,
			ResultTemplateItem resultTemplateItem)
			throws ValidateFailedException {
		
		JSONArray drawNumberArray = null;
		try {
			drawNumberArray = resultObject.getJSONArray(LotteryConfig.JSON_KEYNAME_RESULT_DATA);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		if (drawNumberArray == null) {
			logger.error("获取开奖号码出错, {}", resultObject.toString());
			throw new ValidateFailedException("获取开奖号码出错");
		}
		
		if (resultTemplateItem.getResultCount() != null && resultTemplateItem.getResultCount() > 0) {
			if (drawNumberArray.size() != resultTemplateItem.getResultCount()) {
				logger.error("开奖号码位数与配置不符，resultCount={}, configCount={}", drawNumberArray.size(), resultTemplateItem.getResultCount());
				throw new ValidateFailedException("开奖号码位数与配置不符");
			}
		}
	}
}
