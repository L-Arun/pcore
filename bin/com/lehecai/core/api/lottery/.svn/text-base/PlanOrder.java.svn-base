/**
 * 
 */
package com.lehecai.core.api.lottery;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.PlanOrderStatus;
import com.lehecai.core.lottery.PlanOrderType;
import com.lehecai.core.lottery.PrizeStatus;
import com.lehecai.core.util.CoreDateUtils;

/**
 * @author qatang Sunshow
 *
 */
public class PlanOrder extends AbstractApiResultBean {
	public static final String QUERY_ID = "order_id";
	public static final String QUERY_PLAN_ID = "plan_id";
	public static final String QUERY_UID = "uid";
	public static final String QUERY_CREATED_TIME = "create_at";
	public static final String QUERY_ORDER_STATUS = "status";
	public static final String QUERY_PRIZE_STATUS = "prize_status";
	public static final String QUERY_PRIZE_TIME = "prize_time";
	public static final String QUERY_ORDER_TYPE = "type";
	public static final String QUERY_SOURCE_ID = "source";
	public static final String QUERY_LOTTERY_TYPE = "lottery_type";
	public static final String QUERY_PHASE = "phase";
	
	public static final String SET_ORDER_STATUS = "status";
	public static final String SET_PRIZE_STATUS = "prize_status";
	public static final String SET_PRIZE_TIME = "prize_time";
	public static final String SET_POSTTAX_PRIZE = "prize_posttax";
	public static final String SET_WALLET = "wallet";
	public static final String SET_ORDER_TYPE = "type";
	public static final String SET_LOG = "log";
	
	public static final String ORDER_ID = "order_id";
	public static final String ORDER_CREATED_TIME = "create_at";
	public static final String ORDER_PRIZE_TIME = "prize_time";
	public static final String ORDER_AMOUNT = "amount";
	public static final String ORDER_POSTTAX_PRIZE = "prize_posttax";

	private String id;			//订单编号
	private String planId;		//订单所属方案编号
	
	private long uid;
	private String username;
	
	private Date createdTime;		//订单创建时间
	private Date payTime;           //支付时间
	
	private PlanOrderStatus orderStatus;	//订单状态
	
	private int amount;				//订单金额
	private int parts;				//购买份数
	
	private double posttaxPrize;	//税后奖金
	private PrizeStatus prizeStatus;	//派奖状态
	private Date prizeTime;			//派奖时间
	
	private String wallet;			//钱包操作对象，这里会保存一个JSON数据，因为一份订单可能会涉及多个钱包操作
	
	private PlanOrderType orderType;	//订单类型
	private LotteryType lotteryType;
	private String phase;
	
	private int sourceId;			//渠道来源
	
	private String log;				//订单操作日志，这里会保存一个JSON数据，记录每次订单操作的日志
	
	private double rebateAmount;	//订单提成金额，只有合买方案的发起人认购订单才可能会有非零

	public static PlanOrder convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		PlanOrder order = new PlanOrder();
		
		order.id = getString(object, "order_id");
		order.planId = getString(object, "plan_id");
		order.uid = getLong(object, "uid");
		order.username = getString(object, "username");
		order.setCreatedTime(getDate(object, "create_at", CoreDateUtils.DATETIME));
		order.setPayTime(getDate(object, "pay_time", CoreDateUtils.DATETIME));
		order.setOrderStatus(PlanOrderStatus.getItem(getInt(object, "status")));
		order.amount = getInt(object, "amount");
		order.parts = getInt(object, "parts");
		order.posttaxPrize = getDouble(object, "prize_posttax");
		order.setPrizeStatus(PrizeStatus.getItem(getInt(object, "prize_status")));
		order.setPrizeTime(getDate(object, "prize_time", CoreDateUtils.DATETIME));
		order.wallet = getString(object, "wallet");
		order.setOrderType(PlanOrderType.getItem(getInt(object, "type")));
		order.sourceId = getInt(object, "source");
		order.log = getString(object, "log");
		int lotteryTypeValue = getInt(object, "lottery_type");
		order.lotteryType = LotteryType.getItem(lotteryTypeValue);
		order.phase = getString(object, "phase");
		order.rebateAmount = getDouble(object, "rebate_amount");
		
		return order;
	}
	
	@SuppressWarnings("unchecked")
	public static List<PlanOrder> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<PlanOrder> list = new ArrayList<PlanOrder>();
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

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
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

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public PlanOrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(PlanOrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getParts() {
		return parts;
	}

	public void setParts(int parts) {
		this.parts = parts;
	}

	public double getPosttaxPrize() {
		return posttaxPrize;
	}

	public void setPosttaxPrize(double posttaxPrize) {
		this.posttaxPrize = posttaxPrize;
	}

	public PrizeStatus getPrizeStatus() {
		return prizeStatus;
	}

	public void setPrizeStatus(PrizeStatus prizeStatus) {
		this.prizeStatus = prizeStatus;
	}

	public Date getPrizeTime() {
		return prizeTime;
	}

	public void setPrizeTime(Date prizeTime) {
		this.prizeTime = prizeTime;
	}

	public String getWallet() {
		return wallet;
	}

	public void setWallet(String wallet) {
		this.wallet = wallet;
	}

	public PlanOrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(PlanOrderType orderType) {
		this.orderType = orderType;
	}

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public double getRebateAmount() {
		return rebateAmount;
	}

	public void setRebateAmount(double rebateAmount) {
		this.rebateAmount = rebateAmount;
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
}
