package com.lehecai.core.lottery.scanner;


import java.util.Date;
import java.util.Random;

import net.sf.json.JSONObject;

import com.lehecai.core.memcached.IMemcachedObject;
import com.lehecai.core.util.CoreDateUtils;

/**
 * 方案派奖实时状态
 * @author qatang
 *
 */
public class PlanRewardScanner implements IMemcachedObject{

	private static final long serialVersionUID = 1L;
	
	private int totalPlanCount = 0;//需要派奖的方案总数
	
	private int processedPlanCount = 0;//已派奖的方案数
	
	private int successfulPlanCount = 0;//成功数
	
	private int failedPlanCount = 0;//失败数
	
	private int waitingPlanCount = 0;//待处理
	
	private int currPlanIndex = 0;//当前正在派奖的方案序号;
	
	private String message; //即时消息
	
	private Date startTime; //开始运行时间
	
	private boolean complete = false;
	
	private boolean executeOk = true;
	
	private String objectId;
	
	public PlanRewardScanner() {
		objectId = new Random().nextInt() + "";
	}
	
	public static JSONObject toJSON(PlanRewardScanner planRewardScanner) {
		if (planRewardScanner == null) {
			return null;
		}
		JSONObject object = new JSONObject();
		object.put("totalPlanCount", planRewardScanner.getTotalPlanCount());
		object.put("processedPlanCount", planRewardScanner.getProcessedPlanCount());
		object.put("currPlanIndex", planRewardScanner.getCurrPlanIndex());
		object.put("successfulPlanCount", planRewardScanner.getSuccessfulPlanCount());
		object.put("failedPlanCount", planRewardScanner.getFailedPlanCount());
		object.put("waitingPlanCount", planRewardScanner.getWaitingPlanCount());
		object.put("message", planRewardScanner.getMessage());
		object.put("startTime", planRewardScanner.getStartTime() == null ? "" : CoreDateUtils.formatDate(planRewardScanner.getStartTime(), CoreDateUtils.DATETIME));
		object.put("complete", planRewardScanner.isComplete());
		object.put("executeOk", planRewardScanner.isExecuteOk());
		object.put("timeConsuming", planRewardScanner.getStartTime() == null ? "0" : planRewardScanner.getTimeConsuming());//耗时
		return object;
	}
	public String getTimeConsuming() {
		long interval = (System.currentTimeMillis() - startTime.getTime())/1000;
		long day = interval / (24 * 3600);
		long hour = interval % (24 * 3600) / 3600;
		long minute = interval % 3600 / 60;
		long second = interval % 60 ;
		StringBuffer strs = new StringBuffer();
		if (day >0) {
			strs.append(day).append("天");
		}
		if (hour >0) {
			strs.append(hour).append("小时");
		}
		if (minute >0) {
			strs.append(minute).append("分");
		}
		if (second >0) {
			strs.append(second).append("秒");
		}
		return strs.toString();
	}
	
	public String getObjectId() {
		return objectId;
	}
	
	public int getTotalPlanCount() {
		return totalPlanCount;
	}
	public void setTotalPlanCount(int totalPlanCount) {
		this.totalPlanCount = totalPlanCount;
	}
	public int getCurrPlanIndex() {
		return currPlanIndex;
	}
	public void setCurrPlanIndex(int currPlanIndex) {
		this.currPlanIndex = currPlanIndex;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	public boolean isExecuteOk() {
		return executeOk;
	}
	public void setExecuteOk(boolean executeOk) {
		this.executeOk = executeOk;
	}
	public int getProcessedPlanCount() {
		return processedPlanCount;
	}
	public void setProcessedPlanCount(int processedPlanCount) {
		this.processedPlanCount = processedPlanCount;
	}
	public int getSuccessfulPlanCount() {
		return successfulPlanCount;
	}
	public void setSuccessfulPlanCount(int successfulPlanCount) {
		this.successfulPlanCount = successfulPlanCount;
	}
	public int getFailedPlanCount() {
		return failedPlanCount;
	}
	public void setFailedPlanCount(int failedPlanCount) {
		this.failedPlanCount = failedPlanCount;
	}
	public int getWaitingPlanCount() {
		return waitingPlanCount;
	}
	public void setWaitingPlanCount(int waitingPlanCount) {
		this.waitingPlanCount = waitingPlanCount;
	}
}
