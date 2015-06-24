package com.lehecai.core.config.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.cache.OnSaleLotteryList;

public abstract class AbstractLotteryTypeSupportedConfigParser extends AbstractConfigParser {

	protected String getLotteryTypeItemKeyPrefix() {
		return "lottery_type_";
	}
	
	public String getLotteryTypeItemKey(LotteryType lotteryType) {
		return this.getLotteryTypeItemKeyPrefix() + lotteryType.getValue();
	}

	protected LotteryType convertLotteryTypeFromKey(String key) {
		if (key == null) {
			return null;
		}
		String lotteryTypeStr = StringUtils.substringAfter(key, this.getLotteryTypeItemKeyPrefix());

		LotteryType lotteryType = null;
		
		try {
			lotteryType = LotteryType.getItem(Integer.parseInt(lotteryTypeStr));
		} catch (Exception e) {
			logger.error("转换彩种类型出错, lotteryTypeStr={}", lotteryTypeStr);
			logger.error(e.getMessage(), e);
		}
		
		return lotteryType;
	}

	/**
	 * 支持的彩种列表
	 * 默认支持在售彩种
	 * @return
	 */
	protected List<LotteryType> getSupportedLotteryTypeList() {
		// 默认支持在售彩种
		return OnSaleLotteryList.get();
	}

	@Override
	protected List<String> getSupportedItemList() {
		List<String> itemList = new ArrayList<String>();
		for (LotteryType lotteryType : this.getSupportedLotteryTypeList()) {
			itemList.add(this.getLotteryTypeItemKey(lotteryType));
		}
		return itemList;
	}

}
