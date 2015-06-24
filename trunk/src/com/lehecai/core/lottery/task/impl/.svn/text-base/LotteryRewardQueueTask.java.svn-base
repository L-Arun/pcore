/**
 * 
 */
package com.lehecai.core.lottery.task.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.YesNoStatus;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.task.ILotteryRewardTask;
import com.lehecai.core.util.CoreJSONUtils;

/**
 * @author qatang
 *
 */
public class LotteryRewardQueueTask implements ILotteryRewardTask {
	public static final String KEY_TASK_ID = "task_id";
	public static final String KEY_PHASE = "phase";
	public static final String KEY_LOTTERY_TYPE_VALUE = "lottery_type_value";
	public static final String KEY_PRIZE_SCOPE_REWARD = "prize_scope_reward";
	public static final String KEY_PRIZE_SCOPE = "prize_scope";
	public static final String KEY_PLANS = "plans";
	
	private String taskId;
	private LotteryType lotteryType;
	private String phaseNo;
	private YesNoStatus prizeScopeReward;
	private double prizeScope;
	private List<String> planNoList;

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("taskId: ").append(taskId).append(", lotteryType: ").append(lotteryType).append(", phaseNo: ").append(phaseNo);
		return sb.toString();
	}

	@SuppressWarnings("unchecked")
	public static LotteryRewardQueueTask convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		LotteryRewardQueueTask lotteryRewardQueueTask = new LotteryRewardQueueTask();
		
		lotteryRewardQueueTask.setTaskId(CoreJSONUtils.getString(object, KEY_TASK_ID));
		lotteryRewardQueueTask.setLotteryType(LotteryType.getItem(CoreJSONUtils.getInt(object, KEY_LOTTERY_TYPE_VALUE)));
		lotteryRewardQueueTask.setPhaseNo(CoreJSONUtils.getString(object, KEY_PHASE));
		lotteryRewardQueueTask.setPrizeScopeReward(YesNoStatus.getItem(CoreJSONUtils.getInt(object, KEY_PRIZE_SCOPE_REWARD)));
		lotteryRewardQueueTask.setPrizeScope(CoreJSONUtils.getDouble(object, KEY_PRIZE_SCOPE));
		
		List<String> tmpPlanNoList = new ArrayList<String>();
		JSONArray jsonArray = CoreJSONUtils.getArray(object, KEY_PLANS);
		for (Iterator iterator = jsonArray.iterator(); iterator.hasNext();) {
			String planNo = (String) iterator.next();
			tmpPlanNoList.add(planNo);
		}
		lotteryRewardQueueTask.setPlanNoList(tmpPlanNoList);
		
		return lotteryRewardQueueTask;
	}
	
	public static JSONObject toJSON(LotteryRewardQueueTask lotteryRewardQueueTask) {
		if (lotteryRewardQueueTask == null) {
			return null;
		}
		JSONObject object = new JSONObject();
		object.put(KEY_TASK_ID, lotteryRewardQueueTask.getTaskId());
		object.put(KEY_LOTTERY_TYPE_VALUE, lotteryRewardQueueTask.getLotteryType().getValue());
		object.put(KEY_PHASE, lotteryRewardQueueTask.getPhaseNo());
		object.put(KEY_PRIZE_SCOPE_REWARD, lotteryRewardQueueTask.getPrizeScopeReward().getValue());
		object.put(KEY_PRIZE_SCOPE, lotteryRewardQueueTask.getPrizeScope());
		
		JSONArray jsonArray = new JSONArray();
		for (String planNo : lotteryRewardQueueTask.getPlanNoList()) {
			jsonArray.add(planNo);
		}
		object.put(KEY_PLANS, jsonArray);
		return object;
	}

	@Override
	public LotteryType getLotteryType() {
		return lotteryType;
	}

	@Override
	public String getPhaseNo() {
		return phaseNo;
	}

	@Override
	public double getPrizeScope() {
		return prizeScope;
	}

	@Override
	public YesNoStatus getPrizeScopeReward() {
		return prizeScopeReward;
	}

	@Override
	public List<String> getPlanNoList() {
		return planNoList;
	}
	
	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	public void setPhaseNo(String phaseNo) {
		this.phaseNo = phaseNo;
	}

	public void setPlanNoList(List<String> planNoList) {
		this.planNoList = planNoList;
	}

	public void setPrizeScopeReward(YesNoStatus prizeScopeReward) {
		this.prizeScopeReward = prizeScopeReward;
	}

	public void setPrizeScope(double prizeScope) {
		this.prizeScope = prizeScope;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

}
