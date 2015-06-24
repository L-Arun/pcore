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
import com.lehecai.core.util.CoreDateUtils;

/**
 * @author chirowong
 * 彩贝兑入实体类
 */
public class CreditExchangeLogIn extends AbstractApiResultBean {
	public static final String QUERY_ID = "id";
	public static final String QUERY_UID = "uid";
	public static final String QUERY_PARTNERID = "partner_id";
	public static final String QUERY_PARTNERTRADENO = "partner_trade_no";
	public static final String QUERY_STATUS = "status";
	public static final String QUERY_CREATETIME = "create_at";
	
	public static final String ORDER_ID = "id";
	public static final String ORDER_CREATETIME = "create_at";
	
	private String id;//订单号
	private long uid;
	private int partnerId;//合作商id
	private String partnerTradeNo;//合作商订单号
	private int myAmount;//兑入的彩贝
	private Date createTime;//发起交易时间
	private YesNoStatus status;//[0:失败，1:成功]
	private Date successTime;//交易成功时间
	private String ip;//请求的IP

	
	public static CreditExchangeLogIn convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		CreditExchangeLogIn log = new CreditExchangeLogIn();
		log.id = getString(object, "id");
		log.uid = getLong(object, "uid");
		log.partnerId = getInt(object,"partner_id");
		log.partnerTradeNo = getString(object,"partner_trade_no");
		log.myAmount = getInt(object,"my_amount");
		log.createTime = getDate(object, "create_at", CoreDateUtils.DATETIME);
		log.setStatus(YesNoStatus.getItem(getInt(object,"status")));
		log.successTime = getDate(object, "success_at", CoreDateUtils.DATETIME);
		log.ip = getString(object,"ip");
		return log;
	}
	
	@SuppressWarnings("unchecked")
	public static List<CreditExchangeLogIn> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<CreditExchangeLogIn> list = new ArrayList<CreditExchangeLogIn>();
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
	
	public YesNoStatus getStatus() {
		if(status == null){
			status = YesNoStatus.YES;
		}
		return status;
	}
	public void setStatus(YesNoStatus status) {
		this.status = status;
	}

	public int getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
	}

	public String getPartnerTradeNo() {
		return partnerTradeNo;
	}

	public void setPartnerTradeNo(String partnerTradeNo) {
		this.partnerTradeNo = partnerTradeNo;
	}

	public int getMyAmount() {
		return myAmount;
	}

	public void setMyAmount(int myAmount) {
		this.myAmount = myAmount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getSuccessTime() {
		return successTime;
	}

	public void setSuccessTime(Date successTime) {
		this.successTime = successTime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
