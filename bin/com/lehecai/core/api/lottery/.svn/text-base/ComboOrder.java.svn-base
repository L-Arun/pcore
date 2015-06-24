package com.lehecai.core.api.lottery;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.FinishComboStatus;
import com.lehecai.core.lottery.FinishComboType;
import com.lehecai.core.util.CoreDateUtils;

public class ComboOrder extends AbstractApiResultBean {
	
	public static final String QUERY_COMBO_ORDER_ID = "comboorder_id";
	public static final String QUERY_COMBO_ID = "combo_id";
	public static final String QUERY_COMBOREV_ID = "comborev_id";
	public static final String QUERY_UID = "uid";
	public static final String QUERY_STATUS = "status";
	
	public static final String SET_CANCELBELOWAMOUNT = "cancel_belowamount";
	
	public static final String ORDER_COMBO_ORDER_ID = "comboorder_id";
	
	private long comboOrderId; //套餐订单ID
	private int comborevId; //套餐版本
	private String comboId; //套餐ID
	private String comboName; //套餐名
	private long uid; //用户ID
	private String username; //用户名
	private Date createAt; //创建时间
	private double amount;//金额
	private double prize;//中奖额
	private FinishComboStatus status; //状态
	private FinishComboType finishType;
	private String finishConfig;
	private ComboFinishConfig comboFinishConfig;
	
	
	public static ComboOrder convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		ComboOrder comboOrder = new ComboOrder();
		
		comboOrder.comboOrderId = getLong(object, "comboorder_id");
		comboOrder.comborevId = getInt(object, "comborev_id");
		comboOrder.uid = getLong(object, "uid");
		comboOrder.comboId = getString(object, "combo_id");
		comboOrder.amount = getDouble(object, "amount");
		comboOrder.setCreateAt(getDate(object, "create_at", CoreDateUtils.DATETIME));
		comboOrder.username = getString(object, "username");
		comboOrder.prize = getDouble(object, "prize");
		int statusValue = getInt(object, "status");
		comboOrder.status = FinishComboStatus.getItem(statusValue);
		int finishComboValue = getInt(object, "finish_type");
		comboOrder.finishType = FinishComboType.getItem(finishComboValue);
		comboOrder.comboName = getString(object, "combo_name");
		comboOrder.finishConfig = getString(object, "finish_config");
		comboOrder.comboFinishConfig = ComboFinishConfig.convertFromJSONObject(JSONObject.fromObject(getString(object, "finish_config")));
		return comboOrder;
	}
	
	@SuppressWarnings("unchecked")
	public static List<ComboOrder> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<ComboOrder> list = new ArrayList<ComboOrder>();
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

	public int getComborevId() {
		return comborevId;
	}

	public void setComborevId(int comborevId) {
		this.comborevId = comborevId;
	}

	public String getComboId() {
		return comboId;
	}

	public void setComboId(String comboId) {
		this.comboId = comboId;
	}

	public String getComboName() {
		return comboName;
	}

	public void setComboName(String comboName) {
		this.comboName = comboName;
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

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
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

	public FinishComboStatus getStatus() {
		return status;
	}

	public void setStatus(FinishComboStatus status) {
		this.status = status;
	}

	public String getFinishConfig() {
		return finishConfig;
	}

	public void setFinishConfig(String finishConfig) {
		this.finishConfig = finishConfig;
	}

	public FinishComboType getFinishType() {
		return finishType;
	}

	public void setFinishType(FinishComboType finishType) {
		this.finishType = finishType;
	}

	public ComboFinishConfig getComboFinishConfig() {
		return comboFinishConfig;
	}

	public void setComboFinishConfig(ComboFinishConfig comboFinishConfig) {
		this.comboFinishConfig = comboFinishConfig;
	}

}
