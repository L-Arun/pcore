package com.lehecai.core.api.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.YesNoStatus;
import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.BankType;
import com.lehecai.core.util.CoreDateUtils;

public class BankCard extends AbstractApiResultBean {
	
	public static final String QUERY_UID = "uid";
	public static final String QUERY_ID = "id";

	public static final String SET_STATUS = "status";
	public static final String SET_BANK_CARD_NO = "bank_cardno";
	public static final String SET_BANK_BRANCH = "bank_branch";
	public static final String SET_PROVINCE = "province";
	public static final String SET_CITY = "city";
	public static final String SET_BANK_ID = "bank_id";

	public static final String ORDER_UPDATE_TIME = "last_update_time";
	
	private long id; //ID
	private long uid; //用户ID
	private String username; //用户名
	private int bankId; //银行ID
	private BankType bankType; //银行类型
	private String bankCardno; //银行卡号
	private Date bankAddTime; //添加时间
	private int bank_addsrc;
	private YesNoStatus status; //状态
	private String bankBranch; //分行
	private Date lastUpdateTime;//最后更改时间
	private int province; //省id
	private String provinceName; //省name
	private int city; //市id
	private String cityName; //市name
	
	public static BankCard convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		BankCard bankcard = new BankCard();
		
		bankcard.bankBranch = getString(object, "bank_branch");
		bankcard.id = getLong(object, "id");
		bankcard.uid = getLong(object, "uid");
		bankcard.username = getString(object, "username");
		bankcard.bankId = getInt(object, "bank_id");
		int bankTypeValue = getInt(object, "bank_id");
		if (bankTypeValue != 0) {
			bankcard.bankType = BankType.getItem(bankTypeValue);
		}
		bankcard.bankCardno = getString(object, "bank_cardno");
		bankcard.setBankAddTime(getDate(object, "bank_addtime", CoreDateUtils.DATETIME));
		bankcard.bank_addsrc = getInt(object, "bank_addsrc");
		int statusValue = getInt(object, "status");
		bankcard.status = YesNoStatus.getItem(statusValue);
		bankcard.setLastUpdateTime(getDate(object, "last_update_time", CoreDateUtils.DATETIME));
		bankcard.province = getInt(object, "province");
		bankcard.city = getInt(object, "city");
		bankcard.provinceName = getString(object, "province_name");
		bankcard.cityName = getString(object, "city_name");
		
		return bankcard;
	}
	
	@SuppressWarnings("unchecked")
	public static List<BankCard> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<BankCard> list = new ArrayList<BankCard>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public BankType getBankType() {
		return bankType;
	}

	public void setBankType(BankType bankType) {
		this.bankType = bankType;
	}

	public String getBankCardno() {
		return bankCardno;
	}

	public void setBankCardno(String bankCardno) {
		this.bankCardno = bankCardno;
	}

	public Date getBankAddTime() {
		return bankAddTime;
	}

	public void setBankAddTime(Date bankAddTime) {
		this.bankAddTime = bankAddTime;
	}

	public int getBank_addsrc() {
		return bank_addsrc;
	}

	public void setBank_addsrc(int bankAddsrc) {
		bank_addsrc = bankAddsrc;
	}

	public YesNoStatus getStatus() {
		return status;
	}

	public void setStatus(YesNoStatus status) {
		this.status = status;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public int getProvince() {
		return province;
	}

	public void setProvince(int province) {
		this.province = province;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
