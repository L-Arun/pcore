package com.lehecai.core.api.openapi;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.YesNoStatus;
import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.util.CoreDateUtils;

public class OpenAPIApp extends AbstractApiResultBean {
	
	public static final String QUERY_APP_NAME = "app_name";
	public static final String QUERY_APP_OWNER = "app_owner";
	public static final String QUERY_SOURCE = "source";
	public static final String QUERY_STATUS = "status";
	public static final String QUERY_LEVEL = "level";
	public static final String QUERY_APP_KEY = "app_key";
	public static final String QUERY_APP_ID = "app_id";
	public static final String QUERY_NEWS_IS_WAP = "news_iswap";
	public static final String QUERY_APP_TYPE = "app_type";
	public static final String QUERY_TIME_ADD = "time_add";
	
	public static final String SET_APP_NAME = "app_name";
	public static final String SET_APP_DESC = "app_desc";
	public static final String SET_APP_VERSION = "app_version";
	public static final String SET_APP_OWNER = "app_owner";
	public static final String SET_SOURCE  ="source";
	public static final String SET_STATUS = "status";
	public static final String SET_LEVEL = "level";
	public static final String SET_NEWS_IS_WAP = "news_iswap";
	public static final String SET_UPDATE_POLICY = "update_policy";
	public static final String SET_UPDATE_LOG = "update_log";
	public static final String SET_APP_DOWNLOAD_URL = "download_url";
	public static final String SET_APP_TYPE = "app_type";
	
	public static final String ORDER_APP_ID = "app_id";
	public static final String ORDER_LEVEL = "level";
	public static final String ORDER_TIME_ADD = "time_add";
	public static final String ORDER_TIME_UPDATE = "time_update";
	
	private long appId;					//应用编号
	private long appKey;				//
	private String secret;				//
	private String appName;				//应用名称
	private String appDesc;				//应用描述
	private String appVersion;			//应用版本
	private OpenAPIAppStatus status;	//应用状态
	private long level;					//应用级别
	private long appOwner;				//应用拥有者
	private long source;				//来源
	private Date timeAdd;				//应用添加时间
	private Date timeUpdate;			//应用更新时间
	private YesNoStatus newsIsWap;		//新闻是否用wap浏览
	private OpenAPIAppUpdatePolicyStatus updatePolicy; //更新策略
	private String updateLog;			//更新日志
	private String downloadUrl;			//下载链接
	private OpenAPIAppType openAPIAppType;//应用类型
	
	public static OpenAPIApp convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		OpenAPIApp openAPIApp = new OpenAPIApp();
		
		openAPIApp.setAppId(getLong(object, "app_id"));
		openAPIApp.setAppKey(getLong(object, "app_key"));
		openAPIApp.setSecret(getString(object, "secret"));
		openAPIApp.setAppName(getString(object, "app_name"));
		openAPIApp.setAppDesc(getString(object, "app_desc"));
		openAPIApp.setAppVersion(getString(object, "app_version"));
		openAPIApp.setStatus(OpenAPIAppStatus.getItem(getInt(object, "status")));
		openAPIApp.setLevel(getLong(object, "level"));
		openAPIApp.setAppOwner(getLong(object, "app_owner"));
		openAPIApp.setSource(getLong(object, "source"));
		openAPIApp.setTimeAdd(CoreDateUtils.parseDate(getString(object, "time_add"), CoreDateUtils.DATETIME));
		openAPIApp.setTimeUpdate(CoreDateUtils.parseDate(getString(object, "time_update"), CoreDateUtils.DATETIME));
		openAPIApp.setNewsIsWap(YesNoStatus.getItem(getInt(object, "news_iswap")));
		int openAPIAppUpdateStatusValue = getInt(object, "update_policy");
		if (openAPIAppUpdateStatusValue != 0) {
			openAPIApp.setUpdatePolicy(OpenAPIAppUpdatePolicyStatus.getItem(openAPIAppUpdateStatusValue));
		}
		int openAPIAppTypeValue = getInt(object, "app_type");
		if (openAPIAppTypeValue != 0) {
			openAPIApp.setOpenAPIAppType(OpenAPIAppType.getItem(openAPIAppTypeValue));
		}
		openAPIApp.setUpdateLog(getString(object, "update_log"));
		openAPIApp.setDownloadUrl(getString(object, "download_url"));
		return openAPIApp;
	}
	
	public static List<OpenAPIApp> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<OpenAPIApp> list = new ArrayList<OpenAPIApp>();
		for (Iterator<?> iterator = array.iterator(); iterator.hasNext();) {
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
	public long getAppKey() {
		return appKey;
	}
	public void setAppKey(long appKey) {
		this.appKey = appKey;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppDesc() {
		return appDesc;
	}
	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}
	public String getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	public OpenAPIAppStatus getStatus() {
		return status;
	}
	public void setStatus(OpenAPIAppStatus status) {
		this.status = status;
	}
	public long getLevel() {
		return level;
	}
	public void setLevel(long level) {
		this.level = level;
	}
	public long getAppOwner() {
		return appOwner;
	}
	public void setAppOwner(long appOwner) {
		this.appOwner = appOwner;
	}
	public long getSource() {
		return source;
	}
	public void setSource(long source) {
		this.source = source;
	}
	public Date getTimeAdd() {
		return timeAdd;
	}
	public void setTimeAdd(Date timeAdd) {
		this.timeAdd = timeAdd;
	}
	public Date getTimeUpdate() {
		return timeUpdate;
	}
	public void setTimeUpdate(Date timeUpdate) {
		this.timeUpdate = timeUpdate;
	}

	public YesNoStatus getNewsIsWap() {
		return newsIsWap;
	}

	public void setNewsIsWap(YesNoStatus newsIsWap) {
		this.newsIsWap = newsIsWap;
	}

	public String getUpdateLog() {
		return updateLog;
	}

	public void setUpdateLog(String updateLog) {
		this.updateLog = updateLog;
	}

	public OpenAPIAppUpdatePolicyStatus getUpdatePolicy() {
		return updatePolicy;
	}

	public void setUpdatePolicy(OpenAPIAppUpdatePolicyStatus updatePolicy) {
		this.updatePolicy = updatePolicy;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public OpenAPIAppType getOpenAPIAppType() {
		return openAPIAppType;
	}

	public void setOpenAPIAppType(OpenAPIAppType openAPIAppType) {
		this.openAPIAppType = openAPIAppType;
	}
}
