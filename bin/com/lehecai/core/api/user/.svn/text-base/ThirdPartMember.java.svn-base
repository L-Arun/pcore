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
import com.lehecai.core.lottery.ThirdPartMemberType;
import com.lehecai.core.util.CoreDateUtils;

/**
 * @author Sunshow
 *
 */
public class ThirdPartMember extends AbstractApiResultBean {
	
	public static final String QUERY_UID = "uid";
	public static final String QUERY_RUSERNAME = "rusername";
	public static final String QUERY_RUID = "ruid";
	public static final String QUERY_TYPE = "type";
	
	public static final String ORDER_UID = "uid";
	public static final String ORDER_BIND_TIME = "bind_time";
	
	private long uid;			//本站uid
	private long ruid;			//外站uid
	private ThirdPartMemberType type;	//类型
	private String rusername;	//外站username
	private String username;	//本站username
	private Date bindTime;		//绑定时间
	private String ext;			
	private String token;
	

	public static ThirdPartMember convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		ThirdPartMember member = new ThirdPartMember();

		member.uid = getLong(object, "uid");
		member.ruid = getLong(object, "ruid");
		member.ext = getString(object, "ext");
		member.token = getString(object, "token");
		member.rusername = getString(object, "rusername");
		member.username = getString(object, "username");
		member.setType(ThirdPartMemberType.getItem(getInt(object, "type")));
		member.setBindTime(getDate(object, "bind_time", CoreDateUtils.DATETIME));
		
		return member;
	}
	
	@SuppressWarnings("unchecked")
	public static List<ThirdPartMember> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<ThirdPartMember> list = new ArrayList<ThirdPartMember>();
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

	public long getRuid() {
		return ruid;
	}

	public void setRuid(long ruid) {
		this.ruid = ruid;
	}

	public ThirdPartMemberType getType() {
		return type;
	}

	public void setType(ThirdPartMemberType type) {
		this.type = type;
	}

	public String getRusername() {
		return rusername;
	}

	public void setRusername(String rusername) {
		this.rusername = rusername;
	}

	public Date getBindTime() {
		return bindTime;
	}

	public void setBindTime(Date bindTime) {
		this.bindTime = bindTime;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
}
