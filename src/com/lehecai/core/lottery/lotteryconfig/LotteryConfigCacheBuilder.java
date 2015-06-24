/**
 * 
 */
package com.lehecai.core.lottery.lotteryconfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.api.lottery.LotteryConfig;
import com.lehecai.core.api.setting.SettingConstant;
import com.lehecai.core.exception.ApiRemoteCallFailedException;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.service.setting.SettingService;

/**
 * 彩票配置缓存构建器
 * @author leiming
 *
 */
public class LotteryConfigCacheBuilder {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private SettingService settingService;//ioc注入
	
	/**
	 * 取得全部彩票类型对应的彩票配置模板封装对象
	 * @param lotteryTypeValueList
	 * @return
	 */
	protected Map<LotteryType, LotteryConfigTemplateObject> findAll(List<LotteryType> lotteryTypeList) {
		Map<String,String> configJSONStrMap = null;
		
		List<String> itemList = new ArrayList<String>();
		for (LotteryType lotteryType : lotteryTypeList) {
			itemList.add(lotteryType.getValue() + "");
		}
		
		try {
			configJSONStrMap = settingService.mget(SettingConstant.GROUP_LOTTERY_CONFIG, itemList);	//获取彩票配置
		} catch (ApiRemoteCallFailedException e) {
			logger.error("调用API获取彩票配置异常！", e);
		}
		if (configJSONStrMap == null) {
			logger.error("未读取到彩票配置！");
			return null;
		}
		
		Map<LotteryType, LotteryConfigTemplateObject> lotteryConfigTemplateObjectMap = new HashMap<LotteryType, LotteryConfigTemplateObject>();
		for (Iterator<String> iter = configJSONStrMap.keySet().iterator();iter.hasNext();) {	//循环遍历每一彩票配置
			String lotteryTypeValue = iter.next();		//彩票类型值
			LotteryConfigTemplateObject lotteryConfigTemplateObject = null;
			try {
				if (lotteryTypeValue.equals(String.valueOf(LotteryType.ALL.getValue()))) {	//-1对应的没有彩票配置
					logger.error("{}没有彩票配置！",lotteryTypeValue);
				} else {
					JSONObject jsonObject = null;
					try {
						jsonObject = JSONObject.fromObject(configJSONStrMap.get(lotteryTypeValue));
					} catch (Exception e) {
						logger.error("解析彩票配置失败", e);
						logger.error("lottery_type={}, value={}", lotteryTypeValue, configJSONStrMap.get(lotteryTypeValue));
					}
					if (jsonObject == null || jsonObject.isNullObject()) {
						logger.error("{}没有彩票配置！",lotteryTypeValue);
						continue;
					}
					lotteryConfigTemplateObject = LotteryConfigTemplateObject.convertFromJSONObject(jsonObject);
				}
			} catch (Exception e) {
				logger.error("解析彩票配置异常！", e);
				return null;
			}
			lotteryConfigTemplateObjectMap.put(LotteryType.getItem(Integer.parseInt(lotteryTypeValue)), lotteryConfigTemplateObject);
		}
		
		return lotteryConfigTemplateObjectMap;
	}
	
	/**
	 * 根据彩票类型构建对应的彩票配置
	 * @param lotteryType
	 * @return
	 */
	public LotteryConfig build(LotteryType lotteryType) {
		List<LotteryType> lotteryTypeList = new ArrayList<LotteryType>();
		lotteryTypeList.add(lotteryType);
		
		Map<LotteryType, LotteryConfig> lotteryConfigMap = this.build(lotteryTypeList);
		if (lotteryConfigMap == null || lotteryConfigMap.isEmpty()) {
			return null;
		}
		
		return lotteryConfigMap.get(lotteryType);
	}

	
	/**
	 * 构建彩票类型对应的彩票配置
	 * @param lotteryTypeValueList
	 * @return
	 */
	public Map<LotteryType, LotteryConfig> build(List<LotteryType> lotteryTypeList) {
		if (lotteryTypeList == null || lotteryTypeList.size() == 0) {
			logger.error("彩票类型列表不存在！");
			return null;
		}
		
		Map<LotteryType, LotteryConfigTemplateObject> lctoMap = findAll(lotteryTypeList);//取得全部彩票类型对应的彩票配置模板封装对象
		if (lctoMap == null) {
			return null;
		}
		Map<LotteryType, LotteryConfig> lotteryConfigMap = new HashMap<LotteryType, LotteryConfig>();
		
		for (Iterator<LotteryType> iter = lctoMap.keySet().iterator();iter.hasNext();) {
			LotteryType lotteryType = iter.next();
			LotteryConfigTemplateObject lcto = lctoMap.get(lotteryType);
			LotteryConfig lotteryConfig = null;
			if (lcto != null) {
				if (lcto.getResultDetailItemList() != null) {
					Map<String, ResultDetailTemplateItem> resultDetailitemMap = new HashMap<String, ResultDetailTemplateItem>();//map key:ResultDetailTemplateItem对象的key值
					for (ResultDetailTemplateItem resultDetailTemplateItem : lcto.getResultDetailItemList()) {
						resultDetailitemMap.put(resultDetailTemplateItem.getKey(), resultDetailTemplateItem);
					}
					lotteryConfig = new LotteryConfig(lcto.getResultItemList(),lcto.getResultDetailItemList(),resultDetailitemMap,lotteryType);
					lotteryConfigMap.put(lotteryType, lotteryConfig);
				}
			}
		}
		
		return lotteryConfigMap;
	}
	
	public SettingService getSettingService() {
		return settingService;
	}

	public void setSettingService(SettingService settingService) {
		this.settingService = settingService;
	}
}
