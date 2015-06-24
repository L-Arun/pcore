package com.lehecai.core.lottery.task.impl;

import java.util.Date;

import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.BetType;
import com.lehecai.core.lottery.DrawType;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.task.ILotteryDrawTask;
import com.lehecai.core.util.CoreDateUtils;
import com.lehecai.core.util.CoreJSONUtils;

/**
 * 开奖的队列任务对象
 * 用于放入队列通知彩票开奖线程开奖的任务描述
 * @author leiming
 *
 */
public class LotteryDrawQueueTask extends AbstractApiResultBean implements ILotteryDrawTask{
	private String phaseNo;//彩期号
	
	private boolean forAbort; //是否只为流产
	private LotteryType lotteryType;//彩期类型值
	private boolean reopen;//单场重新开奖标志位  json值:1|0    2010-11-03未用待扩展
	private String lastMatchNum;//北单最后开奖比赛序号 单场开奖必须要有
	private BetType betType;//彩票投注类型,竞猜中固定投注和浮动投注
	private Date startDrawDate;//开始开奖时间,竞彩的开奖时间
	private Date endDrawDate;//结束开奖时间,竞彩的开奖时间
	private DrawType drawType;//开奖类型
	
	private Date createBeginTime;	// 方案起始创建时间
	
	/**
	 * 只为流产
	 */
	public static final String ISFORABORT = "1";
	public static final String REOPEN = "true";
	
	public static final String JSON_KEYNAME_PHASENO = "phaseNo";
	public static final String JSON_KEYNAME_ISFORABORT = "isForAbort";
	public static final String JSON_KEYNAME_LOTTERYTYPEVALUE = "lotteryTypeValue";
	public static final String JSON_KEYNAME_REOPEN = "reopen";
	public static final String JSON_KEYNAME_LASTMATCHNUM = "lastMatchNum";
	public static final String JSON_KEYNAME_BETTYPE = "betType";
	public static final String JSON_KEYNAME_STARTDRAWDATE = "startDrawDate";
	public static final String JSON_KEYNAME_ENDDRAWDATE = "endDrawDate";
	public static final String JSON_KEYNAME_DRAWTYPE = "drawType";
	public static final String JSON_KEYNAME_CREATEBEGINTIME = "createBeginTime";
	
	/**
	 * 从jsonString字符串转为实体bean
	 * @param jsonString
	 * @return
	 */
	public static LotteryDrawQueueTask convertFromJSONString2Bean(String jsonString) {
		if (jsonString == null) {
			return null;
		}
		JSONObject object = JSONObject.fromObject(jsonString);
		LotteryDrawQueueTask lotteryDrawQueueTask = convertFromJSONObject(object);
		return lotteryDrawQueueTask;
	}
	/**
	 * 从JSONObject转换为实体bean
	 * @param object
	 * @return
	 */
	public static LotteryDrawQueueTask convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		LotteryDrawQueueTask lotteryDrawQueueTask = new LotteryDrawQueueTask();
		
		lotteryDrawQueueTask.phaseNo = getString(object, JSON_KEYNAME_PHASENO);
		if (object.containsKey(JSON_KEYNAME_ISFORABORT)) {
			String forAbortStr = getString(object, JSON_KEYNAME_ISFORABORT);
			if ("1".equals(forAbortStr)) {
				lotteryDrawQueueTask.forAbort = true;
			}
		}
		lotteryDrawQueueTask.lotteryType = LotteryType.getItem(getInt(object, JSON_KEYNAME_LOTTERYTYPEVALUE));
		
		String reopenStr = null;
		if (object.containsKey(JSON_KEYNAME_REOPEN)) {
			reopenStr = getString(object, JSON_KEYNAME_REOPEN);
		}
		if (reopenStr != null && reopenStr.equals(REOPEN)) {
			lotteryDrawQueueTask.reopen = true;
		} else {
			lotteryDrawQueueTask.reopen = false;
		}
		
		if (object.containsKey(JSON_KEYNAME_LASTMATCHNUM)) {
			lotteryDrawQueueTask.lastMatchNum = getString(object, JSON_KEYNAME_LASTMATCHNUM);
		}
		// 投注类型
		if (object.containsKey(JSON_KEYNAME_BETTYPE)) {
			try{
				lotteryDrawQueueTask.betType = BetType.getItem(getInt(object, JSON_KEYNAME_BETTYPE));
			}catch(Exception e){
				logger.error("转换彩票投注类型出错,{}",e.getMessage());
			}
		}
		// 开奖类型
		if (object.containsKey(JSON_KEYNAME_DRAWTYPE)) {
			try{
				lotteryDrawQueueTask.drawType = DrawType.getItem(getInt(object, JSON_KEYNAME_DRAWTYPE));
			}catch(Exception e){
				logger.error("转换开奖类型出错,{}",e.getMessage());
			}
		}
		// 开始开奖时间
		if (object.containsKey(JSON_KEYNAME_STARTDRAWDATE)) {
			try{
				lotteryDrawQueueTask.startDrawDate = CoreJSONUtils.getDate(object, JSON_KEYNAME_STARTDRAWDATE, CoreDateUtils.DATETIME);
			}catch(Exception e){
				logger.error("转换开始开奖时间出错,{}",e.getMessage());
			}
		}
		// 结束开奖时间
		if (object.containsKey(JSON_KEYNAME_ENDDRAWDATE)) {
			try {
				lotteryDrawQueueTask.endDrawDate = CoreJSONUtils.getDate(object, JSON_KEYNAME_ENDDRAWDATE, CoreDateUtils.DATETIME);
			} catch(Exception e){
				logger.error("转换结束开奖时间出错,{}",e.getMessage());
			}
		}
		// 方案创建时间
		if (object.containsKey(JSON_KEYNAME_CREATEBEGINTIME)) {
			try{
				lotteryDrawQueueTask.createBeginTime = CoreJSONUtils.getDate(object, JSON_KEYNAME_CREATEBEGINTIME, CoreDateUtils.DATETIME);
			} catch(Exception e){
				logger.error("转换方案创建时间出错,{}",e.getMessage());
			}
		}
		
