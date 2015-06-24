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
 * 游戏充值方式
 */
public class GameRechargeType extends IntegerBeanLabelItem {


	/**
	 * 
	 */
	private static final long serialVersionUID = 56751664345750721L;

	private static final Logger logger = LoggerFactory.getLogger(GameRechargeType.class.getName());
	
	private static List<GameRechargeType> items = new ArrayList<GameRechargeType>();
	
	protected GameRechargeType(String name, int value) {
		super(GameRechargeType.class.getName(), name, value);
		items.add(this);
	}
	
	public static GameRechargeType getItem(int value){
		try {
			return (GameRechargeType)GameRechargeType.getResult(GameRechargeType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<GameRechargeType> getItems() {
		return items;
	}

	public static final GameRechargeType ALL = new GameRechargeType("全部", -1);
	
	public static final GameRechargeType CASH = new GameRechargeType("现金消费", 1);				
	public static final GameRechargeType CREDIT = new GameRechargeType("彩贝消费", 2);
	/*public static final RechargeType RECHARGEING = new RechargeType("直接充值", 3);*/
}
