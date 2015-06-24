package com.lehecai.core.lottery.task;

import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;

/**
 * 高频派奖的队列任务对象
 * 用于放入队列通知高频彩种派奖线程派奖的任务描述
 * @author zhangzhiqiang
 *
 */
public class LotteryGPRewardQueueTask extends AbstractApiResultBean{
	private String phase;//彩期号
	private String lotteryTypeValue;//彩期类型值
	

	public static final String JSON_KEYNAME_PHASE = "phase";
	public static final String JSON_KEYNAME_LOTTERYTYPEVALUE = "lotteryTypeValue";

	
	/**
	 * 从jsonString字符串转为实体bean
	 * @param jsonString
	 * @return
	 */
	public static LotteryGPRewardQueueTask convertFromJSONString2Bean(String jsonString) {
		if (jsonString == null) {
			return null;
		}
		JSONObject object = JSONObject.fromObject(jsonString);
		LotteryGPRewardQueueTask lotteryGPRewardQueueTask = convertFromJSONObject(object);
		return lotteryGPRewardQueueTask;
	}
	/**
	 * 从JSONObject转换为实体bean
	 * @param object
	 * @return
	 */
	public static LotteryGPRewardQueueTask convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		LotteryGPRewardQueueTask lotteryGPRewardQueueTask = new LotteryGPRewardQueueTask();
		
		lotteryGPRewardQueueTask.phase = getString(object, JSON_KEYNAME_PHASE);
		lotteryGPRewardQueueTask.lotteryTypeValue = getString(object, JSON_KEYNAME_LOTTERYTYPEVALUE);
		return lotteryGPRewardQueueTask;
	}
	/**
	 * 将实体Bean转换为JSONObject
	 * @param lotteryGPRewardQueueTask
	 * @return
	 */
	public static JSONObject toJSON(LotteryGPRewardQueueTask lotteryGPRewardQueueTask) {
		if(lotteryGPRewardQueueTask==null){
			return null;
		}
		JSONObject object = new JSONObject();
		object.put(JSON_KEYNAME_LOTTERYTYPEVALUE, lotteryGPRewardQueueTask.getLotteryTypeValue());
		object.put(JSON_KEYNAME_PHASE, lotteryGPRewardQueueTask.getPhase());
		return object;
	}
	/**
	 * 将实体Bean转换为JSON格式的字符串
	 * @param lotteryDrawQueueTask
	 * @return
	 */
	public static String toJSONString(LotteryGPRewardQueueTask lotteryDrawQueueTask) {
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
	
	
}
