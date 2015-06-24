package com.lehecai.core.api;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ApiRequestWhere {
	private String key;
	private String value;
	private String operator;
	private List<String> values;

	public ApiRequestWhere(String key, String value, String operator) {
		this.key = key;
		this.value = value;
		this.operator = operator;
	}
	
	public ApiRequestWhere(String key, String value) {
		this(key, value, ApiConstant.API_OP_EQUAL);
	}
	
	public ApiRequestWhere(String key, List<String> values) {
		this.key = key;
		this.values = values;
		this.operator = ApiConstant.API_OP_IN;
	}

	public JSONObject toJSONObject() {
		JSONObject json = new JSONObject();
		json.put(ApiConstant.API_REQUEST_KEY_NAME, this.key);
		json.put(ApiConstant.API_REQUEST_OPERATOR_NAME, this.operator);
		
		if (this.values != null) {
			json.put(ApiConstant.API_REQUEST_VALUE_NAME, JSONArray.fromObject(this.values)); 
		} else {
			if (this.value != null) {
				json.put(ApiConstant.API_REQUEST_VALUE_NAME, this.value);
			}
		}
		
		return json;
	}
}
