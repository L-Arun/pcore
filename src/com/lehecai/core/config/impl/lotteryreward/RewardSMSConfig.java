package com.lehecai.core.config.impl.lotteryreward;

import com.lehecai.core.api.setting.SettingConstant;
import com.lehecai.core.config.impl.AbstractLotteryTypeDefaultSupportedConfig;
/**
 * 中奖自动发短信配置
 * @author qatang
 *
 */
public class RewardSMSConfig extends AbstractLotteryTypeDefaultSupportedConfig<RewardSMSConfigItem> {

	private static final long serialVersionUID = -7304516579348643716L;
	
	private boolean allowSms;//是否允许发送
	
	private String smsTemplatePath;//全局配置短信模板路径
	private String smsTemplatePrefix;//全局配置短信模板前缀
	private String smsTemplateName;//全局配置短信模板默认名称
	private String smsTemplateExt;//全局配置短信模板扩展名
	
	@Override
	public String getGroup() {
		return SettingConstant.GROUP_REWARD_SMS_CONFIG;
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
