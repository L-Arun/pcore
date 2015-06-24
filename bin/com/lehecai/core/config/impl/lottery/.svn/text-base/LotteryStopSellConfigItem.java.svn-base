/**
 * 
 */
package com.lehecai.core.config.impl.lottery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.YesNoStatus;
import com.lehecai.core.config.impl.AbstractDefaultSupportedConfigItem;
import com.lehecai.core.lottery.PlanType;
import com.lehecai.core.lottery.PlatformType;

/**
 * 全局彩种是否停售实体类
 * @author yanweijie
 *
 */
public class LotteryStopSellConfigItem extends AbstractDefaultSupportedConfigItem {
	private static final long serialVersionUID = -1421415590447385730L;

	protected static final Logger logger = LoggerFactory.getLogger(LotteryStopSellConfigItem.class);
	
	public static final String KEY_ALLOW_STOP_SELL = "allow_stop_sell";
	public static final String KEY_STOP_SELL_REASON = "stop_sell_reason";
	public static final String KEY_USE_DEFAULT = "use_default";
	public static final String KEY_PLATFORM_TYPES = "platform_types";
	public static final String KEY_ALL_PLATFORM = "all_platform";
	public static final String KEY_USE_PLAN_TYPE = "use_plan_type";
	public static final String KEY_PLAN_TYPES = "plan_types";
	public static final String KEY_USE_PLAN_TYPE_MAP = "use_plan_type_map";
	public static final String KEY_PLAN_TYPES_MAP = "plan_types_map";
	public static final String KEY_USE_CREDIT_LEVEL = "use_credit_level";
	public static final String KEY_MIN_CREDIT_LEVEL = "min_credit_level";
	
	private boolean allowStopSell;//是否停售
	private String stopSellReason;//停售原因
	private YesNoStatus allPlatform;//是否停售全部平台
	private List<PlatformType> platformTypes;//停售平台
	private Map<PlatformType,YesNoStatus> usePlanTypeMap;//是否判断方案类型-绑定平台类型
	private Map<PlatformType,List<PlanType>> planTypesMap;//停售方案类型-绑定平台类型
	private Map<PlatformType,Map<PlanType,YesNoStatus>> creditLevelMap;//是否按彩贝等级停售-绑定平台类型和停售方案类型
	private Map<PlatformType,Map<PlanType,Integer>> minLevelMap;//最低彩贝等级，只有creditLevel为1是有效-绑定平台类型和停售方案类型
	private YesNoStatus usePlanType;//是否判断方案类型
	private List<PlanType> planTypes;//停售方案类型
	
	public JSONObject toJSONObject() {
		JSONObject object = new JSONObject();
		//转换默认配置
		object.put(LotteryStopSellConfigItem.KEY_ALLOW_STOP_SELL, this.isAllowStopSell());
		object.put(LotteryStopSellConfigItem.KEY_STOP_SELL_REASON, this.getStopSellReason());
		object.put(LotteryStopSellConfigItem.KEY_USE_DEFAULT, this.isUseDefault());
		object.put(LotteryStopSellConfigItem.KEY_ALL_PLATFORM, this.getAllPlatform() == null ? YesNoStatus.YES.getValue() : this.getAllPlatform().getValue());
		if (this.getPlatformTypes() != null && this.getPlatformTypes().size() > 0) {
			JSONArray jsonArray = new JSONArray();
			for (PlatformType platformType : this.getPlatformTypes()) {
				jsonArray.add(platformType.getValue());
			}
			object.put(LotteryStopSellConfigItem.KEY_PLATFORM_TYPES, jsonArray);
		}
		if (this.getUsePlanTypeMap() != null) {
			JSONObject obj = new JSONObject();
			for (PlatformType platformType : this.getUsePlanTypeMap().keySet()) {
				YesNoStatus yesNoStatus = this.getUsePlanTypeMap().get(platformType);
				obj.put(platformType.getValue(), yesNoStatus.getValue());
			}
			object.put(LotteryStopSellConfigItem.KEY_USE_PLAN_TYPE_MAP, obj);
		}
		if (this.getPlanTypesMap() != null) {
			JSONObject obj = new JSONObject();
			for (PlatformType platformType : this.getPlanTypesMap().keySet()) {
				List<PlanType> planTypeList = this.getPlanTypesMap().get(platformType);
				JSONObject objPlanType = new JSONObject();
				for (PlanType planType : planTypeList) {
					JSONObject objCredit = new JSONObject();
					if (this.getCreditLevelMap() != null) {
						if (this.getCreditLevelMap().get(platformType) != null) {
							YesNoStatus ifCreditLevel = this.getCreditLevelMap().get(platformType).get(planType);
							if (ifCreditLevel!= null) {
								objCredit.put(KEY_USE_CREDIT_LEVEL, ifCreditLevel.getValue());
							}
						}
					}
					if (this.getMinLevelMap() != null) {
						if (this.getMinLevelMap().get(platformType) != null) {
							Integer minLevel = this.getMinLevelMap().get(platformType).get(planType);
							if (minLevel != null) {
								objCredit.put(KEY_MIN_CREDIT_LEVEL, minLevel);
							}
						}
					}
					objPlanType.put(planType.getValue(),objCredit);
				}
				
				obj.put(platformType.getValue(), objPlanType);
			}
			object.put(LotteryStopSellConfigItem.KEY_PLAN_TYPES_MAP, obj);
		}
		return object;
	}
	
