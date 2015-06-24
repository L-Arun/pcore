package com.lehecai.core.lottery.validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.api.lottery.LotteryConfig;
import com.lehecai.core.exception.ValidateFailedException;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.cache.HighFrequencyLotteryMap;
import com.lehecai.core.lottery.cache.NumericLotteryMap;
import com.lehecai.core.lottery.validator.impl.lotterydraw.CommonLotteryDrawResultCountValidator;
import com.lehecai.core.lottery.validator.impl.lotterydraw.CommonLotteryDrawResultDuplicatedValidator;
import com.lehecai.core.lottery.validator.impl.lotterydraw.CommonLotteryDrawResultRegionValidator;
import com.lehecai.core.lottery.validator.lotterydraw.ILotteryDrawResultValidator;
public class LotteryDrawResultValidator {

	protected static final Logger logger = LoggerFactory.getLogger(LotteryDrawResultValidator.class.getName());

	private static Map<LotteryType, List<ILotteryDrawResultValidator>> lotteryTypeToValidatorMap = new HashMap<LotteryType, List<ILotteryDrawResultValidator>>();

	static {
		List<ILotteryDrawResultValidator> validatorList = new ArrayList<ILotteryDrawResultValidator>();
		validatorList.add(new CommonLotteryDrawResultCountValidator());
		validatorList.add(new CommonLotteryDrawResultRegionValidator());
		validatorList.add(new CommonLotteryDrawResultDuplicatedValidator());
		
		// 对在售的常规数字彩和高频彩种加校验
		{
			Set<Integer> keySet = NumericLotteryMap.get().keySet();
			for (Integer lotteryTypeValue : keySet) {
				LotteryType lotteryType = NumericLotteryMap.get().get(lotteryTypeValue);
				lotteryTypeToValidatorMap.put(lotteryType, validatorList);
			}
		}
		
		{
			Set<Integer> keySet = HighFrequencyLotteryMap.get().keySet();
			for (Integer lotteryTypeValue : keySet) {
				LotteryType lotteryType = HighFrequencyLotteryMap.get().get(lotteryTypeValue);
				lotteryTypeToValidatorMap.put(lotteryType, validatorList);
			}
		}
	}

	public static void validate(LotteryType lotteryType, JSONArray resultArr, LotteryConfig lotteryConfig) throws ValidateFailedException {
		if (!lotteryTypeToValidatorMap.containsKey(lotteryType)) {
			return;
		}
		List<ILotteryDrawResultValidator> validatorList = lotteryTypeToValidatorMap.get(lotteryType);
		for (ILotteryDrawResultValidator validator : validatorList) {
			validator.validate(lotteryType, resultArr, lotteryConfig);
		}
	}


}
