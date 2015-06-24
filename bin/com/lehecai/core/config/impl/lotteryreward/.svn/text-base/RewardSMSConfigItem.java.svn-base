/**
 * 
 */
package com.lehecai.core.config.impl.lotteryreward;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.config.impl.AbstractDefaultSupportedConfigItem;

/**
 * 中奖自动发短信配置实体类
 * @author qatang
 *
 */
public class RewardSMSConfigItem extends AbstractDefaultSupportedConfigItem {
	private static final long serialVersionUID = 3641355684918618342L;

	protected static final Logger logger = LoggerFactory.getLogger(RewardSMSConfigItem.class);
	
	public static final String KEY_ALLOW_SMS = "allow_sms";
	public static final String KEY_PRIZE_NEED_SMS = "prize";
	public static final String KEY_TIMELINES = "timeline";
	public static final String KEY_BLACK_USER_LIST = "black_user_list";
	public static final String KEY_USE_DEFAULT = "use_default";
	public static final String KEY_TEMPLATE_EXT = "template_ext";
	
	private boolean allowSms;//是否允许发送
	private Double prizeNeedSMS;//发短信奖金下限
	private List<String[]> timelines;//开始停止发短信时间
	private List<String> blackUserList;//黑名单
	private String templateExt;//模板扩展名
	
	public JSONObject toJSONObject() {
		JSONObject object = new JSONObject();
		//转换默认配置
		object.put(RewardSMSConfigItem.KEY_ALLOW_SMS, this.isAllowSms());
		object.put(RewardSMSConfigItem.KEY_PRIZE_NEED_SMS, this.getPrizeNeedSMS());
		object.put(RewardSMSConfigItem.KEY_USE_DEFAULT, this.isUseDefault());
		object.put(RewardSMSConfigItem.KEY_TEMPLATE_EXT, this.getTemplateExt());
		if (this.getTimelines() != null && this.getTimelines().size() > 0) {
			JSONArray timelineArray = new JSONArray();
			for (String[] timeline : this.getTimelines()) {
				timelineArray.add(timeline);
			}
			object.put(RewardSMSConfigItem.KEY_TIMELINES, timelineArray);
		}
		if (this.getBlackUserList() != null && this.getBlackUserList().size() > 0) {
			JSONArray userArray = new JSONArray();
			for (String user : this.getBlackUserList()) {
				userArray.add(user);
			}
			object.put(RewardSMSConfigItem.KEY_BLACK_USER_LIST, userArray);
		}
		return object;
	}

	public static RewardSMSConfigItem convertFromJSONObject(JSONObject obj) {
		if (obj == null || obj.isNullObject()) {
			return null;
		}
		RewardSMSConfigItem rewardSMS = new RewardSMSConfigItem();
		if (obj.containsKey(RewardSMSConfigItem.KEY_ALLOW_SMS)) {
			boolean allowSms = false;
			try {
				allowSms = obj.getBoolean(RewardSMSConfigItem.KEY_ALLOW_SMS);
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			rewardSMS.setAllowSms(allowSms);
		}
		if (obj.containsKey(RewardSMSConfigItem.KEY_PRIZE_NEED_SMS)) {
			Double prizeNeedSMS = null;
			try {
				prizeNeedSMS = obj.getDouble(RewardSMSConfigItem.KEY_PRIZE_NEED_SMS);
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			rewardSMS.setPrizeNeedSMS(prizeNeedSMS);
		}
		if (obj.containsKey(RewardSMSConfigItem.KEY_USE_DEFAULT)) {
			boolean useDefault = false;
			try {
				useDefault = obj.getBoolean(RewardSMSConfigItem.KEY_USE_DEFAULT);
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			rewardSMS.setUseDefault(useDefault);
		}
		if (obj.containsKey(RewardSMSConfigItem.KEY_TEMPLATE_EXT)) {
			String templateExt = null;
			try {
				templateExt = obj.getString(RewardSMSConfigItem.KEY_TEMPLATE_EXT);
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			rewardSMS.setTemplateExt(templateExt);
		}

		if (obj.containsKey(RewardSMSConfigItem.KEY_TIMELINES)) {
			List<String[]> timelines = new ArrayList<String[]>();
			
			JSONArray array = null;
			try {
				array = JSONArray.fromObject(obj.get(RewardSMSConfigItem.KEY_TIMELINES));
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			if (array != null && array.size() > 0) {
				for (Iterator<?> iterator = array.iterator(); iterator.hasNext();) {
					JSONArray tempArray = (JSONArray) iterator.next();
					String[] timeline = new String[tempArray.size()];
					for (int i = 0;i < tempArray.size();i++) {
						timeline[i] = tempArray.getString(i);
					}
					timelines.add(timeline);
				}
			}
			rewardSMS.setTimelines(timelines);
		}
		if (obj.containsKey(RewardSMSConfigItem.KEY_BLACK_USER_LIST)) {
			List<String> users = new ArrayList<String>();
			
			JSONArray array = null;
			try {
				array = JSONArray.fromObject(obj.get(RewardSMSConfigItem.KEY_BLACK_USER_LIST));
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			if (array != null && array.size() > 0) {
				for (Iterator<?> iterator = array.iterator(); iterator.hasNext();) {
					String user = (String) iterator.next();
					users.add(user);
				}
			}
			rewardSMS.setBlackUserList(users);
		}
		return rewardSMS;
	}
	public Double getPrizeNeedSMS() {
		return prizeNeedSMS;
	}
	public void setPrizeNeedSMS(Double prizeNeedSMS) {
		this.prizeNeedSMS = prizeNeedSMS;
	}
	public List<String> getBlackUserList() {
		return blackUserList;
	}
	public void setBlackUserList(List<String> blackUserList) {
		this.blackUserList = blackUserList;
	}
	public List<String[]> getTimelines() {
		return timelines;
	}
	public void setTimelines(List<String[]> timelines) {
		this.timelines = timelines;
	}
	public String getTemplateExt() {
		return templateExt;
	}
	public void setTemplateExt(String templateExt) {
		this.templateExt = templateExt;
	}
	public boolean isAllowSms() {
		return allowSms;
	}
	public void setAllowSms(boolean allowSms) {
		this.allowSms = allowSms;
	}
}
