/**
 * 
 */
package com.lehecai.core.config.impl.engine;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.lehecai.core.config.IConfig;
import com.lehecai.core.config.IConfigItem;
import com.lehecai.core.config.impl.AbstractLotteryTypeSupportedConfigParser;
import com.lehecai.core.lottery.LotteryType;

/**
 * engine调用地址配置解析器
 * @author yanweijie
 *
 */
public class EngineAddressConfigParser extends AbstractLotteryTypeSupportedConfigParser {

	@Override
	public boolean hasDefaultItem() {
		return true;
	}

	@Override
	public String getConfig(IConfig iconfig) {
		EngineAddressConfig engineAddressConfig = (EngineAddressConfig) iconfig;
		if (engineAddressConfig == null) {
			logger.info("未找到配置信息：engine调用地址配置");
			return null;
		}
		
		EngineAddressConfigItem engineAddress = engineAddressConfig.getDefaultConfigItem();
		Map<LotteryType, EngineAddressConfigItem> engineAddressMap = engineAddressConfig.getLotteryTypeConfigItem();
		
		JSONObject jsonObject = new JSONObject();
		
		if (engineAddress != null) {
			//转换默认配置
			logger.info("engine调用地址配置:转换默认配置");
			JSONObject defaultObject = engineAddress.toJSONObject();
			jsonObject.put(this.getDefaultItemKey(), defaultObject);
		}
		
		if (engineAddressMap != null) {
			//转换自定义配置
			logger.info("engine调用地址配置:转换自定义配置");
			
			for (LotteryType lotteryType : engineAddressMap.keySet()) {
				EngineAddressConfigItem _engineAddress = engineAddressMap.get(lotteryType);
				
				JSONObject obj = _engineAddress.toJSONObject();
				jsonObject.put(this.getLotteryTypeItemKey(lotteryType), obj);
			}
		}
		
		return jsonObject.toString();
	}

	@Override
	public String getConfigByItem(IConfig iconfig, String item) {
		EngineAddressConfig engineAddressConfig = (EngineAddressConfig) iconfig;
		if (engineAddressConfig == null) {
			logger.info("未找到配置信息：engine调用地址配置");
			return null;
		}
		if (item == null || item.equals("")) {
			logger.info("engine调用地址配置:读取单条配置时，item不能为空");
			return null;
		}
		EngineAddressConfigItem engineAddress = engineAddressConfig.getDefaultConfigItem();
		Map<LotteryType, EngineAddressConfigItem> engineAddressMap = engineAddressConfig.getLotteryTypeConfigItem();
		
		if (item.equals(this.getDefaultItemKey())) {
			return engineAddress.toJSONObject().toString();
		}
		
		LotteryType lotteryType = this.convertLotteryTypeFromKey(item);
		
		if (lotteryType == null) {
			return null;
		}
		if (engineAddressMap != null) {
			EngineAddressConfigItem _engineAddress = engineAddressMap.get(lotteryType);
			return _engineAddress.toJSONObject().toString();
		}
		return null;
	}
	
	@Override
	public IConfig convertFromJSON(Map<String, String> jsonMap) {
		if (jsonMap == null) {
			logger.info("将json数据转换为配置对象时，参数jsonMap不能为空");
			return null;
		}
		EngineAddressConfig engineAddressConfig = new EngineAddressConfig();
		Map<LotteryType, EngineAddressConfigItem> engineAddressMap = new HashMap<LotteryType, EngineAddressConfigItem>();
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
				engineAddressConfig.setDefaultConfigItem(EngineAddressConfigItem.convertFromJSONObject(obj));
			} else {
				LotteryType lotteryType = this.convertLotteryTypeFromKey(key);

				if (lotteryType == null) {
					continue;
				}
				EngineAddressConfigItem _engineAddress = EngineAddressConfigItem.convertFromJSONObject(obj);
				engineAddressMap.put(lotteryType, _engineAddress);
			}
		}
		engineAddressConfig.setLotteryTypeConfigItem(engineAddressMap);
		return engineAddressConfig;
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
		return EngineAddressConfigItem.convertFromJSONObject(jsonObject);
	}

	@Override
	public String formatConfigItem(IConfigItem configItem) {
		EngineAddressConfigItem engineAddressConfigItem = (EngineAddressConfigItem)configItem;
		
		return engineAddressConfigItem.toJSONObject().toString();
	}

}
