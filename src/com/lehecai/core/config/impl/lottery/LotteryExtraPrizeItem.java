/**
 * 
 */
package com.lehecai.core.config.impl.lottery;

import java.util.Date;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.config.impl.AbstractDefaultSupportedConfigItem;
import com.lehecai.core.util.CoreDateUtils;

/**
 * 加奖配置实体类
 * @author qatang
 *
 */
public class LotteryExtraPrizeItem extends AbstractDefaultSupportedConfigItem {
	private static final long serialVersionUID = 3641355684918618342L;

	protected static final Logger logger = LoggerFactory.getLogger(LotteryExtraPrizeItem.class);
	
	public static final String KEY_EXTRA_PRIZE = "extra_prize";
	public static final String KEY_BEGIN_DATE = "begin_date";
	public static final String KEY_END_DATE = "end_date";
	public static final String KEY_LIMITED_PHASE = "limited_phase";
	public static final String KEY_BEGIN_PHASE = "begin_phase";
	public static final String KEY_END_PHASE = "end_phase";
	
	private boolean extraPrize;//是否加奖
	private Date beginDate;//加奖开始时间
	private Date endDate;//加奖结束时间
	private boolean limitedPhase;;//是否限定期次
	private String beginPhase;//开始期次
	private String endPhase;//结束期次
	
	public JSONObject toJSONObject() {
		JSONObject object = new JSONObject();
		//转换默认配置
		object.put(LotteryExtraPrizeItem.KEY_EXTRA_PRIZE, this.isExtraPrize());
		object.put(LotteryExtraPrizeItem.KEY_BEGIN_DATE, this.getBeginDate() == null ? null : CoreDateUtils.formatDateTime(this.getBeginDate()));
		object.put(LotteryExtraPrizeItem.KEY_END_DATE, this.getEndDate() == null ? null : CoreDateUtils.formatDateTime(this.getEndDate()));
		object.put(LotteryExtraPrizeItem.KEY_LIMITED_PHASE, this.isLimitedPhase());
		object.put(LotteryExtraPrizeItem.KEY_BEGIN_PHASE, StringUtils.isEmpty(this.getBeginPhase()) ?  null : this.getBeginPhase());
		object.put(LotteryExtraPrizeItem.KEY_END_PHASE, StringUtils.isEmpty(this.getEndPhase()) ? null : this.getEndPhase());
		
		return object;
	}

	public static LotteryExtraPrizeItem convertFromJSONObject(JSONObject obj) {
		if (obj == null || obj.isNullObject()) {
			return null;
		}
		LotteryExtraPrizeItem extraPrizeConfigItem = new LotteryExtraPrizeItem();
		if (obj.containsKey(LotteryExtraPrizeItem.KEY_EXTRA_PRIZE)) {
			boolean extraPrize = false;
			try {
				extraPrize = obj.getBoolean(LotteryExtraPrizeItem.KEY_EXTRA_PRIZE);
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			extraPrizeConfigItem.setExtraPrize(extraPrize);
		}
		if (obj.containsKey(LotteryExtraPrizeItem.KEY_BEGIN_DATE)) {
			Date beginDate = null;
			try {
				beginDate = CoreDateUtils.parseLongDate(obj.getString(LotteryExtraPrizeItem.KEY_BEGIN_DATE));
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			extraPrizeConfigItem.setBeginDate(beginDate);
		}
		if (obj.containsKey(LotteryExtraPrizeItem.KEY_END_DATE)) {
			Date endDate = null;
			try {
				endDate = CoreDateUtils.parseLongDate(obj.getString(LotteryExtraPrizeItem.KEY_END_DATE));
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			extraPrizeConfigItem.setEndDate(endDate);
		}
		if (obj.containsKey(LotteryExtraPrizeItem.KEY_LIMITED_PHASE)) {
			boolean limitedPhase = false;
			try {
				limitedPhase = obj.getBoolean(LotteryExtraPrizeItem.KEY_LIMITED_PHASE);
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			extraPrizeConfigItem.setLimitedPhase(limitedPhase);
		}
		if (obj.containsKey(LotteryExtraPrizeItem.KEY_BEGIN_PHASE)) {
			String beginPhase = null;
			try {
				beginPhase = obj.getString(LotteryExtraPrizeItem.KEY_BEGIN_PHASE);
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			extraPrizeConfigItem.setBeginPhase(beginPhase);
		}
		if (obj.containsKey(LotteryExtraPrizeItem.KEY_END_PHASE)) {
			String endPhase = null;
			try {
				endPhase = obj.getString(LotteryExtraPrizeItem.KEY_END_PHASE);
			} catch (Exception e) {
				logger.error("json数据转换错误,obj={}", obj, e);
			}
			extraPrizeConfigItem.setEndPhase(endPhase);
		}
		
		return extraPrizeConfigItem;
	}

	public boolean isExtraPrize() {
		return extraPrize;
	}

	public void setExtraPrize(boolean extraPrize) {
		this.extraPrize = extraPrize;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isLimitedPhase() {
		return limitedPhase;
	}

	public void setLimitedPhase(boolean limitedPhase) {
		this.limitedPhase = limitedPhase;
	}

	public String getBeginPhase() {
		return beginPhase;
	}

	public void setBeginPhase(String beginPhase) {
		this.beginPhase = beginPhase;
	}

	public String getEndPhase() {
		return endPhase;
	}

	public void setEndPhase(String endPhase) {
		this.endPhase = endPhase;
	}
	
}
