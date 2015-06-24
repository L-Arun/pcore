package com.lehecai.core.config.impl.lotterychase;

import com.lehecai.core.api.setting.SettingConstant;
import com.lehecai.core.config.impl.AbstractLotteryTypeDefaultSupportedConfig;
/**
 * 追号中奖后终止自动发短信配置
 * @author qatang
 *
 */
public class ChaseStoppedSMSConfig extends AbstractLotteryTypeDefaultSupportedConfig<ChaseStoppedSMSConfigItem> {

	private static final long serialVersionUID = -8301236715379602435L;

	private boolean allowSms;//是否允许发送
	
	private String smsTemplatePath;//全局配置短信模板路径
	private String smsTemplatePrefix;//全局配置短信模板前缀
	private String smsTemplateName;//全局配置短信模板默认名称
	private String smsTemplateExt;//全局配置短信模板扩展名
	
	@Override
	public String getGroup() {
		return SettingConstant.GROUP_CHASE_STOPPED_SMS_CONFIG;
	}
	
	public String getSmsTemplatePath() {
		return smsTemplatePath;
	}

	public void setSmsTemplatePath(String smsTemplatePath) {
		this.smsTemplatePath = smsTemplatePath;
	}

	public String getSmsTemplatePrefix() {
		return smsTemplatePrefix;
	}

	public void setSmsTemplatePrefix(String smsTemplatePrefix) {
		this.smsTemplatePrefix = smsTemplatePrefix;
	}

	public String getSmsTemplateExt() {
		return smsTemplateExt;
	}

	public void setSmsTemplateExt(String smsTemplateExt) {
		this.smsTemplateExt = smsTemplateExt;
	}

	public String getSmsTemplateName() {
		return smsTemplateName;
	}

	public void setSmsTemplateName(String smsTemplateName) {
		this.smsTemplateName = smsTemplateName;
	}

	public boolean isAllowSms() {
		return allowSms;
	}

	public void setAllowSms(boolean allowSms) {
		this.allowSms = allowSms;
	}
}
