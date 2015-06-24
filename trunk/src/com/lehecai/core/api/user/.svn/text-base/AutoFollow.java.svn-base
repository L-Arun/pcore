package com.lehecai.core.api.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.YesNoStatus;
import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.AutoFollowType;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.util.CoreDateUtils;

public class AutoFollow extends AbstractApiResultBean {
	
	public static final String QUERY_FUID = "fuid";
	public static final String QUERY_TUID = "tuid";
	
	public static final String SET_FUID = "fuid";
	public static final String SET_TUID = "tuid";
	public static final String SET_LOTTERYTYPE = "lottery_type";
	public static final String SET_AUTOFOLLOWTYPE = "type";
	public static final String SET_NUMPERPHASE = "num_perphase";
	public static final String SET_UNITAMOUNT = "unit_amount";
	public static final String SET_CANCELBELOWAMOUNT = "cancel_belowamount";
	
	public static final String ORDER_TIMELINE = "time_line";
	
	private long fuid; //跟单人ID
	private String fusername; //跟单人username
	private long tuid; //被跟单人ID
	private String tusername; //被跟单人username
	private Date timeline; //跟单设定时间
	private String statsFollowtimes;
	private LotteryType lotteryType;
	private AutoFollowType autoFollowType; //自动跟单类型
	private double statsAmount; //跟单额
	private double statsPrize;//奖金
	private YesNoStatus status;
	private String rule;
	private int followtimes; //自动跟单次数
	private int prizefollowtimes; //中奖的自动跟单次数
	private double amount;//中奖的自动跟单金额
	private double prize;//自动跟单奖金
	private int numPerphase;
	private double unitAmount;
	private double cancelBelowAmount;
	
	
	public static AutoFollow convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		AutoFollow autoFollow = new AutoFollow();

		autoFollow.fuid = getLong(object, "fuid");
		autoFollow.fusername = getString(object, "fusername");
		autoFollow.tuid = getLong(object, "tuid");
		autoFollow.tusername = getString(object, "tusername");
		autoFollow.setTimeline(getDate(object, "timeline", CoreDateUtils.DATETIME));
		autoFollow.statsFollowtimes = getString(object, "stats_followtimes");
		autoFollow.statsAmount = getString(object, "stats_amount") == null ? 0.0 : getDouble(object, "stats_amount");
		autoFollow.statsPrize = getString(object, "stats_prize") == null ? 0.0 : getDouble(object, "stats_prize");
		int statusValue = getInt(object, "status");
		autoFollow.status = YesNoStatus.getItem(statusValue);
		autoFollow.followtimes = getString(object, "followtimes") == null ? 0 : getInt(object, "followtimes");
		autoFollow.prizefollowtimes = getString(object, "prizefollowtimes") == null ? 0 : getInt(object, "prizefollowtimes");
		autoFollow.amount = getString(object, "amount") == null ? 0.0 : getDouble(object, "amount");
		autoFollow.prize = getString(object, "prize") == null ? 0.0 : getDouble(object, "prize");
		autoFollow.rule = getString(object, "rule");
		autoFollow.numPerphase = getString(object, "num_perphase") == null || getString(object, "num_perphase").equals("false") ? -1 : getInt(object, "num_perphase");
		autoFollow.cancelBelowAmount = getString(object, "cancel_belowamount") == null || getString(object, "cancel_belowamount").equals("false") ? 0.0 : getDouble(object, "cancel_belowamount");
		autoFollow.unitAmount = getString(object, "unit_amount") == null ? 0.0 : getDouble(object, "unit_amount");
		
		Integer autoFollowTypeValue = getString(object, "type") == null ? null : getInt(object, "type");
		if (autoFollowTypeValue != null && autoFollowTypeValue > 0) {
			autoFollow.autoFollowType = AutoFollowType.getItem(autoFollowTypeValue);
		}
		
		Integer lotteryTypeValue = getString(object, "lottery_type") == null ? null : getInt(object, "lottery_type");
		if (lotteryTypeValue != null && lotteryTypeValue >= 0) {
			autoFollow.lotteryType = LotteryType.getItem(lotteryTypeValue);
		}
		return autoFollow;
	}
	
	@SuppressWarnings("unchecked")
	public static List<AutoFollow> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<AutoFollow> list = new ArrayList<AutoFollow>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public Date getTimeline() {
		return timeline;
	}

	public void setTimeline(Date timeline) {
		this.timeline = timeline;
	}

	public Integer getPrizefollowtimes() {
		return prizefollowtimes;
	}

	public void setPrizefollowtimes(Integer prizefollowtimes) {
		this.prizefollowtimes = prizefollowtimes;
	}

	public Double getPrize() {
		return prize;
	}

	public void setPrize(Double prize) {
		this.prize = prize;
	}

	public Integer getFollowtimes() {
		return followtimes;
	}

	public void setFollowtimes(Integer followtimes) {
		this.followtimes = followtimes;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getFuid() {
		return fuid;
	}

	public void setFuid(Long fuid) {
		this.fuid = fuid;
	}

	public Long getTuid() {
		return tuid;
	}

	public void setTuid(Long tuid) {
		this.tuid = tuid;
	}

	public String getStatsFollowtimes() {
		return statsFollowtimes;
	}

	public void setStatsFollowtimes(String statsFollowtimes) {
		this.statsFollowtimes = statsFollowtimes;
	}



	public String getFusername() {
		return fusername;
	}

	public void setFusername(String fusername) {
		this.fusername = fusername;
	}

	public String getTusername() {
		return tusername;
	}

	public void setTusername(String tusername) {
		this.tusername = tusername;
	}

	public LotteryType getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	public AutoFollowType getAutoFollowType() {
		return autoFollowType;
	}

	public void setAutoFollowType(AutoFollowType autoFollowType) {
		this.autoFollowType = autoFollowType;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public Integer getNumPerphase() {
		return numPerphase;
	}

	public void setNumPerphase(Integer numPerphase) {
		this.numPerphase = numPerphase;
	}

	public Double getUnitAmount() {
		return unitAmount;
	}

	public void setUnitAmount(Double unitAmount) {
		this.unitAmount = unitAmount;
	}

	public Double getCancelBelowAmount() {
		return cancelBelowAmount;
	}

	public void setCancelBelowAmount(Double cancelBelowAmount) {
		this.cancelBelowAmount = cancelBelowAmount;
	}

	public Double getStatsAmount() {
		return statsAmount;
	}

	public void setStatsAmount(Double statsAmount) {
		this.statsAmount = statsAmount;
	}

	public Double getStatsPrize() {
		return statsPrize;
	}

	public void setStatsPrize(Double statsPrize) {
		this.statsPrize = statsPrize;
	}

	public YesNoStatus getStatus() {
		return status;
	}

	public void setStatus(YesNoStatus status) {
		this.status = status;
	}


}
