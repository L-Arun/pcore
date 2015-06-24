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
import com.lehecai.core.lottery.SourceStatus;

/**
 * @author Sunshow
 * 渠道来源
 */
public class Source extends AbstractApiResultBean {
	
	public static final String QUERY_ID = "id";
	public static final String QUERY_PARTNER_ID = "partner_id";
	public static final String QUERY_NAME = "name";
	public static final String QUERY_STATUS = "status";
	
	public static final String SET_ID = "id";
	public static final String SET_PARTNER_ID = "partner_id";
	public static final String SET_NAME = "name";
	public static final String SET_STATUS = "status";
	
	private Integer id;					//ID
	private String name;			//渠道名称
	private Integer partnerId; 		//渠道合作商ID
	private SourceStatus status;	//来源状态

	public static String getSourceDisplayName(int sourceId) {
		if (sourceId / 1000 == 5) {
			return "百度乐和彩";
		}
		if (sourceId / 1000 == 9) {
			return "虎扑彩票";
		}
		if (sourceId == 4017) {
			return "赶集乐和彩";
		}
		if (sourceId == 4018) {
			return "彩宝贝";
		}
		if (sourceId == 4012) {
			return "中华网彩票";
		}
		if (sourceId >= 6789 && sourceId <= 6791) {
			return "搜狐彩票";
		}
		if (sourceId >= 4028 && sourceId <= 4035) {
			return "暴风彩票";
		}
		return "乐和彩";
	}
	
	public static Source convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		Source source = new Source();
		source.id = getInt(object, "id");
		source.name = getString(object, "name");
		source.partnerId = getInt(object, "partner_id");
		int iStatus = getInt(object, "status");
		if (iStatus >= 0) {
			source.status = SourceStatus.getItem(iStatus);
		}
		
		return source;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Source> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<Source> list = new ArrayList<Source>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	public SourceStatus getStatus() {
		return status;
	}

	public void setStatus(SourceStatus status) {
		this.status = status;
	}
}
