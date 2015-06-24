package com.lehecai.core.api.lottery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.ComboRecordSyncStatus;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.WalletType;

public class ComboOrderDetailRecord extends AbstractApiResultBean {
	
	public static final String QUERY_COMBO_ORDER_ID = "comboorder_id";
	public static final String QUERY_COMBO_ID = "combo_id";
	public static final String QUERY_UID = "uid";
	public static final String QUERY_LOTTERY_TYPE = "lottery_type";
	public static final String QUERY_PHASE = "phase";
	public static final String QUERY_PLAN_ID = "plan_id";
	public static final String QUERY_ORDER_ID = "order_id";
	public static final String QUERY_SYNC_STATUS = "sync_status";
	
	private long comboOrderId; //订单
	private long comboId; //套餐Id
	private LotteryType lotteryType; //彩种
	private String phase; //彩期
	private long uid; //用户ID
	private String username; //用户名
	private long planId; //
	private long orderId; //
	private String wallet;
	private double amount;//金额
	private double prize; //奖金
	private WalletType walletType;
	private long frozenId;
	private double frozenAmount;
	private ComboRecordSyncStatus syncStatus;
	
	
	@SuppressWarnings("unchecked")
	public static ComboOrderDetailRecord convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		ComboOrderDetailRecord comboOrderRecord = new ComboOrderDetailRecord();

		comboOrderRecord.amount = getDouble(object, "amount");
		comboOrderRecord.phase = getString(object, "phase");
		comboOrderRecord.prize = getDouble(object, "prize");
		comboOrderRecord.comboOrderId = getLong(object, "comboorder_id");
		comboOrderRecord.comboId = getLong(object, "combo_id");
		int lt = getInt(object, "lottery_type");
		comboOrderRecord.lotteryType = LotteryType.getItem(lt);
		comboOrderRecord.uid = getLong(object, "uid");
		comboOrderRecord.username = getString(object, "username");
		comboOrderRecord.planId = getLong(object, "plan_id");
		comboOrderRecord.orderId = getLong(object, "order_id");
		comboOrderRecord.wallet = getString(object, "wallet");
		comboOrderRecord.syncStatus = ComboRecordSyncStatus.getItem(getInt(object, "sync_status"));
		JSONObject json = JSONObject.fromObject(getString(object, "wallet"));
		for (Iterator iterator = json.keys(); iterator.hasNext();) {
			String key = (String)iterator.next();
			comboOrderRecord.walletType = WalletType.getItem(Integer.parseInt(key));
			comboOrderRecord.frozenId = getLong(JSONObject.fromObject(getString(json, key)), "frozen_id");
			comboOrderRecord.frozenAmount = getDouble(JSONObject.fromObject(getString(json, key)), "amount");
		}
		return comboOrderRecord;
	}
	
	@SuppressWarnings("unchecked")
	public static List<ComboOrderDetailRecord> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<ComboOrderDetailRecord> list = new ArrayList<ComboOrderDetailRecord>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public long getComboOrderId() {
		return comboOrderId;
	}

	public void setComboOrderId(long comboOrderId) {
		this.comboOrderId = comboOrderId;
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

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public long getPlanId() {
		return planId;
	}

	public void setPlanId(long planId) {
		this.planId = planId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getWallet() {
		return wallet;
	}

	public void setWallet(String wallet) {
		this.wallet = wallet;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPrize() {
		return prize;
	}

	public void setPrize(double prize) {
		this.prize = prize;
	}

	public long getComboId() {
		return comboId;
	}

	public void setComboId(long comboId) {
		this.comboId = comboId;
	}

	public WalletType getWalletType() {
		return walletType;
	}

	public void setWalletType(WalletType walletType) {
		this.walletType = walletType;
	}

	public long getFrozenId() {
		return frozenId;
	}

	public void setFrozenId(long frozenId) {
		this.frozenId = frozenId;
	}

	public double getFrozenAmount() {
		return frozenAmount;
	}

	public void setFrozenAmount(double frozenAmount) {
		this.frozenAmount = frozenAmount;
	}

	public ComboRecordSyncStatus getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(ComboRecordSyncStatus syncStatus) {
		this.syncStatus = syncStatus;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	

}
