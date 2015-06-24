package com.lehecai.core.api.openapi;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.util.CoreDateUtils;

public class OpenAPIAppVersionLog extends AbstractApiResultBean {
	
	public static final String QUERY_APP_ID = "app_id";
	
	public static final String ORDER_APP_ID = "app_id";
	public static final String ORDER_TIME_ADD = "time_add";
	
	private long appId;					//应用编号
	private String appVersion;			
	private String updateLog;			
	private Date timeAdd;				
	
	public static OpenAPIAppVersionLog convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		OpenAPIAppVersionLog openAPIApp = new OpenAPIAppVersionLog();
		
		openAPIApp.setAppId(getLong(object, "app_id"));
		openAPIApp.setAppVersion(getString(object, "app_version"));
		openAPIApp.setUpdateLog(getString(object, "update_log"));
		openAPIApp.setTimeAdd(CoreDateUtils.parseDate(getString(object, "time_add"), CoreDateUtils.DATETIME));
		
		return openAPIApp;
	}
	
	@SuppressWarnings("unchecked")
	public static List<OpenAPIAppVersionLog> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<OpenAPIAppVersionLog> list = new ArrayList<OpenAPIAppVersionLog>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public long getAppId() {
		return appId;
	}

	public void setAppId(long appId) {
		this.appId = appId;
	}

	public String getUpdateLog() {
		return updateLog;
	}

	public void setUpdateLog(String updateLog) {
		this.updateLog = updateLog;
	}

	public Date getTimeAdd() {
		return timeAdd;
	}

	public void setTimeAdd(Date timeAdd) {
		this.timeAdd = timeAdd;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	
}
