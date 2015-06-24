package com.lehecai.core.lottery.validator.impl.lotterydraw;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.lottery.LotteryConfig;
import com.lehecai.core.exception.ValidateFailedException;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.ResultRegionType;
import com.lehecai.core.lottery.lotteryconfig.ResultTemplateItem;

public class CommonLotteryDrawResultRegionValidator extends
		AbstractLotteryDrawResultRegionValidator {

	@Override
	protected void validate(LotteryType lotteryType, JSONObject resultObject,
			ResultTemplateItem resultTemplateItem)
			throws ValidateFailedException {
		if (resultTemplateItem.getResultRegionType() == null) {
			logger.warn("未定义本组号码候选范围类型，不做判断");
			return;
		}
		
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

		String[] regionArray = null;
		if (resultTemplateItem.getResultRegionType().getValue() == ResultRegionType.DESIGNATED_SECTION.getValue()) {
			if (resultTemplateItem.getDesignatedSection() != null) {
				regionArray = StringUtils.split(resultTemplateItem.getDesignatedSection(), " ,:;");
			}
		}

		for (int i = 0, imax = drawNumberArray.size(); i < imax; i++) {
			String number = drawNumberArray.getString(i);
			if (resultTemplateItem.getResultRegionType().getValue() == ResultRegionType.DIGITAL_SECTION.getValue()) {
				this.validateDigital(number, resultTemplateItem.getMinDigit(), resultTemplateItem.getMaxDigit(), resultTemplateItem.getDigitCapacity());
				continue;
			}
			if (resultTemplateItem.getResultRegionType().getValue() == ResultRegionType.DESIGNATED_SECTION.getValue()) {
				this.validateRegion(number, regionArray);
			}
		}
	}
	
	protected void validateRegion(String number, String[] regionArray) throws ValidateFailedException {
		if (regionArray == null) {
			logger.warn("配置的号码范围为空，不做判断, number={}", number);
			return;
		}
		if (!ArrayUtils.contains(regionArray, number)) {
			logger.error("开奖号码不在指定范围内, number={}, region={}", number, StringUtils.join(regionArray, ","));
			throw new ValidateFailedException("开奖号码不在指定范围内");
		}
	}
	
	protected void validateDigital(String number, Integer minVal, Integer maxVal, Integer capactiy) throws ValidateFailedException {
		// 首先校验是数字
		int intval = 0;
		
		try {
			intval = Integer.parseInt(number);
		} catch (NumberFormatException e) {
			logger.error(e.getMessage(), e);
			throw new ValidateFailedException("开奖号码转换数字格式出错");
		}

		// 所有判断均排除负值
		if (intval < 0) {
			logger.error("开奖号码不能为负数, number={}", number);
			throw new ValidateFailedException("开奖号码为负数");
		}

		// 判断位数
		if (capactiy != null && capactiy > 0) {
			if (number.length() != capactiy) {
				logger.error("开奖号码位数不正确，number={}, capactiy={}", number, capactiy);
				throw new ValidateFailedException("开奖号码位数不正确");
			}
		}

		if (minVal != null && minVal >= 0) {
			if (intval < minVal) {
				logger.error("开奖号码小于最小值, number={}, min={}", number, minVal);
				throw new ValidateFailedException("开奖号码小于最小值");
			}
		}

		if (maxVal != null && maxVal >= 0) {
			if (intval > maxVal) {
				logger.error("开奖号码大于最大值, number={}, max={}", number, maxVal);
				throw new ValidateFailedException("开奖号码大于最大值");
			}
		}
	}
}
