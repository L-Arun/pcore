/**
 * 
 */
package com.lehecai.core.api.event;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;

/**
 * 欧洲杯聊天室禁言用户
 * @author chirowong
 *
 */
public class EuroCupChat extends AbstractApiResultBean {
	public static final String QUERY_UID = "uid";
	public static final String QUERY_USERNAME = "username";
	
	public static final String SET_UID = "uid";
	
	private Long userId;//用户编码
	private String userName;//用户名
	
	public static EuroCupChat convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		EuroCupChat euroCupChat = new EuroCupChat();
		euroCupChat.setUserId(getLong(object, "uid"));
		euroCupChat.setUserName(getString(object, "username"));
		return euroCupChat;
	}
	
	public static List<EuroCupChat> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<EuroCupChat> list = new ArrayList<EuroCupChat>();
		for (Iterator<?> iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
