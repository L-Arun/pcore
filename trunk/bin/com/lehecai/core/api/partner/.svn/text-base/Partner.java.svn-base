/**
 * 
 */
package com.lehecai.core.api.partner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;

/**
 * @author CuiShuai
 * 渠道合作商
 */
public class Partner extends AbstractApiResultBean {
	
	public static final String QUERY_PARTNER_ID = "partner_id";
	public static final String QUERY_PARTNER_NAME = "partner_name";
	
	public static final String SET_PARTNER_ID = "partner_id";
	public static final String SET_PARTNER_NAME = "partner_name";
	public static final String SET_PASSWORD = "password";
	public static final String SET_DEFAULT_REBATE = "default_rebate";
	
	private Integer partnerId;		//渠道id
	private String partnerName;		//渠道名称
	private String password;		//密码
	private Double defaultRebate;	//默认的回扣率
	
	public static Partner convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		Partner partner = new Partner();
		
		partner.partnerId = getInt(object, "partner_id");
		partner.partnerName = getString(object, "partner_name");
		partner.password = getString(object, "password");
		partner.defaultRebate = getDouble(object, "default_rebate");
		
		return partner;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Partner> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<Partner> list = new ArrayList<Partner>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public Integer getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getDefaultRebate() {
		return defaultRebate;
	}

	public void setDefaultRebate(Double defaultRebate) {
		this.defaultRebate = defaultRebate;
	}

	public void clear() {
		partnerId = null;		//渠道id
		partnerName = null;		//渠道名称
		password = null;		//密码
		defaultRebate = null;	//默认的回扣率
	}
	
}
