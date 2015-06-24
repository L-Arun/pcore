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

import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.OperationStatus;
import com.lehecai.core.lottery.OperationType;
import com.lehecai.core.util.CoreDateUtils;

/**
 * @author Sunshow
 * 操作流水日志
 */
public class OperationLog extends AbstractApiResultBean {
	
	public static final String QUERY_OPERATION_TYPE = "actionid";
	public static final String QUERY_STATUS = "status";
	public static final String QUERY_TIMELINE = "timeline";
	public static final String QUERY_USERNAME = "username";
	public static final String QUERY_UID = "uid";
	public static final String QUERY_SOURCE_ID = "source";
	public static final String QUERY_DISTINCT_USER = "distinct";
	
	public static final String ORDER_LOG_ID = "id";
	public static final String ORDER_TIMELINE = "timeline";
	
	private String suffix;		//月份后缀，日志按月归档，不允许跨月查询，格式必须为201009，不设置为查询当前月
	
	private String id;			//流水ID
	private long uid;			//用户ID
	private String username;	//用户名
	
	private Date timeline;		//操作时间
	
	private int sourceId;		//渠道来源id
	
	private OperationType operationType;	//操作类型
	
	private String ip;			//IP
	
	private String object;		//操作对象，预留
	private String extra;		//扩展信息
	
	private OperationStatus status;					//数据状态
	
	public static OperationLog convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		OperationLog log = new OperationLog();
		log.id = getString(object, "id");
		log.uid = getLong(object, "uid");
		log.username = getString(object, "username");
		
		int iType = getInt(object, "actionid");
		if (iType >= 0) {
			log.operationType = OperationType.getItem(iType);
		}
		
		log.sourceId = getInt(object, "source");
		
		log.ip = getString(object, "ip");
		
		log.object = getString(object, "object");
		log.extra = getString(object, "ext");
		
		int iStatus = getInt(object, "status");
		if (iStatus >= 0) {
			log.status = OperationStatus.getItem(iStatus);
		}
		
		log.timeline = CoreDateUtils.parseDate(getString(object, "timeline"), CoreDateUtils.DATETIME);
		
		return log;
	}
	
	@SuppressWarnings("unchecked")
	public static List<OperationLog> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<OperationLog> list = new ArrayList<OperationLog>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Date getTimeline() {
		return timeline;
	}

	public void setTimeline(Date timeline) {
		this.timeline = timeline;
	}

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public OperationStatus getStatus() {
		return status;
	}

	public void setStatus(OperationStatus status) {
		this.status = status;
	}
	
}
