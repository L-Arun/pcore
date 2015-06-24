/**
 * 
 */
package com.lehecai.core.api.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;

/**
 * @author qatang
 * 彩贝查询
 * 
 */
public class MemberCredit extends AbstractApiResultBean {
	
	public static final String QUERY_UID = "uid";
	public static final String QUERY_USERNAME = "username";
	
	public static final String SET_CREDITS = "credits";
	public static final String SET_REMARK = "remark";
	
	private long uid;
	private String username;		//用户名
	
	private double total;             //总彩贝
	private double consumed;          //已用彩贝
	private double balance;           //可用彩贝
	private int level;              //彩贝等级

	public static MemberCredit convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		MemberCredit memberCredit = new MemberCredit();

		memberCredit.uid = getLong(object, "uid");
		memberCredit.username = getString(object, "username");
		memberCredit.total = getDouble(object, "total");
		memberCredit.consumed = getDouble(object, "consumed");
		memberCredit.balance = getDouble(object, "balance");
		memberCredit.level = getInt(object, "level");
		
		return memberCredit;
	}
	
	@SuppressWarnings("unchecked")
	public static List<MemberCredit> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<MemberCredit> list = new ArrayList<MemberCredit>();
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getConsumed() {
		return consumed;
	}

	public void setConsumed(double consumed) {
		this.consumed = consumed;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
