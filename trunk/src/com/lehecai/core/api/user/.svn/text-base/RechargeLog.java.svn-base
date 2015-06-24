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
import com.lehecai.core.lottery.BankType;
import com.lehecai.core.lottery.OperationStatus;
import com.lehecai.core.lottery.RechargeType;
import com.lehecai.core.lottery.WalletType;
import com.lehecai.core.util.CoreDateUtils;

/**
 * @author Sunshow
 * 充值流水日志
 */
public class RechargeLog extends AbstractApiResultBean {
	
	public static final String QUERY_UID = "uid";
	public static final String QUERY_AMOUNT = "amount";
	public static final String QUERY_PAY_AMOUNT = "pay_amount";
	public static final String QUERY_PAY_NO = "pay_no";
	public static final String QUERY_RECHARGE_TYPE = "type";
	public static final String QUERY_BANK_ID = "bank_id";
	public static final String QUERY_WALLET_TYPE = "wallet_type";
	public static final String QUERY_CREATED_TIME = "timeline";
	public static final String QUERY_SUCCESS_TIME = "success_time";
	public static final String QUERY_STATUS = "status";
	public static final String QUERY_SOURCE_ID = "source";
	public static final String QUERY_LOG_ID = "recharge_id";
	
	public static final String ORDER_LOG_ID = "recharge_id";
	public static final String ORDER_PAY_AMOUT = "pay_amount";
	public static final String ORDER_CREATED_TIME = "timeline";
	
	private String id;			//流水ID
	private long uid;			//用户ID
	private String username;	//用户名 
	
	private double amount;			//充值金额
	private double payAmount; 		//到账金额
	private String payNo;			//支付编号
	
	private RechargeType rechargeType;	//充值类型
	private BankType bankType;			//银行
	private WalletType walletType;		//钱包类型
	
	private Date createdTime;			//发起充值时间
	private Date successTime;			//充值成功时间
	
	private OperationStatus status;		//操作状态
	
	private int sourceId;				//渠道来源
	
	private String requestInfo;			//请求信息
	private String returnInfo;			//返回信息
	private int rechargerUid;			//充值人UID
	private String rechargerUsername;	//充值人username

	
	public static RechargeLog convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		RechargeLog log = new RechargeLog();
		log.id = getString(object, "recharge_id");
		log.uid = getLong(object, "uid");
		log.username = getString(object, "username");
		
		log.amount = getDouble(object, "amount");
		log.payAmount = getDouble(object, "pay_amount");
		log.payNo = getString(object, "pay_no");
		
		int iRechargeType = getInt(object, "type");
		if (iRechargeType >= 0) {
			log.rechargeType = RechargeType.getItem(iRechargeType);
		}
		
		int iBankType = getInt(object, "bank_id");
		if (iBankType >= 0) {
			log.bankType = BankType.getItem(iBankType);
		}
		
		int iWalletType = getInt(object, "wallet_type");
		if (iWalletType >= 0) {
			log.walletType = WalletType.getItem(iWalletType);
		}
		
		log.createdTime = CoreDateUtils.parseDate(getString(object, "timeline"), CoreDateUtils.DATETIME);
		log.successTime = CoreDateUtils.parseDate(getString(object, "success_time"), CoreDateUtils.DATETIME);
		
		log.sourceId = getInt(object, "source");
		log.requestInfo = getString(object, "request_info");
		log.returnInfo = getString(object, "return_info");
		log.rechargerUid = getInt(object, "recharger_uid");
		log.rechargerUsername = getString(object, "recharger_username");
		
		int iStatus = getInt(object, "status");
		if (iStatus >= 0) {
			log.status = OperationStatus.getItem(iStatus);
		}
		
		return log;
	}
	
	@SuppressWarnings("unchecked")
	public static List<RechargeLog> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<RechargeLog> list = new ArrayList<RechargeLog>();
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPayNo() {
		return payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	public RechargeType getRechargeType() {
		return rechargeType;
	}

	public void setRechargeType(RechargeType rechargeType) {
		this.rechargeType = rechargeType;
	}

	public BankType getBankType() {
		return bankType;
	}

	public void setBankType(BankType bankType) {
		this.bankType = bankType;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getSuccessTime() {
		return successTime;
	}

	public void setSuccessTime(Date successTime) {
		this.successTime = successTime;
	}

	public OperationStatus getStatus() {
		return status;
	}

	public void setStatus(OperationStatus status) {
		this.status = status;
	}

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}

	public String getRequestInfo() {
		return requestInfo;
	}

	public void setRequestInfo(String requestInfo) {
		this.requestInfo = requestInfo;
	}

	public String getReturnInfo() {
		return returnInfo;
	}

	public void setReturnInfo(String returnInfo) {
		this.returnInfo = returnInfo;
	}

	public int getRechargerUid() {
		return rechargerUid;
	}

	public void setRechargerUid(int rechargerUid) {
		this.rechargerUid = rechargerUid;
	}

	public String getRechargerUsername() {
		return rechargerUsername;
	}

	public void setRechargerUsername(String rechargerUsername) {
		this.rechargerUsername = rechargerUsername;
	}

	public WalletType getWalletType() {
		return walletType;
	}

	public void setWalletType(WalletType walletType) {
		this.walletType = walletType;
	}
	
}
