/**
 * 
 */
package com.lehecai.core.api.lottery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.ChaseDetailStatus;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.StopChaseType;

/**
 * 待执行的追号记录
 * @author Sunshow
 */
public class ChaseWait extends AbstractApiResultBean {
	public static final String QUERY_ID = "id";
	public static final String QUERY_CHASE_ID = "chase_id";
	public static final String QUERY_LOTTERY_TYPE = "lottery_type";
	public static final String QUERY_PHASE = "phase";
	public static final String QUERY_CHASE_STATUS = "status";
	public static final String QUERY_STOPCHASE_TYPE = "win_operate";
	
	public static final String ORDER_ID = "id";
	
	private String id;				//编号
	private String chaseId;         //追号编号
	private LotteryType lotteryType;
	private String phase;           //彩期
	
	private int multiple;			//倍数
	private int amount;				//方案金额
	
	private ChaseDetailStatus status;		//追号状态
	
	private StopChaseType stopChaseType;	//停止追号类型
	
	public static ChaseWait convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		ChaseWait chaseWait = new ChaseWait();
		
		chaseWait.id = getString(object, "id");
		chaseWait.chaseId = getString(object, "chase_id");
		chaseWait.setLotteryType(LotteryType.getItem(getInt(object, "lottery_type")));
		chaseWait.phase = getString(object, "phase");
		chaseWait.multiple = getInt(object, "multiple");
		chaseWait.amount = getInt(object, "amount");
		
		chaseWait.setStatus(ChaseDetailStatus.getItem(getInt(object, "status")));

		chaseWait.setStopChaseType(StopChaseType.getItem(getInt(object, "win_operate")));
		
		return chaseWait;
	}
	
	@SuppressWarnings("unchecked")
	public static List<ChaseWait> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<ChaseWait> list = new ArrayList<ChaseWait>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChaseId() {
		return chaseId;
	}

	public void setChaseId(String chaseId) {
		this.chaseId = chaseId;
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

	public int getMultiple() {
		return multiple;
	}

	public void setMultiple(int multiple) {
		this.multiple = multiple;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public ChaseDetailStatus getStatus() {
		return status;
	}

	public void setStatus(ChaseDetailStatus status) {
		this.status = status;
	}

	public StopChaseType getStopChaseType() {
		return stopChaseType;
	}

	public void setStopChaseType(StopChaseType stopChaseType) {
		this.stopChaseType = stopChaseType;
	}

}
