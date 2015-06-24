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

import com.lehecai.core.YesNoStatus;
import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.BankCardType;
import com.lehecai.core.lottery.BankType;
import com.lehecai.core.util.CoreDateUtils;

/**
 * @author yanweijie
 *
 */
public class IvrRecord extends AbstractApiResultBean {
	
	public static final String QUERY_UID = "uid";
	public static final String QUERY_CARDNO = "cardno";
	
	public static final String SET_BANK_TYPE = "bank_type";
	
	private long uid;				//用户编码
	private String cardno;			//银行卡号
	private BankCardType cardType;	//卡类型
	private BankType bankType;		//银行类型
	private String bankArea;		//开户行地址
	private double recharged;		//历史充值金额
	private Date createAt;			//创建时间
	private Date lastUsed;			//最后使用时间
	private YesNoStatus lockStatus;	//绑定状态

	public static IvrRecord convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		IvrRecord record = new IvrRecord();

		record.uid = getLong(object, "uid");
		record.cardno = getString(object, "cardno");
		record.cardType = BankCardType.getItem(getInt(object, "type"));
		record.bankType = BankType.getItem(getInt(object, "bank_type"));
		record.bankArea = getString(object, "bank_area");
		record.recharged = getDouble(object, "recharged");
		record.setCreateAt(getDate(object, "create_at", CoreDateUtils.DATETIME));
		record.setLastUsed(getDate(object, "last_used", CoreDateUtils.DATETIME));
		record.lockStatus = YesNoStatus.getItem(getInt(object, "default"));
		
		return record;
	}
	
	@SuppressWarnings("unchecked")
	public static List<IvrRecord> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<IvrRecord> list = new ArrayList<IvrRecord>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public BankCardType getCardType() {
		return cardType;
	}

	public void setCardType(BankCardType cardType) {
		this.cardType = cardType;
	}

	public BankType getBankType() {
		return bankType;
	}

	public void setBankType(BankType bankType) {
		this.bankType = bankType;
	}

	public String getBankArea() {
		return bankArea;
	}

	public void setBankArea(String bankArea) {
		this.bankArea = bankArea;
	}

	public double getRecharged() {
		return recharged;
	}

	public void setRecharged(double recharged) {
		this.recharged = recharged;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getLastUsed() {
		return lastUsed;
	}

	public void setLastUsed(Date lastUsed) {
		this.lastUsed = lastUsed;
	}

	public YesNoStatus getLockStatus() {
		return lockStatus;
	}

	public void setLockStatus(YesNoStatus lockStatus) {
		this.lockStatus = lockStatus;
	}
}