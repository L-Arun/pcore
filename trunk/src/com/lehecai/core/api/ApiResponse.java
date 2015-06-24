/**
 * 
 */
package com.lehecai.core.api;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author Sunshow
 *
 */
public class ApiResponse {
	/* API执行结果 */
	private int code;
	
	/* 执行结果信息 */
	private String message;
	
	/* 远程脚本执行时间，仅在调试模式时有此返回值，单位：s */
	private double debugTime;
	
	private JSONArray data;
	
	/* 满足条件的记录总数 */
	private int total;
	
	/* 满足条件的搜索结果总数 */
	private int foundTotal;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getDebugTime() {
		return debugTime;
	}

	public void setDebugTime(double debugTime) {
		this.debugTime = debugTime;
	}

	public JSONArray getData() {
		return data;
	}

	public void setData(JSONArray data) {
		this.data = data;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getFoundTotal() {
		return foundTotal;
	}

	public void setFoundTotal(int foundTotal) {
		this.foundTotal = foundTotal;
	}
	
	public JSONObject toJSONObject() {
		JSONObject object = new JSONObject();
		object.put(ApiConstant.API_RESPONSE_CODE_NAME, this.getCode());
		object.put(ApiConstant.API_RESPONSE_MESSAGE_NAME, this.getMessage());
		object.put(ApiConstant.API_RESPONSE_TOTAL_NAME, this.getTotal());
		object.put(ApiConstant.API_RESPONSE_DATA_NAME, this.getData());
		object.put(ApiConstant.API_RESPONSE_DEBUGTIME_NAME, this.getDebugTime());
		return object;
	}
}