		return lotteryDrawQueueTask;
	}
	/**
	 * 将实体Bean转换为JSONObject
	 * @param lotteryDrawQueueTask
	 * @return
	 */
	public static JSONObject toJSON(LotteryDrawQueueTask lotteryDrawQueueTask) {
		if(lotteryDrawQueueTask==null){
			return null;
		}
		JSONObject object = new JSONObject();
		object.put(JSON_KEYNAME_LOTTERYTYPEVALUE, lotteryDrawQueueTask.getLotteryType().getValue());
		object.put(JSON_KEYNAME_PHASENO, lotteryDrawQueueTask.getPhaseNo());
		object.put(JSON_KEYNAME_ISFORABORT, lotteryDrawQueueTask.isForAbort() ? "1" : "0");
		object.put(JSON_KEYNAME_REOPEN, lotteryDrawQueueTask.getReopen()?"true":"false");
		object.put(JSON_KEYNAME_LASTMATCHNUM, lotteryDrawQueueTask.getLastMatchNum());
		object.put(JSON_KEYNAME_BETTYPE, lotteryDrawQueueTask.getBetType()==null?BetType.DEFAULT.getValue():lotteryDrawQueueTask.getBetType().getValue());
		object.put(JSON_KEYNAME_DRAWTYPE, lotteryDrawQueueTask.getDrawType()==null?DrawType.DEFAULT.getValue():lotteryDrawQueueTask.getDrawType().getValue());
		if (lotteryDrawQueueTask.getStartDrawDate() != null) {
			object.put(JSON_KEYNAME_STARTDRAWDATE, CoreDateUtils.formatDateTime(lotteryDrawQueueTask.getStartDrawDate()));
		}
		if (lotteryDrawQueueTask.getEndDrawDate() != null) {
			object.put(JSON_KEYNAME_ENDDRAWDATE, CoreDateUtils.formatDateTime(lotteryDrawQueueTask.getEndDrawDate()));
		}
		if (lotteryDrawQueueTask.getCreateBeginTime() != null) {
			object.put(JSON_KEYNAME_CREATEBEGINTIME, CoreDateUtils.formatDateTime(lotteryDrawQueueTask.getCreateBeginTime()));
		}
		return object;
	}
	/**
	 * 将实体Bean转换为JSON格式的字符串
	 * @param lotteryDrawQueueTask
	 * @return
	 */
	public static String toJSONString(LotteryDrawQueueTask lotteryDrawQueueTask) {
		JSONObject object = toJSON(lotteryDrawQueueTask);
		return object.toString();
	}
	
	
	public Date getCreateBeginTime() {
		return createBeginTime;
	}
	public void setCreateBeginTime(Date createBeginTime) {
		this.createBeginTime = createBeginTime;
	}
	public String getPhaseNo() {
		return phaseNo;
	}
	public void setPhaseNo(String phaseNo) {
		this.phaseNo = phaseNo;
	}
	public boolean isForAbort() {
		return forAbort;
	}
	public void setForAbort(boolean forAbort) {
		this.forAbort = forAbort;
	}
	public LotteryType getLotteryType() {
		return lotteryType;
	}
	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}
	public boolean getReopen() {
		return reopen;
	}
	public void setReopen(boolean reopen) {
		this.reopen = reopen;
	}
	public String getLastMatchNum() {
		return lastMatchNum;
	}
	public void setLastMatchNum(String lastMatchNum) {
		this.lastMatchNum = lastMatchNum;
	}
	public BetType getBetType() {
		return betType;
	}
	public void setBetType(BetType betType) {
		this.betType = betType;
	}
	public Date getStartDrawDate() {
		return startDrawDate;
	}
	public void setStartDrawDate(Date startDrawDate) {
		this.startDrawDate = startDrawDate;
	}
	public Date getEndDrawDate() {
		return endDrawDate;
	}
	public void setEndDrawDate(Date endDrawDate) {
		this.endDrawDate = endDrawDate;
	}
	public DrawType getDrawType() {
		return drawType;
	}
	public void setDrawType(DrawType drawType) {
		this.drawType = drawType;
	}
	
}
