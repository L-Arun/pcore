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
import com.lehecai.core.lottery.CreditType;
import com.lehecai.core.util.CoreDateUtils;

/**
 * @author qatang
 * 彩贝流水日志
 */
public class CreditLog extends AbstractApiResultBean {
	
	public static final String QUERY_TIMELINE = "create_at";
	public static final String QUERY_USERNAME = "username";
	public static final String QUERY_UID = "uid";
	public static final String QUERY_CREDIT_TYPE = "type";
	public static final String QUERY_LOG_ID = "id";
	
	public static final String ORDER_LOG_ID = "id";
	public static final String ORDER_TIMELINE = "timeline";
	
	private String id;			//流水ID
	private long uid;			//用户ID
	private String username;	//用户名
	
	private Date timeline;		//操作时间
	private long credits;		//此操作相关的彩贝数量
	private long balance;       //完成此操作后的彩贝余额
	
	private CreditType type;	//积分类型
	private String remark;      //备注
	
	private String data;		//相关数据
	
	public static CreditLog convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		CreditLog log = new CreditLog();
		log.id = getString(object, "id");
		log.uid = getLong(object, "uid");
		log.username = getString(object, "username");
		
		int iType = getInt(object, "type");
		if (iType >= 0) {
			log.type = CreditType.getItem(iType);
		}
		log.remark = getString(object, "remark");
		
		log.credits = getLong(object, "credits");
		log.balance = getLong(object, "total");
		
		log.timeline = CoreDateUtils.parseDate(getString(object, "create_at"), CoreDateUtils.DATETIME);
		
		log.data = getString(object, "data");
		
		return log;
	}
	
	@SuppressWarnings("unchecked")
	public static List<CreditLog> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<CreditLog> list = new ArrayList<CreditLog>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
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

	public CreditType getType() {
		return type;
	}

	public void setType(CreditType type) {
		this.type = type;
	}

	public long getCredits() {
		return credits;
	}

	public void setCredits(long credits) {
		this.credits = credits;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
