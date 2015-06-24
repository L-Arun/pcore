/**
 * 
 */
package com.lehecai.core.api.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.LotteryType;

/**
 * @author Sunshow qatang
 * 会员消费
 */
public class MemberConsumption extends AbstractApiResultBean {
	
	public static final String QUERY_UID = "uid";
	public static final String QUERY_USERNAME = "username";
	public static final String QUERY_LOTTERY_TYPE = "lottery_type";
	public static final String QUERY_TIMELINE = "timeline";
	
	public static final String ORDER_USERNAME = "username";
	public static final String ORDER_CONSUME_AMOUNT = "consume_amount";
	public static final String ORDER_PRIZE_AMOUNT = "prize_amount";
	
	private long uid;			//用户ID
	private String username;	//用户名
	
	private LotteryType lotteryType;
	
	private double consumeAmount;
	private double prizeAmount;
	
	public static MemberConsumption convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		MemberConsumption consumption = new MemberConsumption();
		consumption.uid = getLong(object, "uid");
		consumption.username = getString(object, "username");
		
		if (object.containsKey("lottery_type")) {
			int iLotteryType = getInt(object, "lottery_type");
			if (iLotteryType > 0) {
				consumption.lotteryType = LotteryType.getItem(iLotteryType);
			}
		}
		
		consumption.consumeAmount = getDouble(object, "consume_amount");
		consumption.prizeAmount = getDouble(object, "prize_amount");
		return consumption;
	}
	
	@SuppressWarnings("unchecked")
	public static List<MemberConsumption> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<MemberConsumption> list = new ArrayList<MemberConsumption>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LotteryType getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	public double getConsumeAmount() {
		return consumeAmount;
	}

	public void setConsumeAmount(double consumeAmount) {
		this.consumeAmount = consumeAmount;
	}

	public double getPrizeAmount() {
		return prizeAmount;
	}

	public void setPrizeAmount(double prizeAmount) {
		this.prizeAmount = prizeAmount;
	}

}
