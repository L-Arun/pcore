/**
 * 
 */
package com.lehecai.core.api.user;

import java.util.Iterator;

import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;

/**
 * @author Sunshow
 *
 */
public class MemberBasic extends AbstractApiResultBean {
	
	public static final String QUERY_UID = "uid";
	public static final String QUERY_USERNAME = "username";
	
	private long uid;
	private String username;		//用户名

	@SuppressWarnings("unchecked")
	public static MemberBasic convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		MemberBasic member = new MemberBasic();
		for (Iterator iterator = object.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			member.uid = Long.valueOf(key);
			member.username = object.getString(key);
			break;
		}

		return member;
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
}
