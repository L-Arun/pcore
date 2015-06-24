/**
 * 
 */
package com.lehecai.core.config.impl.lottery;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.lehecai.core.config.IConfig;
import com.lehecai.core.config.IConfigItem;
import com.lehecai.core.config.impl.AbstractLotteryTypeSupportedConfigParser;
import com.lehecai.core.lottery.LotteryType;

/**
 * 全局彩种是否停售配置解析器
 * @author yanweijie
 *
 */
public class LotteryStopSellConfigParser extends AbstractLotteryTypeSupportedConfigParser {

	
	@Override
	public boolean hasDefaultItem() {
		return true;
	}

	@Override
	public String getConfig(IConfig iconfig) {
		LotteryStopSellConfig lotteryStopSellConfig = (LotteryStopSellConfig) iconfig;
		if (lotteryStopSellConfig == null) {
			logger.info("未找到配置信息：彩种是否停售配置");
			return null;
		}
		
		LotteryStopSellConfigItem lotteryStopSell = lotteryStopSellConfig.getDefaultConfigItem();
		Map<LotteryType, LotteryStopSellConfigItem> lotteryStopSellMap = lotteryStopSellConfig.getLotteryTypeConfigItem();
		
		JSONObject jsonObject = new JSONObject();
		
		if (lotteryStopSell != null) {
			//转换默认配置
			logger.info("全局彩种是否停售配置:转换默认配置");
			JSONObject defaultObject = lotteryStopSell.toJSONObject();
			jsonObject.put(this.getDefaultItemKey(), defaultObject);
		}
		
		if (lotteryStopSellMap != null) {
			//转换自定义配置
			logger.info("全局彩种是否停售配置:转换自定义配置");
			
			for (LotteryType lotteryType : lotteryStopSellMap.keySet()) {
				LotteryStopSellConfigItem _lotteryStopSell = lotteryStopSellMap.get(lotteryType);
				
				JSONObject obj = _lotteryStopSell.toJSONObject();
				jsonObject.put(this.getLotteryTypeItemKey(lotteryType), obj);
			}
		}

		return jsonObject.toString();
	}

	@Override
	public String getConfigByItem(IConfig iconfig, String item) {
		LotteryStopSellConfig lotteryStopSellConfig = (LotteryStopSellConfig) iconfig;
		if (lotteryStopSellConfig == null) {
			logger.info("未找到配置信息：全局彩种是否停售配置");
			return null;
		}
		if (item == null || item.equals("")) {
			logger.info("全局彩种是否停售配置:读取单条配置时，item不能为空");
			return null;
		}
		LotteryStopSellConfigItem lotteryStopSell = lotteryStopSellConfig.getDefaultConfigItem();
		Map<LotteryType, LotteryStopSellConfigItem> lotteryStopSellMap = lotteryStopSellConfig.getLotteryTypeConfigItem();
		
		if (item.equals(this.getDefaultItemKey())) {
			return lotteryStopSell.toJSONObject().toString();
		}

		LotteryType lotteryType = this.convertLotteryTypeFromKey(item);

		if (lotteryType == null) {
			return null;
		}
		if (lotteryStopSellMap != null) {
			LotteryStopSellConfigItem _lotteryStopSell = lotteryStopSellMap.get(lotteryType);
			return _lotteryStopSell.toJSONObject().toString();
		}
		return null;
	}
	
	@Override
	public IConfig convertFromJSON(Map<String, String> jsonMap) {
		if (jsonMap == null) {
			logger.info("将json数据转换为配置对象时，参数jsonMap不能为空");
			return null;
		}
		LotteryStopSellConfig lotterySellConfig = new LotteryStopSellConfig();
		Map<LotteryType, LotteryStopSellConfigItem> lotteryStopSellMap = new HashMap<LotteryType, LotteryStopSellConfigItem>();
		for (String key : jsonMap.keySet()) {
			String value = jsonMap.get(key);
			JSONObject obj = null;
			try {
				obj = JSONObject.fromObject(value);
			} catch (Exception e) {
				logger.error("将json数据转换为配置对象时,jsonObject转换错误,value={}", value, e);
			}
			if (obj == null || obj.isNullObject()) {
				logger.info("{}的配置json串为空", key);
				continue;
			}
			if (key.equals(this.getDefaultItemKey())) {
				lotterySellConfig.setDefaultConfigItem(LotteryStopSellConfigItem.convertFromJSONObject(obj));
			} else {
				LotteryType lotteryType = this.convertLotteryTypeFromKey(key);
				if (lotteryType == null) {
					continue;
				}
				LotteryStopSellConfigItem _lotteryStopSell = LotteryStopSellConfigItem.convertFromJSONObject(obj);
				lotteryStopSellMap.put(lotteryType, _lotteryStopSell);
			}
		}
		lotterySellConfig.setLotteryTypeConfigItem(lotteryStopSellMap);
		return lotterySellConfig;
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
		return LotteryStopSellConfigItem.convertFromJSONObject(jsonObject);
	}

	@Override
	public String formatConfigItem(IConfigItem configItem) {
		LotteryStopSellConfigItem lotteryStopSellConfigItem = (LotteryStopSellConfigItem)configItem;
		
		return lotteryStopSellConfigItem.toJSONObject().toString();
	}
}
