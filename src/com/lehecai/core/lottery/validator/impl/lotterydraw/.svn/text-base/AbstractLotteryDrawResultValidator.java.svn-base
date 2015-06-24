/**
 * 
 */
package com.lehecai.core.lottery.validator.impl.lotterydraw;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.api.lottery.LotteryConfig;
import com.lehecai.core.exception.ValidateFailedException;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.lotteryconfig.ResultTemplateItem;
import com.lehecai.core.lottery.validator.lotterydraw.ILotteryDrawResultValidator;

/**
 * @author sunshow
 *
 */
public abstract class AbstractLotteryDrawResultValidator implements ILotteryDrawResultValidator {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Override
	public void validate(LotteryType lotteryType, JSONArray resultArr, LotteryConfig lotteryConfig)
			throws ValidateFailedException {

		if (resultArr == null) {
			logger.error("开奖号码为空", lotteryType);
			throw new ValidateFailedException("开奖号码为空");
		}

		if (lotteryConfig == null) {
			logger.warn("未指定彩种配置, {}", lotteryType);
			throw new ValidateFailedException("未指定彩种配置");
		}

		if (lotteryConfig.getResultTemplateItemList() == null) {
			logger.error("未获取到开奖号码配置, {}", lotteryType);
			throw new ValidateFailedException("未获取到开奖号码配置");
		}

		for (int i = 0, imax = resultArr.size(); i < imax; i++) {
			JSONObject object = null;
			try {
				object = resultArr.getJSONObject(i);
			} catch (Exception e) {
				logger.error("从指定开奖结果中获取号码失败", e);
			}
			if (object == null) {
				logger.error("开奖号码格式不正确, {}", resultArr.toString());
				throw new ValidateFailedException("开奖号码格式不正确");
			}
			if (lotteryConfig.getResultTemplateItemList().size() <= i) {
				logger.error("号码定义数组长度小于给定的号码组数, i={}, result={}", i, object.toString());
				throw new ValidateFailedException("号码定义数组长度小于给定的号码组数");
			}
			ResultTemplateItem resultTemplateItem = lotteryConfig.getResultTemplateItemList().get(i);
			if (resultTemplateItem == null) {
				logger.error("对应彩种号码格式配置为空, result={}", object.toString());
				throw new ValidateFailedException("对应彩种号码格式配置为空");
			}
			
			this.validate(lotteryType, object, resultTemplateItem);
		}
	}
	
	/**
	 * 校验单一分组信息
	 * @param resultObject
	 * @param resultTemplateItem
	 * @throws ValidateFailedException
	 */
	abstract protected void validate(LotteryType lotteryType, JSONObject resultObject, ResultTemplateItem resultTemplateItem) throws ValidateFailedException;

}
