package com.lehecai.core.lottery.status;


import java.util.Date;

import net.sf.json.JSONObject;

import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.memcached.IMemcachedObject;
import com.lehecai.core.util.CoreDateUtils;

/**
 * 方案开奖实时状态
 * @author zhangzhiqiang
 *
 */
public class LotteryDrawPlanStatus implements IMemcachedObject{

	private static final long serialVersionUID = 1L;
	
	private int totalPlanCount=0;//需要开奖的方案总数
	
	private int successfulPlanCount = 0;//已处理成功方案个数
	private int failedPlanCount = 0;//已处理失败方案个数
	
	private int currPlanIndex=0;//当前正在开奖的方案序号;
	
	private String message=""; //即时消息
	
	private Date startTime; //开始运行时间
	
	private boolean complete=false;
	
	private boolean executeOk=true;
	
	private LotteryType lotteryType;
	
	private String phase = ""; //开奖彩期
	
	
	public static JSONObject toJSON(LotteryDrawPlanStatus lotteryDrawPlanStatus) {
		if(lotteryDrawPlanStatus==null){
			return null;
		}
		JSONObject object = new JSONObject();
		object.put("totalPlanCount", lotteryDrawPlanStatus.getTotalPlanCount());
		object.put("successfulPlanCount", lotteryDrawPlanStatus.getSuccessfulPlanCount());
		object.put("failedPlanCount", lotteryDrawPlanStatus.getFailedPlanCount());
		object.put("currPlanIndex", lotteryDrawPlanStatus.getCurrPlanIndex());
		object.put("message", lotteryDrawPlanStatus.getMessage());
		object.put("startTime", lotteryDrawPlanStatus.getStartTime()==null?"":CoreDateUtils.formatDate(lotteryDrawPlanStatus.getStartTime(),CoreDateUtils.DATETIME));
		object.put("complete", lotteryDrawPlanStatus.isComplete()?"1":"0");
		object.put("executeOk", lotteryDrawPlanStatus.isExecuteOk()?"1":"0");
		object.put("lotteryTypeValue", lotteryDrawPlanStatus.getLotteryType() == null ? "" : lotteryDrawPlanStatus.getLotteryType().getValue());
		object.put("phase", lotteryDrawPlanStatus.getPhase());
		object.put("timeConsuming", lotteryDrawPlanStatus.getTimeConsuming());//耗时
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
	public LotteryType getLotteryType() {
		return lotteryType;
	}
	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
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
}
