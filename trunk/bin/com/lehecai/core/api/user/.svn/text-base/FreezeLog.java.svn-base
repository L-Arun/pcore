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
import com.lehecai.core.lottery.FrozenStatus;
import com.lehecai.core.lottery.WalletType;
import com.lehecai.core.util.CoreDateUtils;

/**
 * @author qatang
 *
 */
public class FreezeLog extends AbstractApiResultBean {
	
	public static final String QUERY_DEDUCT_ID = "deduct_id";
	public static final String QUERY_FROZEN_ID = "frozen_id";
	public static final String QUERY_UID = "uid";
	public static final String QUERY_FROZEN_STATUS = "status";
	public static final String QUERY_WALLET_TYPE = "wallet_type";
	public static final String QUERY_TIMELINE = "timeline";
	
	public static final String ORDER_UID = "uid";
	public static final String ORDER_DEDUCT_ID = "deduct_id";
	public static final String ORDER_AMOUNT = "amount";
	public static final String ORDER_TIMELINE = "timeline";
	
	public static final String SET_FROZEN_STATUS = "status";
	public static final String SET_AMOUNT = "amount";
	public static final String SET_REMARK = "remark";
	
	private long deduct_id;         //扣款记录id
	private long frozen_id;         //冻结记录id
	
	private long uid;
	private String username;
	private FrozenStatus status;    //冻结状态
	private WalletType walletType;  //钱包类型
	private double amount;          //金额
	private Date timeline;          //发起时间
	private String remark;          //备注
	
	public static FreezeLog convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		FreezeLog freezeLog = new FreezeLog();

		freezeLog.deduct_id = getLong(object, "deduct_id");
		freezeLog.frozen_id = getLong(object, "frozen_id");
		freezeLog.uid = getLong(object, "uid");
		freezeLog.setUsername(getString(object, "username"));
		freezeLog.setStatus(FrozenStatus.getItem(getInt(object, "status")));
		freezeLog.setWalletType(WalletType.getItem(getInt(object, "wallet_type")));
		freezeLog.amount = getDouble(object, "amount");
		freezeLog.setRemark(getString(object, "remark"));
		freezeLog.setTimeline(CoreDateUtils.parseDate(getString(object, "timeline"), CoreDateUtils.DATETIME));

		return freezeLog;
	}
	
	@SuppressWarnings("unchecked")
	public static List<FreezeLog> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<FreezeLog> list = new ArrayList<FreezeLog>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public long getDeduct_id() {
		return deduct_id;
	}

	public void setDeduct_id(long deductId) {
		deduct_id = deductId;
	}

	public long getFrozen_id() {
		return frozen_id;
	}

	public void setFrozen_id(long frozenId) {
		frozen_id = frozenId;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public FrozenStatus getStatus() {
		return status;
	}

	public void setStatus(FrozenStatus status) {
		this.status = status;
	}

	public WalletType getWalletType() {
		return walletType;
	}

	public void setWalletType(WalletType walletType) {
		this.walletType = walletType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getTimeline() {
		return timeline;
	}

	public void setTimeline(Date timeline) {
		this.timeline = timeline;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
