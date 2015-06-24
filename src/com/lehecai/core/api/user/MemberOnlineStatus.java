/**
 * 
 */
package com.lehecai.core.api.user;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;

/**
 * 会员在线状态实体
 * @author yanweijie
 *
 */
public class MemberOnlineStatus extends AbstractApiResultBean {
	
	public static final String QUERY_UID = "uid";
	public static final String QUERY_KEY = "key";
	public static final String QUERY_TYPE = "type";
	
	 private String key;
	 private Long uid;				//会员编号
	 private String clientip;		//登陆IP
	 private Date timestamp;		//登录时间
	 private String sessionid;		//登陆sessionid
	 private MemberOnlineType type; //1表示web、wap登录，2表示手机客户端登录

	public static MemberOnlineStatus convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		MemberOnlineStatus member = new MemberOnlineStatus();

		member.key = getString(object, "key");
		member.uid = getLong(object, "uid");
		member.clientip = getString(object, "clientip");
		Calendar cd = Calendar.getInstance();
		cd.setTimeInMillis(getLong(object, "timestamp") * 1000);
		member.timestamp = cd.getTime();
		member.sessionid = getString(object, "sessionid");
		member.type = MemberOnlineType.getItem(getInt(object, "type"));
		
		return member;
	}
	
	@SuppressWarnings("unchecked")
	public static List<MemberOnlineStatus> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<MemberOnlineStatus> list = new ArrayList<MemberOnlineStatus>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getClientip() {
		return clientip;
	}

	public void setClientip(String clientip) {
		this.clientip = clientip;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public MemberOnlineType getType() {
		return type;
	}

	public void setType(MemberOnlineType type) {
		this.type = type;
	}
}
