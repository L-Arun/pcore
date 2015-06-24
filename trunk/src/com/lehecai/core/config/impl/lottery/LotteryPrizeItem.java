/**
 * 
 */
package com.lehecai.core.config.impl.lottery;

import java.io.Serializable;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.EnabledStatus;
import com.lehecai.core.YesNoStatus;

/**
 * 彩种奖级种类配置实体类
 * @author qatang
 *
 */
public class LotteryPrizeItem implements Serializable {
	protected static final Logger logger = LoggerFactory.getLogger(LotteryPrizeItem.class);
	private static final long serialVersionUID = 6683114474487844041L;
	
	public static final String KEY_KEY = "key";
	public static final String KEY_NAME = "name";
	public static final String KEY_DEFAULT_PRIZE = "default_prize";
	public static final String KEY_USABLE = "usable";
	public static final String KEY_STATIC_PRIZE = "static_prize";
	public static final String KEY_NOTIFY = "notify";
	
	private String key;
	private String name;
	private String defaultPrize;
	private EnabledStatus usable;
	private YesNoStatus staticPrize;//是否为固定奖金
	private YesNoStatus notify;//是否需要作为大奖通知
	
	public static JSONObject toJSONObject(LotteryPrizeItem lotteryPrizeItem) {
		JSONObject object = new JSONObject();
		if (lotteryPrizeItem != null) {
			//转换默认配置
			object.put(LotteryPrizeItem.KEY_KEY, lotteryPrizeItem.getKey());
			object.put(LotteryPrizeItem.KEY_NAME, lotteryPrizeItem.getName());
			object.put(LotteryPrizeItem.KEY_DEFAULT_PRIZE, lotteryPrizeItem.getDefaultPrize());
			object.put(LotteryPrizeItem.KEY_USABLE, lotteryPrizeItem.getUsable() == null ? EnabledStatus.ENABLED.getValue() : lotteryPrizeItem.getUsable().getValue());
			object.put(LotteryPrizeItem.KEY_STATIC_PRIZE, lotteryPrizeItem.getStaticPrize() == null ? EnabledStatus.DISABLED.getValue() : lotteryPrizeItem.getStaticPrize().getValue());
			object.put(LotteryPrizeItem.KEY_NOTIFY, lotteryPrizeItem.getNotify() == null ? EnabledStatus.DISABLED.getValue() : lotteryPrizeItem.getNotify().getValue());
		}
		return object;
	}
	
	public static LotteryPrizeItem convertFromJSONObject(JSONObject obj) {
		if (obj == null || obj.isNullObject()) {
			return null;
		}
		LotteryPrizeItem lotteryPrizeItem = new LotteryPrizeItem();
		if (obj.containsKey(LotteryPrizeItem.KEY_KEY)) {
			String key = null;
			try {
				key = obj.getString(LotteryPrizeItem.KEY_KEY);
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			lotteryPrizeItem.setKey(key);
		}
		if (obj.containsKey(LotteryPrizeItem.KEY_NAME)) {
			String name = null;
			try {
				name = obj.getString(LotteryPrizeItem.KEY_NAME);
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			lotteryPrizeItem.setName(name);
		}
		if (obj.containsKey(LotteryPrizeItem.KEY_DEFAULT_PRIZE)) {
			String defaultPrize = null;
			try {
				defaultPrize = obj.getString(LotteryPrizeItem.KEY_DEFAULT_PRIZE);
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			lotteryPrizeItem.setDefaultPrize(defaultPrize);
		}
		if (obj.containsKey(LotteryPrizeItem.KEY_USABLE)) {
			EnabledStatus usable = EnabledStatus.DISABLED;
			try {
				usable = EnabledStatus.getItem(obj.getInt(LotteryPrizeItem.KEY_USABLE));
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			lotteryPrizeItem.setUsable(usable);
		}
		if (obj.containsKey(LotteryPrizeItem.KEY_STATIC_PRIZE)) {
			YesNoStatus staticPrize = YesNoStatus.NO;
			try {
				staticPrize = YesNoStatus.getItem(obj.getInt(LotteryPrizeItem.KEY_STATIC_PRIZE));
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			lotteryPrizeItem.setStaticPrize(staticPrize);
		}
		if (obj.containsKey(LotteryPrizeItem.KEY_NOTIFY)) {
			YesNoStatus notify = YesNoStatus.NO;
			try {
				notify = YesNoStatus.getItem(obj.getInt(LotteryPrizeItem.KEY_NOTIFY));
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			lotteryPrizeItem.setNotify(notify);
		}
		
		return lotteryPrizeItem;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDefaultPrize() {
		return defaultPrize;
	}
	public void setDefaultPrize(String defaultPrize) {
		this.defaultPrize = defaultPrize;
	}

	public EnabledStatus getUsable() {
		return usable;
	}

	public void setUsable(EnabledStatus usable) {
		this.usable = usable;
	}
	
	public int getUsableValue() {
		if (usable != null) {
			return usable.getValue();
		}
		return EnabledStatus.DISABLED.getValue();
	}

	public void setUsableValue(int usableValue) {
		usable = EnabledStatus.getItem(usableValue);
		if (usable == null) {
			usable = EnabledStatus.DISABLED;
		}
	}

	public YesNoStatus getStaticPrize() {
		return staticPrize;
	}

	public void setStaticPrize(YesNoStatus staticPrize) {
		this.staticPrize = staticPrize;
	}
	
	public int getStaticPrizeValue() {
		if (staticPrize != null) {
			return staticPrize.getValue();
		}
		return YesNoStatus.NO.getValue();
	}

	public void setStaticPrizeValue(int staticPrizeValue) {
		staticPrize = YesNoStatus.getItem(staticPrizeValue);
		if (staticPrize == null) {
			staticPrize = YesNoStatus.NO;
		}
	}

	public YesNoStatus getNotify() {
		return notify;
	}

	public void setNotify(YesNoStatus notify) {
		this.notify = notify;
	}
	
	public int getNotifyValue() {
		if (notify != null) {
			return notify.getValue();
		}
		return YesNoStatus.NO.getValue();
	}

	public void setNotifyValue(int notifyValue) {
		notify = YesNoStatus.getItem(notifyValue);
		if (notify == null) {
			notify = YesNoStatus.NO;
		}
	}
}
