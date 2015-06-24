package com.lehecai.core.lottery.status;


import java.util.Arrays;
import java.util.Date;

import net.sf.json.JSONObject;

import com.lehecai.core.memcached.IMemcachedObject;
import com.lehecai.core.util.CoreDateUtils;
import com.lehecai.core.util.CoreStringUtils;

/**
 * 方案派奖实时状态
 * @author zhangzhiqiang
 *
 */
public class LotteryRewardPlanStatus implements IMemcachedObject{

	private static final long serialVersionUID = 1L;
	
	private int totalPlanCount=0;//需要派奖的方案总数
	
	private int currPlanIndex=0;//当前正在派奖的方案序号;
	
	private String message=""; //即时消息
	
	private Date startTime; //开始运行时间
	
	private boolean complete=false;
	
	private boolean executeOk=true;
	
	private String lotteryType="";
	
	private String phase = ""; //派奖彩期
	
	private String[] planNos;//派奖彩期id数组
	
	
	public static JSONObject toJSON(LotteryRewardPlanStatus lotteryRewardPlanStatus) {
		if(lotteryRewardPlanStatus==null){
			return null;
		}
		JSONObject object = new JSONObject();
		object.put("totalPlanCount", lotteryRewardPlanStatus.getTotalPlanCount());
		object.put("currPlanIndex", lotteryRewardPlanStatus.getCurrPlanIndex());
		object.put("message", lotteryRewardPlanStatus.getMessage());
		object.put("startTime", lotteryRewardPlanStatus.getStartTime()==null?"":CoreDateUtils.formatDate(lotteryRewardPlanStatus.getStartTime(),CoreDateUtils.DATETIME));
		object.put("complete", lotteryRewardPlanStatus.isComplete()?"1":"0");
		object.put("executeOk", lotteryRewardPlanStatus.isExecuteOk()?"1":"0");
		object.put("lotteryTypeValue", lotteryRewardPlanStatus.getLotteryType()==null?"":lotteryRewardPlanStatus.getLotteryType());
		object.put("phase", lotteryRewardPlanStatus.getPhase());
		object.put("timeConsuming", lotteryRewardPlanStatus.getTimeConsuming());//耗时
		object.put("planNos", lotteryRewardPlanStatus.getPlanNos()==null?"":CoreStringUtils.join(Arrays.asList(lotteryRewardPlanStatus.getPlanNos()), ","));
		return object;
	}
	public String getTimeConsuming() {
		long interval = (System.currentTimeMillis()-startTime.getTime())/1000;
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
	public String getLotteryType() {
		return lotteryType;
	}
	public void setLotteryType(String lotteryType) {
		this.lotteryType = lotteryType;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public String[] getPlanNos() {
		return planNos;
	}
	public void setPlanNos(String[] planNos) {
		this.planNos = planNos;
	}
	


}
