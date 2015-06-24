/**
 * 
 */
package com.lehecai.core.api.game;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lehecai.core.api.AbstractApiResultBean;
import com.lehecai.core.game.GameOrderStatus;
import com.lehecai.core.game.GameRechargeType;
import com.lehecai.core.util.CoreDateUtils;

/**
 * @author chirowong
 *
 */
public class GameOrder extends AbstractApiResultBean {
	public static final String QUERY_ORDER_ID = "g_order_id";
	public static final String QUERY_USER_NAME = "username";
	public static final String QUERY_GAME_ID = "game_id";
	public static final String QUERY_ORDER_STATUS = "g_order_status";
	public static final String QUERY_SOURCE = "source";
	public static final String QUERY_RECHARGE_TYPE = "g_order_type";
	public static final String QUERY_CREATETIME = "g_order_create_at";
	
	public static final String ORDER_ID = "g_order_id";
	public static final String ORDER_CREATETIME = "g_order_create_at";
	public static final String ORDER_AMOUNT = "g_order_amount";
	
	private String orderId;
	private Long userId;
	private String userName;
	private Integer gameId;
	private Integer source; //来源
	private GameOrderStatus gameOrderStatus;
	private GameRechargeType gameRechargeType;
	private Date createTime;//创建时间
	private Double amount;
	private Double gameAmount;
	private Date gameRechargeTime;//充值成功时间
	
	public static GameOrder convertFromJSONObject(JSONObject object) {
		if (object == null) {
			return null;
		}
		GameOrder order = new GameOrder();
		order.orderId = getString(object, "g_order_id");
		order.userName = getString(object, "username");
		order.userId = getLong(object,"uid");
		order.gameId = getInt(object,"game_id");
		order.source = getInt(object,"source");
		order.setGameOrderStatus(GameOrderStatus.getItem(getInt(object,"g_order_status")));
		order.setGameRechargeType(GameRechargeType.getItem(getInt(object,"g_order_type")));
		order.createTime = getDate(object, "g_order_create_at", CoreDateUtils.DATETIME);
		order.amount = getDouble(object,"g_order_amount");
		order.gameAmount = getDouble(object,"game_amount");
		order.gameRechargeTime = getDate(object,"game_recharge_time",CoreDateUtils.DATETIME);
		return order;
	}
	
	public static List<GameOrder> convertFromJSONArray(JSONArray array) {
		if (array == null) {
			return null;
		}
		List<GameOrder> list = new ArrayList<GameOrder>();
		for (Iterator<?> iterator = array.iterator(); iterator.hasNext();) {
			JSONObject object = (JSONObject) iterator.next();
			list.add(convertFromJSONObject(object));
		}
		return list;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getGameId() {
		return gameId;
	}
	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
	public GameOrderStatus getGameOrderStatus() {
		return gameOrderStatus;
	}
	public void setGameOrderStatus(GameOrderStatus gameOrderStatus) {
		this.gameOrderStatus = gameOrderStatus;
	}
	public GameRechargeType getGameRechargeType() {
		return gameRechargeType;
	}
	public void setGameRechargeType(GameRechargeType gameRechargeType) {
		this.gameRechargeType = gameRechargeType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getGameAmount() {
		return gameAmount;
	}

	public void setGameAmount(Double gameAmount) {
		this.gameAmount = gameAmount;
	}

	public Date getGameRechargeTime() {
		return gameRechargeTime;
	}
	public void setGameRechargeTime(Date gameRechargeTime) {
		this.gameRechargeTime = gameRechargeTime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
