/**
 * 
 */
package com.lehecai.core.api.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.ConsumptionType;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.OperationStatus;
import com.lehecai.core.lottery.TransType;
import com.lehecai.core.lottery.WalletType;
import com.lehecai.core.util.CoreDateUtils;

/**
 * @author Sunshow
 * 钱包流水日志
 */
public class ConsumptionLog extends AbstractApiResultBean {
	
	public static final String QUERY_LOTTERY_TYPE = "lottery_type";
	public static final String QUERY_TRANS_TYPE = "log_type";
	public static final String QUERY_CREATED_TIME = "timeline";
	public static final String QUERY_USERNAME = "username";
	public static final String QUERY_UID = "uid";
	public static final String QUERY_LOG_ID = "id";
	public static final String QUERY_ORDER_ID = "order_id";
	public static final String QUERY_PLAN_ID = "plan_id";
	public static final String QUERY_WALLET_TYPE = "wallet_type";
	
	public static final String ORDER_LOG_ID = "id";
	public static final String ORDER_CREATED_TIME = "timeline";
	
	private String suffix;		//月份后缀，日志按月归档，不允许跨月查询，格式必须为201009，不设置为查询当前月

	private String logId;		//日志ID	
	private long uid;			//用户ID
	private String username;	//用户名
	private String orderId;		//订单ID
	private String planId;		//方案ID
	
	private TransType transType;	//交易类型
	private ConsumptionType consumptionType;	//消费类型
	private double amount;					//涉及金额
	
	private OperationStatus status;					//数据状态
	private LotteryType lotteryType;			//彩种类型
	
	private WalletType walletType;				//钱包类型
	
	private double balance;						//可用余额
	private double frozen;						//冻结金额
	
	private String description;					//日志描述
	private Date createdTime;					//创建时间
	
	public static ConsumptionLog convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		ConsumptionLog log = new ConsumptionLog();
		log.logId = getString(object, "id");
		log.uid = getLong(object, "uid");
		log.username = getString(object, "username");
		log.orderId = getString(object, "order_id");
		log.planId = getString(object, "plan_id");
		
		int iTransType = getInt(object, "log_type");
		if (iTransType >= 0) {
			log.transType = TransType.getItem(iTransType);
		}
		int iConsumptionType = getInt(object, "con_type");
		if (iConsumptionType >= 0) {
			log.consumptionType = ConsumptionType.getItem(iConsumptionType);
		}
		
		log.amount = getDouble(object, "amount");
		
		int iStatus = getInt(object, "status");
		if (iStatus >= 0) {
			log.status = OperationStatus.getItem(iStatus);
		}
		int iLotteryType = getInt(object, "lottery_type");
		if (iLotteryType > 0) {
			log.lotteryType = LotteryType.getItem(iLotteryType);
		}
		
		log.description = getString(object, "description");
		
		int iWalletType = getInt(object, "wallet_type");
		if (iWalletType > 0) {
			log.walletType = WalletType.getItem(iWalletType);
		}
		
		log.balance = getDouble(object, "balance");
		log.frozen = getDouble(object, "frozen");
		
		log.createdTime = CoreDateUtils.parseDate(getString(object, "timeline"), CoreDateUtils.DATETIME);
		
		return log;
	}
	
	@SuppressWarnings("unchecked")
	public static List<ConsumptionLog> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<ConsumptionLog> list = new ArrayList<ConsumptionLog>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}
	
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
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
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public TransType getTransType() {
		return transType;
	}
	public void setTransType(TransType transType) {
		this.transType = transType;
	}
	public ConsumptionType getConsumptionType() {
		return consumptionType;
	}
	public void setConsumptionType(ConsumptionType consumptionType) {
		this.consumptionType = consumptionType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public OperationStatus getStatus() {
		return status;
	}
	public void setStatus(OperationStatus status) {
		this.status = status;
	}
	public LotteryType getLotteryType() {
		return lotteryType;
	}
	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}
	public WalletType getWalletType() {
		return walletType;
	}
	public void setWalletType(WalletType walletType) {
		this.walletType = walletType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getFrozen() {
		return frozen;
	}
	public void setFrozen(double frozen) {
		this.frozen = frozen;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
}
