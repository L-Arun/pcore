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
import com.lehecai.core.lottery.ComboSelectType;
import com.lehecai.core.lottery.FinishComboStatus;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.util.CoreDateUtils;

/**
 * 套餐明细
 * @author leiming
 *
 */
public class ComboOrderDetail extends AbstractApiResultBean {
	
	public static final String QUERY_ID = "comboorder_id";
	public static final String QUERY_COMBO_ID = "combo_id";
	public static final String QUERY_UID = "uid";
	public static final String QUERY_CREATE_TIME = "create_at";
	public static final String QUERY_LOTTERY_TYPE = "lottery_type";
	public static final String QUERY_TYPE = "type";
	public static final String QUERY_STATUS = "status";
	public static final String QUERY_PHASE = "phase";
	
	public static final String ORDER_ID = "comboorder_id";
	public static final String ORDER_CREATED_TIME = "create_at";
	public static final String ORDER_AMOUNT = "amount";
	public static final String ORDER_PRIZE = "prize";
	
	private String comboOrderId; // 套餐编号
	private LotteryType lotteryType;
	private String comboId;
	private long uid;
	private String username;
	private Date createTime;  // 创建时间
	private double amount; 
	private double prize;  
	private int totalPhases;
	private int chasedPhases;
	private ComboSelectType comboSelectType; // 选号类型
	private int multiple;
	private String config;
	private String wallet;
	private String data;
	private String addition;
	private String number;
	private FinishComboStatus finishStatus; // 套餐完成状态
	

	public static ComboOrderDetail convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		ComboOrderDetail comboDetail = new ComboOrderDetail();
		
		comboDetail.comboOrderId = getString(object, "comboorder_id");
		comboDetail.setLotteryType(LotteryType.getItem(getInt(object, "lottery_type")));
		comboDetail.uid = getLong(object, "uid");
		comboDetail.comboId = getString(object, "combo_id");
		comboDetail.setCreateTime(CoreDateUtils.parseDate(getString(object, "create_at"), CoreDateUtils.DATETIME));
		comboDetail.setComboSelectType(ComboSelectType.getItem(getInt(object, "type")));
		comboDetail.amount = getDouble(object, "amount");
		comboDetail.prize = getDouble(object, "prize");
		comboDetail.username = getString(object, "username");
		comboDetail.totalPhases = getInt(object, "total_phases");
		comboDetail.chasedPhases = getInt(object, "chased_phases");
		comboDetail.multiple = getInt(object, "multiple");
		comboDetail.config = getString(object, "config");
		comboDetail.wallet = getString(object, "wallet");
		comboDetail.data = getString(JSONObject.fromObject(getString(object, "config")), "data");
		comboDetail.addition = getString(JSONObject.fromObject(getString(object, "config")), "addition");
		comboDetail.number = getString(JSONObject.fromObject(getString(object, "config")), "tickets");
		comboDetail.setFinishStatus(FinishComboStatus.getItem(getInt(object, "status")));
		
	
		
		
		return comboDetail;
	}
	
	@SuppressWarnings("unchecked")
	public static List<ComboOrderDetail> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<ComboOrderDetail> list = new ArrayList<ComboOrderDetail>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public String getComboOrderId() {
		return comboOrderId;
	}

	public void setComboOrderId(String comboOrderId) {
		this.comboOrderId = comboOrderId;
	}

	public LotteryType getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	public String getComboId() {
		return comboId;
	}

	public void setComboId(String comboId) {
		this.comboId = comboId;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public int getTotalPhases() {
		return totalPhases;
	}

	public void setTotalPhases(int totalPhases) {
		this.totalPhases = totalPhases;
	}

	public int getChasedPhases() {
		return chasedPhases;
	}

	public void setChasedPhases(int chasedPhases) {
		this.chasedPhases = chasedPhases;
	}

	public ComboSelectType getComboSelectType() {
		return comboSelectType;
	}

	public void setComboSelectType(ComboSelectType comboSelectType) {
		this.comboSelectType = comboSelectType;
	}

	public int getMultiple() {
		return multiple;
	}

	public void setMultiple(int multiple) {
		this.multiple = multiple;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public String getWallet() {
		return wallet;
	}

	public void setWallet(String wallet) {
		this.wallet = wallet;
	}

	public FinishComboStatus getFinishStatus() {
		return finishStatus;
	}

	public void setFinishStatus(FinishComboStatus finishStatus) {
		this.finishStatus = finishStatus;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getAddition() {
		return addition;
	}

	public void setAddition(String addition) {
		this.addition = addition;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	
}
