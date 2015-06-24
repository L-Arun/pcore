/**
 * 
 */
package com.lehecai.core.lottery;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * @author qatang
 * 彩贝类型
 */
public class CreditType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = -5972075110669149409L;

	private static final Logger logger = LoggerFactory.getLogger(CreditType.class.getName());
	
	private static List<CreditType> items = new ArrayList<CreditType>();
	
	protected CreditType(String name, int value) {
		super(CreditType.class.getName(), name, value);
		items.add(this);
	}
	
	public static CreditType getItem(int value){
		try {
			return (CreditType)CreditType.getResult(CreditType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<CreditType> getItems() {
		return items;
	}
	
	public static final CreditType ALL = new CreditType("全部", -1);
	public static final CreditType DEFAULT = new CreditType("默认", 0);

	public static final CreditType CONSUME = new CreditType("消费", 1);
	public static final CreditType COMPLETE_INFO = new CreditType("完善资料", 2);
	public static final CreditType FIRST_RECHARGE = new CreditType("首次充值", 3);
	public static final CreditType LOGIN_PERDAY = new CreditType("每日登录", 4);
	public static final CreditType CONTINUE_COMSUME = new CreditType("连续消费", 5);
	public static final CreditType START_SYNDICATE = new CreditType("发起合买", 6);
	public static final CreditType OFFLINE_30DAYS = new CreditType("30天未登录", 7);
	public static final CreditType DG = new CreditType("代购", 8);
	public static final CreditType SYNDICATE_BUY = new CreditType("合买认购", 9);
	public static final CreditType SYNDICATE_FOLLOW = new CreditType("合买跟单", 10);
	public static final CreditType SYNDICATE_BAODI = new CreditType("合买保底", 11);
	public static final CreditType CHASE = new CreditType("追号", 12);
	public static final CreditType EVENT_PRIZE = new CreditType("活动奖励", 13);
	public static final CreditType EVENT_CONSUME = new CreditType("活动消费", 14);
	public static final CreditType AUTO_FOLLOW = new CreditType("自动跟单", 15);
	public static final CreditType EXCHANGE_OUT = new CreditType("兑出", 16);
	public static final CreditType EXCHANGE_IN = new CreditType("兑入", 17);
	public static final CreditType COMBO_CONSUME = new CreditType("套餐消费", 18);
	public static final CreditType GAME_CONSUME = new CreditType("游戏消费", 19);
	public static final CreditType GAME_REFUND = new CreditType("游戏返还", 20);
	
	public static final CreditType SYSTEM_PRESENT = new CreditType("系统赠送", 50);
	public static final CreditType SYSTEM_DEDUCT = new CreditType("系统扣除", 51);

}
