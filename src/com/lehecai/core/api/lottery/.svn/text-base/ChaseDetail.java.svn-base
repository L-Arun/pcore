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

/**
 * @author qatang
 * 追号记录详情
 */
public class ChaseDetail extends AbstractApiResultBean {
	public static final String QUERY_ID = "id";
	public static final String QUERY_CHASE_ID = "chase_id";
	
	public static final String ORDER_ID = "id";
	
	private String id;				//编号
	private String chaseId;         //追号编号
	private LotteryType lotteryType;
	private String phase;           //彩期
	
	private int multiple;			//倍数
	private int amount;				//方案金额
	
	private ChaseDetailStatus status;		//追号状态
	
	private String planId;
	private String orderId;

	public static ChaseDetail convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		ChaseDetail chaseDetail = new ChaseDetail();
		
		chaseDetail.id = getString(object, "id");
		chaseDetail.chaseId = getString(object, "chase_id");
		chaseDetail.setLotteryType(LotteryType.getItem(getInt(object, "lottery_type")));
		chaseDetail.phase = getString(object, "phase");
		chaseDetail.multiple = getInt(object, "multiple");
		chaseDetail.amount = getInt(object, "amount");
		
		chaseDetail.setStatus(ChaseDetailStatus.getItem(getInt(object, "status")));

		if(object.containsKey("plan_id") && getString(object, "plan_id") != null){		
			chaseDetail.planId = getString(object, "plan_id");
		}

		if(object.containsKey("order_id") && getString(object, "order_id") != null){		
			chaseDetail.orderId = getString(object, "order_id");
		}
		
		return chaseDetail;
	}
	
	@SuppressWarnings("unchecked")
	public static List<ChaseDetail> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<ChaseDetail> list = new ArrayList<ChaseDetail>();
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

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

}
