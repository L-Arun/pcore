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
import com.lehecai.core.lottery.SyndicateStarStatus;

/**
 * @author yanweijie
 * 合买红人
 */
public class SyndicateStar extends AbstractApiResultBean {
	public static final String QUERY_UID = "uid";
	
	public static final String SET_UID = "uid";
	public static final String SET_PRIORITY = "priority";
	
	private long uid;						//用户ID
	private String username;				//用户名
	private SyndicateStarStatus status;		//状态
	private int priority;					//优先级
	
	
	public static SyndicateStar convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		SyndicateStar syndicateStar = new SyndicateStar();
		syndicateStar.uid = getLong(object, "uid");
		syndicateStar.username = getString(object, "username");
		syndicateStar.status = SyndicateStarStatus.getItem(getInt(object, "status"));
		syndicateStar.priority = getInt(object, "priority");
		
		return syndicateStar;
	}
	
	@SuppressWarnings("unchecked")
	public static List<SyndicateStar> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<SyndicateStar> list = new ArrayList<SyndicateStar>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
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

	public SyndicateStarStatus getStatus() {
		return status;
	}

	public void setStatus(SyndicateStarStatus status) {
		this.status = status;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
}
