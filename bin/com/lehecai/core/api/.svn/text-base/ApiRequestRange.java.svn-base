package com.lehecai.core.api;

import net.sf.json.JSONObject;

public class ApiRequestRange {

	private String begin;
	private String end;
	
	public ApiRequestRange(String begin, String end) {
		this.begin = begin;
		this.end = end;
	}
	
	public JSONObject toJSONObject() {
		JSONObject json = new JSONObject();
		
		if (this.begin != null) {
			json.put(ApiConstant.API_REQUEST_RANGE_BEGIN_NAME, this.begin);
		}
		
		if (this.end != null) {
			json.put(ApiConstant.API_REQUEST_RANGE_END_NAME, this.end);
		}
		
		return json;
	}

	public String getBegin() {
		return begin;
	}

	public String getEnd() {
		return end;
	}
}