	public static LotteryStopSellConfigItem convertFromJSONObject(JSONObject obj) {
		if (obj == null || obj.isNullObject()) {
			return null;
		}
		LotteryStopSellConfigItem lotteryStopSell = new LotteryStopSellConfigItem();
		if (obj.containsKey(KEY_ALLOW_STOP_SELL)) {
			boolean allowStopSell = false;
			try {
				allowStopSell = obj.getBoolean(KEY_ALLOW_STOP_SELL);
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			lotteryStopSell.setAllowStopSell(allowStopSell);
		}
		if (obj.containsKey(LotteryStopSellConfigItem.KEY_STOP_SELL_REASON)) {
			String stopSellReason = null;
			try {
				stopSellReason = obj.getString(LotteryStopSellConfigItem.KEY_STOP_SELL_REASON);
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			lotteryStopSell.setStopSellReason(stopSellReason);
		}
		if (obj.containsKey(LotteryStopSellConfigItem.KEY_USE_DEFAULT)) {
			boolean useDefault = false;
			try {
				useDefault = obj.getBoolean(LotteryStopSellConfigItem.KEY_USE_DEFAULT);
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			lotteryStopSell.setUseDefault(useDefault);
		}
		if (obj.containsKey(LotteryStopSellConfigItem.KEY_ALL_PLATFORM)) {
			YesNoStatus allPlatform = null;
			try {
				allPlatform = YesNoStatus.getItem(obj.getInt(LotteryStopSellConfigItem.KEY_ALL_PLATFORM));
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			lotteryStopSell.setAllPlatform(allPlatform == null ? YesNoStatus.YES : allPlatform);
		}
		if (obj.containsKey(LotteryStopSellConfigItem.KEY_PLATFORM_TYPES)) {
			List<PlatformType> list = new ArrayList<PlatformType>();
			
			JSONArray array = null;
			try {
				array = JSONArray.fromObject(obj.get(LotteryStopSellConfigItem.KEY_PLATFORM_TYPES));
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			if (array != null && array.size() > 0) {
				for (Iterator<?> iterator = array.iterator(); iterator.hasNext();) {
					Integer value = (Integer) iterator.next();
					PlatformType platformType = PlatformType.getItem(value);
					if (platformType != null) {
						list.add(platformType);
					}
				}
			}
			lotteryStopSell.setPlatformTypes(list);
		}
		if (obj.containsKey(LotteryStopSellConfigItem.KEY_USE_PLAN_TYPE_MAP)) {
			Map<PlatformType,YesNoStatus> map = new HashMap<PlatformType,YesNoStatus>();
			JSONObject usePlanTypeObj = null;
			try{
				usePlanTypeObj = JSONObject.fromObject(obj.get(LotteryStopSellConfigItem.KEY_USE_PLAN_TYPE_MAP));
			}catch(Exception e){
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			if (usePlanTypeObj != null) {
				for (Iterator<?> it = usePlanTypeObj.keys(); it.hasNext();) {
					String key = (String)it.next();
					map.put(PlatformType.getItem(Integer.valueOf(key)), YesNoStatus.getItem(usePlanTypeObj.getInt(key)));
					
				}
			}
			lotteryStopSell.setUsePlanTypeMap(map);
		}
		if (obj.containsKey(LotteryStopSellConfigItem.KEY_PLAN_TYPES_MAP)) {
			Map<PlatformType,List<PlanType>> map = new HashMap<PlatformType,List<PlanType>>();
			Map<PlatformType,Map<PlanType,YesNoStatus>> creditLevelMap = new HashMap<PlatformType,Map<PlanType,YesNoStatus>>();
			Map<PlatformType,Map<PlanType,Integer>> minLevelMap = new HashMap<PlatformType,Map<PlanType,Integer>>();
			JSONObject planTypesObj = null;
			try{
				planTypesObj = JSONObject.fromObject(obj.get(LotteryStopSellConfigItem.KEY_PLAN_TYPES_MAP));
			}catch(Exception e){
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			if (planTypesObj != null) {
				for (Iterator<?> it = planTypesObj.keys(); it.hasNext();){
					String key = (String)it.next();
					try {
						JSONObject jsonObjectPlanType = null;
						if (JSONUtils.isObject(planTypesObj.get(key))) {
							jsonObjectPlanType = planTypesObj.getJSONObject(key);
						} else {
							jsonObjectPlanType = new JSONObject();
						}
						List<PlanType> listPlanType = new ArrayList<PlanType>();
						Map<PlanType,YesNoStatus> _creditLevelMap = new HashMap<PlanType,YesNoStatus>();
						Map<PlanType,Integer> _minLevelMap = new HashMap<PlanType,Integer>();
						for (Iterator<?> itPlanType = jsonObjectPlanType.keys(); itPlanType.hasNext();) {
							String keyPlanType = (String)itPlanType.next();
							Integer planType = null;
							try {
								planType = Integer.valueOf(keyPlanType);
							} catch(Exception e){
								planType = null;
							}
							if (planType != null) {
								PlanType pt = PlanType.getItem(planType);
								listPlanType.add(pt);
								JSONObject _creditJSONObject = jsonObjectPlanType.getJSONObject(keyPlanType);
								Integer userCreditLevel = (Integer)_creditJSONObject.get(KEY_USE_CREDIT_LEVEL);
			                	if (userCreditLevel != null) {
				                	_creditLevelMap.put(pt, YesNoStatus.getItem(userCreditLevel.intValue()));
			                	}
								Integer minCreditLevel = (Integer)_creditJSONObject.get(KEY_MIN_CREDIT_LEVEL);
			                	if (minCreditLevel != null) {
				                	_minLevelMap.put(pt, minCreditLevel);
			                	}
							}
						}
						map.put(PlatformType.getItem(Integer.valueOf(key)), listPlanType);
						creditLevelMap.put(PlatformType.getItem(Integer.valueOf(key)), _creditLevelMap);
						minLevelMap.put(PlatformType.getItem(Integer.valueOf(key)), _minLevelMap);
					} catch(Exception e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
			lotteryStopSell.setPlanTypesMap(map);
			lotteryStopSell.setCreditLevelMap(creditLevelMap);
			lotteryStopSell.setMinLevelMap(minLevelMap);
		}
		return lotteryStopSell;
	}
	
	public boolean isAllowStopSell() {
		return allowStopSell;
	}
	public void setAllowStopSell(boolean allowStopSell) {
		this.allowStopSell = allowStopSell;
	}
	public String getStopSellReason() {
		return stopSellReason;
	}
	public void setStopSellReason(String stopSellReason) {
		this.stopSellReason = stopSellReason;
	}

	public List<PlatformType> getPlatformTypes() {
		return platformTypes;
	}

	public void setPlatformTypes(List<PlatformType> platformTypes) {
		this.platformTypes = platformTypes;
	}

	public YesNoStatus getAllPlatform() {
		return allPlatform;
	}

	public void setAllPlatform(YesNoStatus allPlatform) {
		this.allPlatform = allPlatform;
	}

	public YesNoStatus getUsePlanType() {
		return usePlanType;
	}

	public void setUsePlanType(YesNoStatus usePlanType) {
		this.usePlanType = usePlanType;
	}

	public List<PlanType> getPlanTypes() {
		return planTypes;
	}

	public void setPlanTypes(List<PlanType> planTypes) {
		this.planTypes = planTypes;
	}

	public Map<PlatformType, YesNoStatus> getUsePlanTypeMap() {
		return usePlanTypeMap;
	}

	public void setUsePlanTypeMap(Map<PlatformType, YesNoStatus> usePlanTypeMap) {
		this.usePlanTypeMap = usePlanTypeMap;
	}

	public Map<PlatformType, List<PlanType>> getPlanTypesMap() {
		return planTypesMap;
	}

	public void setPlanTypesMap(Map<PlatformType, List<PlanType>> planTypesMap) {
		this.planTypesMap = planTypesMap;
	}

	public Map<PlatformType, Map<PlanType, YesNoStatus>> getCreditLevelMap() {
		return creditLevelMap;
	}

	public void setCreditLevelMap(
			Map<PlatformType, Map<PlanType, YesNoStatus>> creditLevelMap) {
		this.creditLevelMap = creditLevelMap;
	}

	public Map<PlatformType, Map<PlanType, Integer>> getMinLevelMap() {
		return minLevelMap;
	}

	public void setMinLevelMap(Map<PlatformType, Map<PlanType, Integer>> minLevelMap) {
		this.minLevelMap = minLevelMap;
	}
}
