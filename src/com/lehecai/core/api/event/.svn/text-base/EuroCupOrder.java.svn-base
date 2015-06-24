/**
 * 
 */
package com.lehecai.core.api.event;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.event.EuroCupOrderStatus;
import com.lehecai.core.event.EuroCupType;
import com.lehecai.core.util.CoreDateUtils;

/**
 * 欧洲杯比赛信息
 * @author chirowong
 *
 */
public class EuroCupOrder extends AbstractApiResultBean {
	public static final String QUERY_ORDER_ID = "order_id";
	public static final String QUERY_USER_ID = "uid";
	public static final String QUERY_TYPE = "type";
	public static final String QUERY_PRIZE_STATUS = "prize_status";
	public static final String QUERY_CREATE_TIME = "create_at";
	
	public static final String ORDER_ORDER_ID = "order_id";
	public static final String ORDER_CREATE_TIME = "create_at";
	
	private Long orderId;//订单ID
	private Long userId ;//用户编码
	private String userName ;//用户编码
	private String content;//订单内容
	private Date createTime;//创建时间
	private EuroCupType type;//竞猜类型 [1：单场竞猜胜负平；2：八强竞猜；3:四强竞猜；4：冠军竞猜；5：单场竞猜比分]
	private Double amount;//订单金额
	private Integer multiple;//订单倍数
	private EuroCupOrderStatus prizeStatus;//开奖状态
	private Double prizeAmount;//中奖金额
	private Date prizeTime;//开奖时间
	
	public static EuroCupOrder convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		EuroCupOrder euroCupOrder = new EuroCupOrder();
		euroCupOrder.setOrderId(getLong(object, "order_id"));
		euroCupOrder.setUserId(getLong(object, "uid"));
		euroCupOrder.setUserName(getString(object, "username"));
		euroCupOrder.setContent(getString(object, "content"));
		euroCupOrder.setCreateTime(getDate(object, "create_at", CoreDateUtils.DATETIME));
		euroCupOrder.setType(EuroCupType.getItem(getInt(object, "type")));
		euroCupOrder.setAmount(getDouble(object, "amount"));
		euroCupOrder.setMultiple(getInt(object, "multiple"));
		euroCupOrder.setPrizeStatus(EuroCupOrderStatus.getItem(getInt(object, "prize_status")));
		euroCupOrder.setPrizeAmount(getDouble(object,"prize_amount"));
		euroCupOrder.setPrizeTime(getDate(object,"prize_time", CoreDateUtils.DATETIME));
		return euroCupOrder;
	}
	
	public static List<EuroCupOrder> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<EuroCupOrder> list = new ArrayList<EuroCupOrder>();
		for (Iterator<?> iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public EuroCupType getType() {
		return type;
	}

	public void setType(EuroCupType type) {
		this.type = type;
	}

	public EuroCupOrderStatus getPrizeStatus() {
		return prizeStatus;
	}

	public void setPrizeStatus(EuroCupOrderStatus prizeStatus) {
		this.prizeStatus = prizeStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getMultiple() {
		return multiple;
	}

	public void setMultiple(Integer multiple) {
		this.multiple = multiple;
	}

	public Double getPrizeAmount() {
		return prizeAmount;
	}

	public void setPrizeAmount(Double prizeAmount) {
		this.prizeAmount = prizeAmount;
	}

	public Date getPrizeTime() {
		return prizeTime;
	}

	public void setPrizeTime(Date prizeTime) {
		this.prizeTime = prizeTime;
	}
}
