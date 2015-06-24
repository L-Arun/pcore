package com.lehecai.core.api;

import net.sf.json.JSONObject;

public class ApiRequestOrder {
	private String field;
	private String order;
	
	public ApiRequestOrder(String field, String order) {
		this.field = field;
		this.order = order;
	}
	
	public String getField() {
		return field;
	}

	public String getOrder() {
		return order;
	}

	public JSONObject toJSONObject() {
		JSONObject json = new JSONObject();
		
		json.put(ApiConstant.API_REQUEST_ORDER_FIELD_NAME, this.field);
		json.put(ApiConstant.API_REQUEST_ORDER_ORDER_NAME, this.order);
		
		return json;
	}
}
