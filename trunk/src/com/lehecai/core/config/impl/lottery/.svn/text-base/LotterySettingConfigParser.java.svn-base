/**
 * 
 */
package com.lehecai.core.config.impl.lottery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.lehecai.core.config.IConfig;
import com.lehecai.core.config.IConfigItem;
import com.lehecai.core.config.impl.AbstractLotteryTypeSupportedConfigParser;
import com.lehecai.core.lottery.LotteryType;

/**
 * 彩种奖级配置配置解析器
 * @author qatang
 *
 */
public class LotterySettingConfigParser extends AbstractLotteryTypeSupportedConfigParser {
	
	@Override
	protected List<LotteryType> getSupportedLotteryTypeList() {
		return LotteryType.getItems();
	}

	@Override
	protected String getLotteryTypeItemKeyPrefix() {
		return StringUtils.EMPTY;
	}

	@Override
	public String getConfig(IConfig iconfig) {
		LotterySettingConfig lotterySettingItemConfig = (LotterySettingConfig) iconfig;
		if (lotterySettingItemConfig == null) {
			logger.info("未找到配置信息：彩种奖级配置");
			return null;
		}
		
		Map<LotteryType, LotterySettingConfigItem> lotterySettingItemMap = lotterySettingItemConfig.getLotteryTypeConfigItem();
		
		if (lotterySettingItemMap == null ) {
			logger.info("未找到配置信息：彩种奖级配置");
			return null;
		}
		
		JSONObject jsonObject = new JSONObject();
		if (lotterySettingItemMap != null) {
			//转换自定义配置
			logger.info("彩种奖级配置:转换自定义配置");
			
			for (LotteryType lotteryType : lotterySettingItemMap.keySet()) {
				LotterySettingConfigItem _lotterySettingItem = lotterySettingItemMap.get(lotteryType);
				
				JSONObject obj = _lotterySettingItem.toJSONObject();
				jsonObject.put(this.getLotteryTypeItemKey(lotteryType), obj);
			}
		}
		
		return jsonObject.toString();
	}

	@Override
	public String getConfigByItem(IConfig iconfig, String item) {
		LotterySettingConfig lotterySettingItemConfig = (LotterySettingConfig) iconfig;
		if (lotterySettingItemConfig == null) {
			logger.info("未找到配置信息：彩种奖级配置");
			return null;
		}
		if (item == null || item.equals("")) {
			logger.info("彩种奖级配置:读取单条配置时，item不能为空");
			return null;
		}
		Map<LotteryType, LotterySettingConfigItem> lotterySettingItemMap = lotterySettingItemConfig.getLotteryTypeConfigItem();
		
		LotteryType lotteryType = this.convertLotteryTypeFromKey(item);
		if (lotteryType == null) {
			return null;
		}
		if (lotterySettingItemMap != null) {
			LotterySettingConfigItem _lotterySettingItem = lotterySettingItemMap.get(lotteryType);
			return _lotterySettingItem.toJSONObject().toString();
		}
		return null;
	}

	@Override
	public IConfig convertFromJSON(Map<String, String> jsonMap) {
		if (jsonMap == null) {
			logger.info("将json数据转换为配置对象时，参数jsonMap不能为空");
			return null;
		}
		LotterySettingConfig lotterySettingItemConfig = new LotterySettingConfig();
		Map<LotteryType, LotterySettingConfigItem> lotterySettingItemMap = new HashMap<LotteryType, LotterySettingConfigItem>();
		for (String key : jsonMap.keySet()) {
			String value = jsonMap.get(key);
			JSONObject obj = null;
			try {
				obj = JSONObject.fromObject(value);
			} catch (Exception e) {
				logger.error("将json数据转换为配置对象时,jsonObject转换错误,key={}, value={}", key, value);
				logger.error(e.getMessage(), e);
			}
			if (obj == null || obj.isNullObject()) {
				logger.info("默认配置json串为空");
				continue;
			}
			
			LotteryType lotteryType = this.convertLotteryTypeFromKey(key);
			if (lotteryType == null) {
				continue;
			}
			LotterySettingConfigItem _lotterySettingItem = LotterySettingConfigItem.convertFromJSONObject(obj);
			lotterySettingItemMap.put(lotteryType, _lotterySettingItem);
			
		}
		lotterySettingItemConfig.setLotteryTypeConfigItem(lotterySettingItemMap);
		return lotterySettingItemConfig;
	}

	@Override
	public String formatConfigItem(IConfigItem configItem) {
		LotterySettingConfigItem lotterySettingConfigItem = (LotterySettingConfigItem)configItem;
		
		return lotterySettingConfigItem.toJSONObject().toString();
	}

	@Override
	public IConfigItem parseItem(String value) {
		JSONObject jsonObject = null;
		try {
			jsonObject = JSONObject.fromObject(value);
		} catch (Exception e) {
			logger.error("转换JSON数据出错", e);
		}
		if (jsonObject == null) {
			logger.error("无法转换成有效的JSON对象, value={}", value);
			return null;
		}
		return LotterySettingConfigItem.convertFromJSONObject(jsonObject);
	}
	
}
