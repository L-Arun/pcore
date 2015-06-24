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
import com.lehecai.core.lottery.WithIvrType;
import com.lehecai.core.lottery.WithWithdrawType;
import com.lehecai.core.util.CoreDateUtils;

public class UserBankCard extends AbstractApiResultBean {
	
	public static final String QUERY_UID = "uid";
	public static final String QUERY_ID = "id";

	public static final String SET_STATUS = "status";
	public static final String SET_BANK_TYPE = "bank_type";
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
	private YesNoStatus ivrStatus;//Ivr状态（1:激活，0:未激活）  
	private WithWithdrawType withWithdraw;//是否用于提款（0：未使用；1：已使用；2：优先使用)
	private WithIvrType withIvr;//是否用于IVR充值（0：未使用；1：已使用；2：已绑定）
	private YesNoStatus status; //状态
	private String bankBranch; //分行
	private Date lastUpdateTime;//最后更改时间
	private int province; //省id
	private String provinceName; //省name
	private int city; //市id
	private String cityName; //市name
	
	public static UserBankCard convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		UserBankCard bankcard = new UserBankCard();
		
		bankcard.bankBranch = getString(object, "bank_branch");
		bankcard.id = getLong(object, "id");
		bankcard.uid = getLong(object, "uid");
		bankcard.username = getString(object, "username");
		bankcard.bankId = getInt(object, "bank_id");
		int bankTypeValue = getInt(object, "bank_type");
		if (bankTypeValue != 0) {
			bankcard.bankType = BankType.getItem(bankTypeValue);
		}
		int ivrStatusValue = getInt(object, "ivr_status");
		bankcard.ivrStatus = YesNoStatus.getItem(ivrStatusValue);
		int withWithdrawValue = getInt(object, "with_withdraw");
		bankcard.withWithdraw = WithWithdrawType.getItem(withWithdrawValue);
		int withIvrValue = getInt(object, "with_ivr");
		bankcard.withIvr = WithIvrType.getItem(withIvrValue);
		bankcard.bankCardno = getString(object, "bank_cardno");
		bankcard.setBankAddTime(getDate(object, "bank_addtime", CoreDateUtils.DATETIME));
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
	public static List<UserBankCard> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<UserBankCard> list = new ArrayList<UserBankCard>();
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

	public YesNoStatus getIvrStatus() {
		return ivrStatus;
	}

	public void setIvrStatus(YesNoStatus ivrStatus) {
		this.ivrStatus = ivrStatus;
	}

	public WithWithdrawType getWithWithdraw() {
		return withWithdraw;
	}

	public void setWithWithdraw(WithWithdrawType withWithdraw) {
		this.withWithdraw = withWithdraw;
	}

	public WithIvrType getWithIvr() {
		return withIvr;
	}

	public void setWithIvr(WithIvrType withIvr) {
		this.withIvr = withIvr;
	}

}
