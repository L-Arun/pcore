/**
 * 
 */
package com.lehecai.core.config.impl.lotterychase;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.lehecai.core.config.IConfig;
import com.lehecai.core.config.IConfigItem;
import com.lehecai.core.config.impl.AbstractLotteryTypeSupportedConfigParser;
import com.lehecai.core.lottery.LotteryType;

/**
 * 追号中奖后终止自动发短信配置解析器
 * @author qatang
 *
 */
public class AbstractChaseStoppedSMSConfigParser<T extends ChaseStoppedSMSConfig> extends AbstractLotteryTypeSupportedConfigParser {
	
	public static final String KEY_GLOBAL_CONFIG_ALLOWSMS = "allow_sms";
	public static final String KEY_GLOBAL_CONFIG_SMSTEMPLATEPATH = "sms_template_path";
	public static final String KEY_GLOBAL_CONFIG_SMSTEMPLATEPREFIX = "sms_template_prefix";
	public static final String KEY_GLOBAL_CONFIG_SMSTEMPLATENAME = "sms_template_name";
	public static final String KEY_GLOBAL_CONFIG_SMSTEMPLATEEXT = "sms_template_ext";

	@SuppressWarnings("unchecked")
	protected Class<T> getArchiveActualType() {
		ParameterizedType paramType = (ParameterizedType)this.getClass().getGenericSuperclass();
		
		Class<T> clazz = (Class<T>)paramType.getActualTypeArguments()[0];
		
		return clazz;
	}
	
	@Override
	public boolean hasDefaultItem() {
		return true;
	}

	@Override
	public boolean hasGlobalItem() {
		return true;
	}

	@Override
	public String getConfig(IConfig iconfig) {
		T chaseStoppedSMSConfig = this.getArchiveActualType().cast(iconfig);
		if (chaseStoppedSMSConfig == null) {
			logger.info("未找到配置信息：中奖自动发短信配置");
			return null;
		}
		boolean allowSms = chaseStoppedSMSConfig.isAllowSms();
		String smsTemplatePath = chaseStoppedSMSConfig.getSmsTemplatePath();
		String smsTemplatePrefix = chaseStoppedSMSConfig.getSmsTemplatePrefix();
		String smsTemplateName = chaseStoppedSMSConfig.getSmsTemplateName();
		String smsTemplateExt = chaseStoppedSMSConfig.getSmsTemplateExt();
		
		ChaseStoppedSMSConfigItem chaseStoppedSMS = chaseStoppedSMSConfig.getDefaultConfigItem();
		
		Map<LotteryType, ChaseStoppedSMSConfigItem> chaseStoppedSMSMap = chaseStoppedSMSConfig.getLotteryTypeConfigItem();
		
		
		if ((smsTemplatePath == null || smsTemplatePath.equals("")
				|| smsTemplatePrefix == null || smsTemplatePrefix.equals("")
				|| smsTemplateName == null || smsTemplateName.equals("")
				|| smsTemplateExt == null || smsTemplateExt.equals("")) && chaseStoppedSMS == null && chaseStoppedSMSMap == null ) {
			logger.info("未找到配置信息：中奖自动发短信配置");
			return null;
		}
		
		JSONObject jsonObject = new JSONObject();
		
		if ((smsTemplatePath != null && !smsTemplatePath.equals(""))
				&& (smsTemplatePrefix != null && !smsTemplatePrefix.equals(""))
				&& (smsTemplateName != null && !smsTemplateName.equals(""))
				&& (smsTemplateExt != null && !smsTemplateExt.equals(""))) {
			JSONObject globalObject = new JSONObject();
			globalObject.put(KEY_GLOBAL_CONFIG_ALLOWSMS, allowSms);
			globalObject.put(KEY_GLOBAL_CONFIG_SMSTEMPLATEPATH, smsTemplatePath);
			globalObject.put(KEY_GLOBAL_CONFIG_SMSTEMPLATEPREFIX, smsTemplatePrefix);
			globalObject.put(KEY_GLOBAL_CONFIG_SMSTEMPLATENAME, smsTemplateName);
			globalObject.put(KEY_GLOBAL_CONFIG_SMSTEMPLATEEXT, smsTemplateExt);
			jsonObject.put(this.getGlobalItemKey(), globalObject);
		}
		
		if (chaseStoppedSMS != null) {
			//转换默认配置
			logger.info("中奖自动发短信配置:转换默认配置");
			JSONObject defaultObject = chaseStoppedSMS.toJSONObject();
			jsonObject.put(this.getDefaultItemKey(), defaultObject);
		}
		
		if (chaseStoppedSMSMap != null) {
			//转换自定义配置
			logger.info("中奖自动发短信配置:转换自定义配置");
			
			for (LotteryType lotteryType : chaseStoppedSMSMap.keySet()) {
				ChaseStoppedSMSConfigItem _chaseStoppedSMS = chaseStoppedSMSMap.get(lotteryType);
				
				JSONObject obj = _chaseStoppedSMS.toJSONObject();
				jsonObject.put(this.getLotteryTypeItemKey(lotteryType), obj);
			}
		}
		
		return jsonObject.toString();
	}

