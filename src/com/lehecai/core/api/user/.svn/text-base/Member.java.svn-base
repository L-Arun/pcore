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

import com.lehecai.core.YesNoStatus;
import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.IdType;
import com.lehecai.core.lottery.MemberStatus;
import com.lehecai.core.util.CoreDateUtils;

/**
 * @author Sunshow
 *
 */
public class Member extends AbstractApiResultBean {
	
	public static final String QUERY_UID = "uid";
	public static final String QUERY_USERNAME = "username";
	public static final String QUERY_EMAIL = "email";
	public static final String QUERY_RECHARGE_COUNT = "recharge_count";
	public static final String QUERY_PHONE = "phone";
	public static final String QUERY_REALNAME = "realname";
	public static final String QUERY_ID_DATA = "id_data";
	public static final String QUERY_REG_TIME = "reg_time";
	public static final String QUERY_SOURCE_ID = "source";
	public static final String QUERY_LAST_LOGIN_TIME = "last_login_time";
	public static final String QUERY_PHONE_CHECKED = "is_phone_checked";
	public static final String QUERY_EMAIL_CHECKED = "is_email_checked";
	
	public static final String ORDER_UID = "uid";
	public static final String ORDER_REG_TIME = "reg_time";
	
	public static final String SET_UID = "uid";
	public static final String SET_REALNAME = "realname";
	public static final String SET_EMAIL = "email";
	public static final String SET_PHONE = "phone";
	public static final String SET_ID_DATA = "id_data";
	public static final String SET_PASSWORD = "password";
	public static final String SET_STATUS = "status";
	public static final String SET_PHONE_CHECKED = "is_phone_checked";
	public static final String SET_EMAIL_CHECKED = "is_email_checked";
	
	private long uid;
	private int groupId;			//预留的组ID
	private String username;		//用户名
	private String realname;		//真实姓名
	
	private String lastLoginIp;		//最后登录IP
	private Date lastLoginTime;		//最后登录时间
	
	private String latestLoginIp;	//给用户看的上次登录IP
	private Date latestLoginTime;	//给用户看的上次登录时间
	
	private int sourceId;			//渠道来源id
	private String source;			//渠道来源名称
	
	private IdType idType;			//证件类型
	private String idData;			//证件号码
	
	private int rechargeCount;		//充值次数
	
	private MemberStatus status;	//会员状态
	private String phone;
	private String email;
	
	private String registerIp;		//注册IP
	private Date registerTime;		//注册时间
	
	private Date lastConsumeTime;	//最后消费时间
	private Date lastRechargeTime;	//最后充值时间
	
	private YesNoStatus phoneChecked;//是否已手机验证
	private YesNoStatus emailChecked;//是否已邮箱验证
	
	private List<Wallet> walletList;

	public static Member convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		Member member = new Member();

		member.uid = getLong(object, "uid");
		member.groupId = getInt(object, "groupid");
		member.username = getString(object, "username");
		member.realname = getString(object, "realname");
		member.lastLoginIp = getString(object, "last_login_ip");
		member.setLastLoginTime(getDate(object, "last_login_time", CoreDateUtils.DATETIME));
		member.latestLoginIp = getString(object, "latest_login_ip");
		member.setLatestLoginTime(getDate(object, "latest_login_time", CoreDateUtils.DATETIME));
		
		member.setIdType(IdType.getItem(getInt(object, "id_type")));
		member.idData = getString(object, "id_data");

		if (object.containsKey("recharge_count")) {
			member.rechargeCount = getInt(object, "recharge_count");
		}
		
		int iStatus = getInt(object, "status");
		if (iStatus >= 0) {
			member.status = MemberStatus.getItem(iStatus);
		}
		member.phone = getString(object, "phone");
		member.email = getString(object, "email");
		
		member.registerIp = getString(object, "reg_ip");
		member.setRegisterTime(getDate(object, "reg_time", CoreDateUtils.DATETIME));
		
		JSONObject sourceObj = getObject(object, "source");
		if (sourceObj != null) {
			member.sourceId = getInt(sourceObj, "id");
			member.source = getString(sourceObj, "name");
		}
		
		member.setLastConsumeTime(getDate(object, "last_consume_time", CoreDateUtils.DATETIME));
		member.setLastRechargeTime(getDate(object, "last_recharge_time", CoreDateUtils.DATETIME));
		
		int isPhoneChecked = getInt(object, "is_phone_checked");
		if (isPhoneChecked >= 0) {
			member.phoneChecked = YesNoStatus.getItem(isPhoneChecked);
		}
		int isEmailChecked = getInt(object, "is_email_checked");
		if (isEmailChecked >= 0) {
			member.emailChecked = YesNoStatus.getItem(isEmailChecked);
		}
		
		member.walletList = Wallet.convertFromJSONObjectMap(getObject(object, "wallet"));
		
		return member;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Member> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<Member> list = new ArrayList<Member>();
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

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public List<Wallet> getWalletList() {
		return walletList;
	}

	public void setWalletList(List<Wallet> walletList) {
		this.walletList = walletList;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getLatestLoginIp() {
		return latestLoginIp;
	}

	public void setLatestLoginIp(String latestLoginIp) {
		this.latestLoginIp = latestLoginIp;
	}

	public Date getLatestLoginTime() {
		return latestLoginTime;
	}

	public void setLatestLoginTime(Date latestLoginTime) {
		this.latestLoginTime = latestLoginTime;
	}

	public IdType getIdType() {
		return idType;
	}

	public void setIdType(IdType idType) {
		this.idType = idType;
	}

	public String getIdData() {
		return idData;
	}

	public void setIdData(String idData) {
		this.idData = idData;
	}

	public int getRechargeCount() {
		return rechargeCount;
	}

	public void setRechargeCount(int rechargeCount) {
		this.rechargeCount = rechargeCount;
	}

	public MemberStatus getStatus() {
		return status;
	}

	public void setStatus(MemberStatus status) {
		this.status = status;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegisterIp() {
		return registerIp;
	}

	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp;
	}

	public Date getLastConsumeTime() {
		return lastConsumeTime;
	}

	public void setLastConsumeTime(Date lastConsumeTime) {
		this.lastConsumeTime = lastConsumeTime;
	}

	public Date getLastRechargeTime() {
		return lastRechargeTime;
	}

	public void setLastRechargeTime(Date lastRechargeTime) {
		this.lastRechargeTime = lastRechargeTime;
	}

	public YesNoStatus getPhoneChecked() {
		return phoneChecked;
	}

	public void setPhoneChecked(YesNoStatus phoneChecked) {
		this.phoneChecked = phoneChecked;
	}

	public YesNoStatus getEmailChecked() {
		return emailChecked;
	}

	public void setEmailChecked(YesNoStatus emailChecked) {
		this.emailChecked = emailChecked;
	}
	
}
