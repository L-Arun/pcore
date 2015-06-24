package com.lehecai.core.api.event;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.lottery.CouponStatus;
import com.lehecai.core.lottery.CouponType;
import com.lehecai.core.lottery.WalletType;
import com.lehecai.core.util.CoreDateUtils;

public class Coupon extends AbstractApiResultBean{
	
	public static final String QUERY_COUPON_ID = "cp_id";
	public static final String QUERY_UID = "uid";
	public static final String QUERY_EVENT_ID = "event_id";
	public static final String QUERY_TYPE = "type";
	public static final String QUERY_STATUS = "status";
		
	public static final String ORDER_CLAIM_TIME = "claim_at";
	public static final String ORDER_COUPON_ID = "cp_id";
	public static final String ORDER_EXPIRE_TIME = "expire_at";

	private Long cpId;              //充值券id 
	private String secret;			//明文密码 
	private CouponStatus status;	//充值券状态 
	private CouponType type;		//充值券类型 
	private Long uid;				//用户id
	private Integer eventId;		//事件id/活动id
	private Date createTime;		//创建时间 
	private Date expireTime;		//截止时间
	private Date claimTime;			//领取时间/使用时间
	private WalletType walletType;  //所属钱包类型
	private Double amount;			//金额
	private Integer checksum;
	
	public static Coupon convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		Coupon coupon = new Coupon();
		
		coupon.setCpId(getLong(object, "cp_id"));
		coupon.setEventId(getInt(object, "event_id"));
		coupon.setAmount(getDouble(object, "amount"));
		coupon.setChecksum(getInt(object, "checksum"));
		coupon.setClaimTime(CoreDateUtils.parseDate(getString(object, "claim_at"), CoreDateUtils.DATETIME));
		coupon.setCreateTime(CoreDateUtils.parseDate(getString(object, "create_at"), CoreDateUtils.DATETIME));
		coupon.setExpireTime(CoreDateUtils.parseDate(getString(object, "expire_at"), CoreDateUtils.DATETIME));
		coupon.setSecret(getString(object, "secret"));
		coupon.setStatus(CouponStatus.getItem(getInt(object, "status")));
		coupon.setType(CouponType.getItem(getInt(object, "type")));
		coupon.setUid(getLong(object, "uid"));
		coupon.setWalletType(WalletType.getItem(getInt(object, "wallet_type")));
	
		return coupon;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Coupon> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<Coupon> list = new ArrayList<Coupon>();
		for (Iterator iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}
	
	public Long getCpId() {
		return cpId;
	}
	public void setCpId(Long cpId) {
		this.cpId = cpId;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public CouponStatus getStatus() {
		return status;
	}
	public void setStatus(CouponStatus status) {
		this.status = status;
	}
	public CouponType getType() {
		return type;
	}
	public void setType(CouponType type) {
		this.type = type;
	}

	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	public Date getClaimTime() {
		return claimTime;
	}
	public void setClaimTime(Date claimTime) {
		this.claimTime = claimTime;
	}
	public WalletType getWalletType() {
		return walletType;
	}
	public void setWalletType(WalletType walletType) {
		this.walletType = walletType;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getChecksum() {
		return checksum;
	}
	public void setChecksum(Integer checksum) {
		this.checksum = checksum;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}            
	
}
