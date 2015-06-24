package com.lehecai.core.lottery.validator.impl.lotterydraw;

import java.util.HashSet;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.YesNoStatus;
import com.lehecai.core.api.lottery.LotteryConfig;
import com.lehecai.core.exception.ValidateFailedException;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.lotteryconfig.ResultTemplateItem;

public class CommonLotteryDrawResultDuplicatedValidator extends
		AbstractLotteryDrawResultDuplicatedValidator {


	@Override
	protected void validate(LotteryType lotteryType, JSONObject resultObject,
			ResultTemplateItem resultTemplateItem)
			throws ValidateFailedException {
		if (resultTemplateItem.getAllowDuplicated() == null) {
			logger.warn("未定义本组号码是否允许重复，不做判断");
			return;
		}
		
		if (resultTemplateItem.getAllowDuplicated().getValue() == YesNoStatus.YES.getValue()) {
			logger.info("本组号码允许重复，不做判断");
			return;
		}
		
		// 进行组内号码判重
		Set<String> drawNumberSet = new HashSet<String>();
		
		JSONArray drawNumberArray = null;
		try {
			drawNumberArray = resultObject.getJSONArray(LotteryConfig.JSON_KEYNAME_RESULT_DATA);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		if (drawNumberArray == null) {
			logger.error("获取开奖号码出错，不做判断, {}", resultObject.toString());
			return;
		}
		for (int i = 0, imax = drawNumberArray.size(); i < imax; i++) {
			drawNumberSet.add(drawNumberArray.getString(i));
		}
		if (drawNumberSet.size() < drawNumberArray.size()) {
			throw new ValidateFailedException("配置为不允许重复，但是开奖号码中有重复号码");
		}
	}
}
