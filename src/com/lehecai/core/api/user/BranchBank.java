package com.lehecai.core.api.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.EnabledStatus;
import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.BankType;

public class BranchBank extends AbstractApiResultBean {

	private static final long serialVersionUID = 1L;
	
	public static final String QUERY_BANK_ID = "bank_id";
	
	private String bankId;
	private String province;
	private String city;
	private BankType bankType;
	private String bankname;
	private String branchname;
	private EnabledStatus status;
	private String nameProvince;
	private String nameCity;
	private String nameBankType;
	
	public static BranchBank convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		BranchBank bank = new BranchBank();
		bank.bankId = getString(object, "bank_id");
		bank.province = getString(object, "province");
		bank.city = getString(object, "city");
		int iBankType = getInt(object, "bank_type");
		if (iBankType >= 0) {
			bank.bankType = BankType.getItem(iBankType);
		}
		bank.bankname = getString(object, "bankname");
		bank.branchname = getString(object, "branchname");
		int iBankStatus = getInt(object, "status");
		if (iBankStatus >= 0) {
			bank.status = EnabledStatus.getItem(iBankStatus);
		}
		bank.nameProvince = getString(object, "w_province");
		bank.nameCity = getString(object, "w_city");
		bank.nameBankType = getString(object, "w_bank_type");
		
		return bank;
	}
	
	@SuppressWarnings("unchecked")
	public static List<BranchBank> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<BranchBank> list = new ArrayList<BranchBank>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			Set<String> set = object.keySet();
			for (Iterator i = set.iterator(); i.hasNext();) {
				JSONObject json = JSONObject.fromObject(object.get(i.next()));
				list.add(convertFromJSONObject(json));
			}
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static List<BranchBank> convertFromJSONObjectMap(JSONObject objectMap) {
		if (objectMap == null) {
			return null;
		}
		List<BranchBank> list = new ArrayList<BranchBank>();
		for (Iterator iterator = objectMap.keys(); iterator.hasNext();) {
			JSONObject object = (JSONObject) objectMap.get(iterator.next());
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public BankType getBankType() {
		return bankType;
	}

	public void setBankType(BankType bankType) {
		this.bankType = bankType;
	}

	public String getNameProvince() {
		return nameProvince;
	}

	public void setNameProvince(String nameProvince) {
		this.nameProvince = nameProvince;
	}

	public String getNameCity() {
		return nameCity;
	}

	public void setNameCity(String nameCity) {
		this.nameCity = nameCity;
	}

	public String getNameBankType() {
		return nameBankType;
	}

	public void setNameBankType(String nameBankType) {
		this.nameBankType = nameBankType;
	}

	public EnabledStatus getStatus() {
		return status;
	}

	public void setStatus(EnabledStatus status) {
		this.status = status;
	}

}
