/**
 * 
 */
package com.lehecai.core.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * @author gb
 *
 */
public class EventType extends IntegerBeanLabelItem{
	private static final Logger logger = LoggerFactory.getLogger(EventType.class.getName());
	
	private static final long serialVersionUID = 1L;

	protected EventType(String name, int value) {
		super(EventType.class.getName(), name, value);
	}
	
	public static EventType getItem(int value){
		try {
			return (EventType)EventType.getResult(EventType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public final static EventType USER_REGISTER_SUCCESS  = new EventType("注册成功", 1100);
	public final static EventType USER_LOGIN_SUCCESS  = new EventType("登录成功", 1200);
	public final static EventType USER_RECHARGE_SUCCESS  = new EventType("充值成功", 1300);
	public final static EventType USER_WITHDRAW_REQUEST_SUBMIT =  new EventType("提款申请提交", 1400);
	public final static EventType USER_WITHDRAW_REQUEST_SUCCESS  = new EventType("提款申请成功", 1401);
	public final static EventType USER_WITHDRAW_REQUEST_REJECTED = new EventType("提款申请被拒绝", 1402);
	public final static EventType USER_WITHDRAW_FINISH  = new EventType("提款已到账", 1403);
	
	public final static EventType USER_PROFILE_UPDATE =  new EventType("用户资料修改", 1500);
	public final static EventType USER_PROFILE_UPDATE_PWD  = new EventType("修改密码成功", 1501);
	
	public final static EventType USER_LOTTERY_PLAN_TICKET_PRINTED  = new EventType("方案已出票", 2101);
	public final static EventType USER_LOTTERY_PLAN_TICKET_PRINTE_FAIL  = new EventType("方案出票失败", 2102);
	public final static EventType USER_LOTTERY_PLAN_DRAW  = new EventType("方案已开奖", 2103);
	public final static EventType USER_LOTTERY_PLAN_WON  = new EventType("方案已中奖", 2104);
	public final static EventType USER_LOTTERY_PLAN_REWARDED  = new EventType("方案已派奖", 2105);
	
	public final static EventType USER_LOTTERY_ORDER_PAYED  = new EventType("订单完成支付", 2201);
	public final static EventType USER_LOTTERY_ORDER_REWARDED  = new EventType("订单已派奖", 2202);
	
	public final static EventType LOTTERY_PHASE_STATUS_CHANGE = new EventType("彩期状态改变", 3100);
	public final static EventType LOTTERY_PHASE_OPEN  = new EventType("彩期已开启", 3101);
	public final static EventType LOTTERY_PHASE_CLOSED  = new EventType("彩期已关闭", 3102);
	public final static EventType LOTTERY_PHASE_DRAW  = new EventType("彩期已开奖", 3103);
	public final static EventType LOTTERY_PHASE_DRAW_FINISH  = new EventType("彩期开奖结束", 3104);
	public final static EventType LOTTERY_PHASE_PREDRAW_FINISH  = new EventType("彩期预开奖结束", 3105);
	public final static EventType LOTTERY_PHASE_PRIZE_COMPUTE_FINISH  = new EventType("彩期计算奖金结束", 3106);
	
	public final static EventType LOTTERY_MATCH_ONSALE  = new EventType("比赛已开售", 3201);
	public final static EventType LOTTERY_MATCH_CLOSE  = new EventType("比赛已停售", 3202);

}
