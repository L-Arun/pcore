/**
 * 
 */
package com.lehecai.core.game;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * @author chirowong
 * 游戏订单状态
 */
public class GameOrderStatus extends IntegerBeanLabelItem {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7009455804239792650L;

	private static final Logger logger = LoggerFactory.getLogger(GameOrderStatus.class.getName());
	
	private static List<GameOrderStatus> items = new ArrayList<GameOrderStatus>();
	
	protected GameOrderStatus(String name, int value) {
		super(GameOrderStatus.class.getName(), name, value);
		items.add(this);
	}
	
	public static GameOrderStatus getItem(int value){
		try {
			return (GameOrderStatus)GameOrderStatus.getResult(GameOrderStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<GameOrderStatus> getItems() {
		return items;
	}

	public static final GameOrderStatus ALL = new GameOrderStatus("全部", -1);
	
	public static final GameOrderStatus NOT_PAID = new GameOrderStatus("未支付", 0);
	public static final GameOrderStatus PAID = new GameOrderStatus("已支付", 1);				
	public static final GameOrderStatus RECHARGE = new GameOrderStatus("三方充值中", 2);
	public static final GameOrderStatus ERROR = new GameOrderStatus("三方充值失败", 3);
	public static final GameOrderStatus RECHARGED = new GameOrderStatus("三方充值成功", 4);
	public static final GameOrderStatus REFUNDED = new GameOrderStatus("已退款", 5);
	public static final GameOrderStatus DONE = new GameOrderStatus("已完结", 6);
	public static final GameOrderStatus NOTPAIDOBSOLETE = new GameOrderStatus("未支付作废", 7);
}