	@Override
	public String getConfigByItem(IConfig iconfig, String item) {
		T chaseStoppedSMSConfig = this.getArchiveActualType().cast(iconfig);
		if (chaseStoppedSMSConfig == null) {
			logger.info("未找到配置信息：中奖自动发短信配置");
			return null;
		}
		if (item == null || item.equals("")) {
			logger.info("中奖自动发短信配置:读取单条配置时，item不能为空");
			return null;
		}
		ChaseStoppedSMSConfigItem chaseStoppedSMS = chaseStoppedSMSConfig.getDefaultConfigItem();
		Map<LotteryType, ChaseStoppedSMSConfigItem> chaseStoppedSMSMap = chaseStoppedSMSConfig.getLotteryTypeConfigItem();
		
		boolean allowSms = chaseStoppedSMSConfig.isAllowSms();
		String smsTemplatePath = chaseStoppedSMSConfig.getSmsTemplatePath();
		String smsTemplatePrefix = chaseStoppedSMSConfig.getSmsTemplatePrefix();
		String smsTemplateName = chaseStoppedSMSConfig.getSmsTemplateName();
		String smsTemplateExt = chaseStoppedSMSConfig.getSmsTemplateExt();
		
		if (smsTemplatePath == null || smsTemplatePath.equals("")
				|| smsTemplatePrefix == null || smsTemplatePrefix.equals("")
				|| smsTemplateName == null || smsTemplateName.equals("")
				|| smsTemplateExt == null || smsTemplateExt.equals("")) {
			logger.info("未找到配置信息：中奖自动发短信配置smsTemplatePath,smsTemplatePrefix,smsTemplateName或smsTemplateExt为空");
			return null;
		}
		
		if (item.equals(this.getGlobalItemKey())) {
			JSONObject glabolObject = new JSONObject();
			glabolObject.put(KEY_GLOBAL_CONFIG_ALLOWSMS, allowSms);
			glabolObject.put(KEY_GLOBAL_CONFIG_SMSTEMPLATEPATH, smsTemplatePath);
			glabolObject.put(KEY_GLOBAL_CONFIG_SMSTEMPLATEPREFIX, smsTemplatePrefix);
			glabolObject.put(KEY_GLOBAL_CONFIG_SMSTEMPLATENAME, smsTemplateName);
			glabolObject.put(KEY_GLOBAL_CONFIG_SMSTEMPLATEEXT, smsTemplateExt);
			return glabolObject.toString();
		}
		
		if (item.equals(this.getDefaultItemKey())) {
			return chaseStoppedSMS.toJSONObject().toString();
		}

		LotteryType lotteryType = this.convertLotteryTypeFromKey(item);
		if (lotteryType == null) {
			return null;
		}
		if (chaseStoppedSMSMap != null) {
			ChaseStoppedSMSConfigItem _chaseStoppedSMS = chaseStoppedSMSMap.get(lotteryType);
			return _chaseStoppedSMS.toJSONObject().toString();
		}
		return null;
	}
	@Override
	public IConfig convertFromJSON(Map<String, String> jsonMap) {
		if (jsonMap == null) {
			logger.info("将json数据转换为配置对象时，参数jsonMap不能为空");
			return null;
		}
		T chaseStoppedSMSConfig = null;
		try {
			chaseStoppedSMSConfig = this.getArchiveActualType().newInstance();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		if (chaseStoppedSMSConfig == null) {
			return null;
		}
		Map<LotteryType, ChaseStoppedSMSConfigItem> chaseStoppedSMSMap = new HashMap<LotteryType, ChaseStoppedSMSConfigItem>();
		for (String key : jsonMap.keySet()) {
			String value = jsonMap.get(key);
			JSONObject obj = null;
			try {
				obj = JSONObject.fromObject(value);
			} catch (Exception e) {
				logger.error("将json数据转换为配置对象时,jsonObject转换错误,value={}", value, e);
			}
			if (obj == null || obj.isNullObject()) {
				logger.info("默认配置json串为空");
				continue;
			}
			if (key.equals(this.getGlobalItemKey())) {
				if (obj.containsKey(KEY_GLOBAL_CONFIG_ALLOWSMS)) {
					boolean allowSms = false;
					try {
						allowSms = obj.getBoolean(KEY_GLOBAL_CONFIG_ALLOWSMS);
					} catch (Exception e) {
						logger.error("json数据转换错误,obj={}", obj, e);
					}
					chaseStoppedSMSConfig.setAllowSms(allowSms);
				}
				if (obj.containsKey(KEY_GLOBAL_CONFIG_SMSTEMPLATEPATH)) {
					String smsTemplatePath = null;
					try {
						smsTemplatePath = obj.getString(KEY_GLOBAL_CONFIG_SMSTEMPLATEPATH);
					} catch (Exception e) {
						logger.error("json数据转换错误,obj={}", obj, e);
					}
					chaseStoppedSMSConfig.setSmsTemplatePath(smsTemplatePath);
				}
				if (obj.containsKey(KEY_GLOBAL_CONFIG_SMSTEMPLATEPREFIX)) {
					String smsTemplatePrefix = null;
					try {
						smsTemplatePrefix = obj.getString(KEY_GLOBAL_CONFIG_SMSTEMPLATEPREFIX);
					} catch (Exception e) {
						logger.error("json数据转换错误,obj={}", obj, e);
					}
					chaseStoppedSMSConfig.setSmsTemplatePrefix(smsTemplatePrefix);
				}
				if (obj.containsKey(KEY_GLOBAL_CONFIG_SMSTEMPLATENAME)) {
					String smsTemplateName = null;
					try {
						smsTemplateName = obj.getString(KEY_GLOBAL_CONFIG_SMSTEMPLATENAME);
					} catch (Exception e) {
						logger.error("json数据转换错误,obj={}", obj, e);
					}
					chaseStoppedSMSConfig.setSmsTemplateName(smsTemplateName);
				}
				if (obj.containsKey(KEY_GLOBAL_CONFIG_SMSTEMPLATEEXT)) {
					String smsTemplateExt = null;
					try {
						smsTemplateExt = obj.getString(KEY_GLOBAL_CONFIG_SMSTEMPLATEEXT);
					} catch (Exception e) {
						logger.error("json数据转换错误,obj={}", obj, e);
					}
					chaseStoppedSMSConfig.setSmsTemplateExt(smsTemplateExt);
				}
			} else if (key.equals(this.getDefaultItemKey())) {
				chaseStoppedSMSConfig.setDefaultConfigItem(ChaseStoppedSMSConfigItem.convertFromJSONObject(obj));
			} else {
				LotteryType lotteryType = this.convertLotteryTypeFromKey(key);
				if (lotteryType == null) {
					continue;
				}
				ChaseStoppedSMSConfigItem _chaseStoppedSMS = ChaseStoppedSMSConfigItem.convertFromJSONObject(obj);
				chaseStoppedSMSMap.put(lotteryType, _chaseStoppedSMS);
			}
		}
		chaseStoppedSMSConfig.setLotteryTypeConfigItem(chaseStoppedSMSMap);
		return chaseStoppedSMSConfig;
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
		return ChaseStoppedSMSConfigItem.convertFromJSONObject(jsonObject);
	}

	@Override
	public String formatConfigItem(IConfigItem configItem) {
		ChaseStoppedSMSConfigItem chaseStoppedSMSConfigItem = (ChaseStoppedSMSConfigItem)configItem;
		
		return chaseStoppedSMSConfigItem.toJSONObject().toString();
	}
}
