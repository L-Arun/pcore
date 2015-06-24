package com.lehecai.core.lottery.task;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;

/**
 * 派奖的队列任务对象
 * 用于放入队列通知彩票派奖线程派奖的任务描述
 * @author leiming
 *
 */
public class LotteryRewardQueueTask extends AbstractApiResultBean{
	private String phase;//彩期号
	private String lotteryTypeValue;//彩期类型值
	private String[] plans;//方案id数组
	private String[] posttaxPrizes;//税后奖金数组,与方案数组编号一一对应
	private String[] rebateAmounts;//发单人提成金额,与方案数组编号一一对应

	
	public static final String JSON_KEYNAME_PHASE = "phase";
	public static final String JSON_KEYNAME_LOTTERYTYPEVALUE = "lotteryTypeValue";
	public static final String JSON_KEYNAME_PLANS = "plans";
	public static final String JSON_KEYNAME_POSTTAXPRIZE = "posttaxPrizes";
	public static final String JSON_KEYNAME_REBATEAMOUNT = "rebateAmounts";
	
	/**
	 * 从jsonString字符串转为实体bean
	 * @param jsonString
	 * @return
	 */
	public static LotteryRewardQueueTask convertFromJSONString2Bean(String jsonString) {
		if (jsonString == null) {
			return null;
		}
		JSONObject object = JSONObject.fromObject(jsonString);
		LotteryRewardQueueTask lotteryDrawQueueTask = convertFromJSONObject(object);
		return lotteryDrawQueueTask;
	}
	/**
	 * 从JSONObject转换为实体bean
	 * @param object
	 * @return
	 */
	public static LotteryRewardQueueTask convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		LotteryRewardQueueTask lotteryRewardQueueTask = new LotteryRewardQueueTask();
		
		lotteryRewardQueueTask.phase = getString(object, JSON_KEYNAME_PHASE);
		lotteryRewardQueueTask.lotteryTypeValue = getString(object, JSON_KEYNAME_LOTTERYTYPEVALUE);
		JSONArray planJsonArray = getArray(object, JSON_KEYNAME_PLANS);
		JSONArray posttaxPrizeJsonArray = getArray(object, JSON_KEYNAME_POSTTAXPRIZE);
		JSONArray rebateAmountJsonArray = getArray(object, JSON_KEYNAME_REBATEAMOUNT);
		lotteryRewardQueueTask.plans = (String[])JSONArray.toArray(planJsonArray, String.class);
		lotteryRewardQueueTask.posttaxPrizes = (String[])JSONArray.toArray(posttaxPrizeJsonArray, String.class);
		lotteryRewardQueueTask.rebateAmounts = (String[])JSONArray.toArray(rebateAmountJsonArray, String.class);
		
		return lotteryRewardQueueTask;
	}
	/**
	 * 将实体Bean转换为JSONObject
	 * @param lotteryDrawQueueTask
	 * @return
	 */
	public static JSONObject toJSON(LotteryRewardQueueTask lotteryRewardQueueTask) {
		if(lotteryRewardQueueTask==null){
			return null;
		}
		JSONObject object = new JSONObject();
		object.put(JSON_KEYNAME_LOTTERYTYPEVALUE, lotteryRewardQueueTask.getLotteryTypeValue());
		object.put(JSON_KEYNAME_PHASE, lotteryRewardQueueTask.getPhase());
		object.put(JSON_KEYNAME_PLANS, JSONArray.fromObject(lotteryRewardQueueTask.getPlans()));
		object.put(JSON_KEYNAME_POSTTAXPRIZE, JSONArray.fromObject(lotteryRewardQueueTask.getPosttaxPrizes()));
		object.put(JSON_KEYNAME_REBATEAMOUNT, JSONArray.fromObject(lotteryRewardQueueTask.getRebateAmounts()));
		return object;
	}
	/**
	 * 将实体Bean转换为JSON格式的字符串
	 * @param lotteryDrawQueueTask
	 * @return
	 */
	public static String toJSONString(LotteryRewardQueueTask lotteryDrawQueueTask) {
		JSONObject object = JSONObject.fromObject(lotteryDrawQueueTask);
		return object.toString();
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public String getLotteryTypeValue() {
		return lotteryTypeValue;
	}
	public void setLotteryTypeValue(String lotteryTypeValue) {
		this.lotteryTypeValue = lotteryTypeValue;
	}
	public String[] getPlans() {
		return plans;
	}
	public void setPlans(String[] plans) {
		this.plans = plans;
	}
	public String[] getPosttaxPrizes() {
		return posttaxPrizes;
	}
	public void setPosttaxPrizes(String[] posttaxPrizes) {
		this.posttaxPrizes = posttaxPrizes;
	}
	public String[] getRebateAmounts() {
		return rebateAmounts;
	}
	public void setRebateAmounts(String[] rebateAmounts) {
		this.rebateAmounts = rebateAmounts;
	}
	
}
