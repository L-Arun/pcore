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
 * @author Sunshow
 * 交易类型
 */
public class TransType extends IntegerBeanLabelItem {

	private static final Logger logger = LoggerFactory.getLogger(TransType.class.getName());
	
	private static final long serialVersionUID = -2655180046354667807L;
	
	private static List<TransType> items = new ArrayList<TransType>();
	
	protected TransType(String name, int value) {
		super(TransType.class.getName(), name, value);
		items.add(this);
	}
	
	public static TransType getItem(int value){
		try {
			return (TransType)TransType.getResult(TransType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<TransType> getItems() {
		return items;
	}

	public static final TransType ALL = new TransType("全部", -1);
	public static final TransType DEFAULT = new TransType("默认", 0);

	public static final TransType WITHDRAW_FREEZE = new TransType("提款冻结", 1);
	public static final TransType WITHDRAW_CONSUME = new TransType("提款成功扣钱", 2);
	public static final TransType WITHDRAW_REFUND = new TransType("提款失败退款", 3);
	
	public static final TransType DG_FREEZE = new TransType("发起代购冻结", 4);
	public static final TransType DG_CONSUME = new TransType("代购成功消费", 5);
	public static final TransType DG_REFUND = new TransType("代购失败退款", 6);
	public static final TransType DG_REFUND_PART = new TransType("代购部分退款", 7);
	
	public static final TransType HM_LAUNCH_FREEZE = new TransType("发起合买冻结", 8);
	public static final TransType HM_ASSURE_FREEZE = new TransType("合买保底冻结", 9);
	public static final TransType HM_JOIN_FREEZE = new TransType("参与合买冻结", 10);
	public static final TransType HM_LAUNCH_CONSUME = new TransType("发起合买消费", 11);
	public static final TransType HM_ASSURE_CONSUME = new TransType("合买保底消费", 12);
	public static final TransType HM_JOIN_CONSUME = new TransType("参与合买消费", 13);
	public static final TransType HM_LAUNCH_REFUND = new TransType("发起合买失败退款", 14);
	public static final TransType HM_LAUNCH_REFUND_CANCEL = new TransType("发起合买撤单退款", 15);
	public static final TransType HM_ASSURE_REFUND = new TransType("合买保底退款", 16);
	public static final TransType HM_JOIN_REFUND = new TransType("参与合买失败退款", 17);
	public static final TransType HM_JOIN_REFUND_CANCEL = new TransType("参与合买撤单退款", 18);
	public static final TransType HM_REFUND_PART = new TransType("合买部分退款", 19);
	
	public static final TransType AUTO_FOLLOW_FREEZE = new TransType("自动跟单冻结", 20);
	public static final TransType AUTO_FOLLOW_CONSUME = new TransType("自动跟单消费", 21);
	public static final TransType AUTO_FOLLOW_REFUND = new TransType("自动跟单失败退款", 22);
	public static final TransType AUTO_FOLLOW_REFUND_CANCEL = new TransType("自动跟单撤单退款", 23);
	
	public static final TransType CHASE_FREEZE = new TransType("执行追号冻结", 24);
	public static final TransType CHASE_CONSUME = new TransType("追号成功消费", 25);
	public static final TransType CHASE_REFUND = new TransType("追号失败退款", 26);
	
	public static final TransType WINNING_REFUND = new TransType("返奖", 27);
	
	public static final TransType PRESENT_REFUND = new TransType("彩金赠送", 28);
	
	public static final TransType RECHARGE = new TransType("充值", 29);
	
	public static final TransType RECHARGE_MANUALLY = new TransType("直接充钱", 30);
	
	public static final TransType WITHDRAW_REJECT = new TransType("拒绝提款退款", 31);
	public static final TransType WITHDRAW_CANCEL = new TransType("撤销提款退款", 32);
	public static final TransType CHASE_CANCEL_REFUND = new TransType("追号撤销退款", 33);
	public static final TransType SYNDICATE_RESERVED_CANCEL = new TransType("合买保底撤单退款", 34);
	public static final TransType NORMAL_CANCEL = new TransType("代购撤单退款", 35);
	public static final TransType MANUALLY_AWARD = new TransType("补充派奖", 36);
	
	public static final TransType DEDUCT_FREEZE = new TransType("扣款冻结", 37);
	public static final TransType DEDUCT_UNFREEZE = new TransType("扣款解冻", 38);
	public static final TransType DEDUCT = new TransType("扣款完成", 39);
	
	public static final TransType CHASE_CREATE_FREEZE = new TransType("发起追号冻结", 40);
	
	public static final TransType REBATE = new TransType("盈利提成", 45);
	
	public static final TransType COMBO_FROZEN_ALL = new TransType("购买套餐冻结", 50);
	public static final TransType COMBO_FROZEN_ONE = new TransType("执行套餐冻结", 51);
	public static final TransType COMBO_SUCCESS = new TransType("执行套餐消费", 52);
	public static final TransType COMBO_FAILURE = new TransType("执行套餐失败退款", 53);
	public static final TransType COMBO_PARTREFUND = new TransType("执行套餐部分失败退款", 54);
	public static final TransType COMBO_STOP = new TransType("套餐终止退款", 55);
	
	public static final TransType EXCHANGE_OUT = new TransType("钱包兑换转出", 61);
	public static final TransType EXCHANGE_IN = new TransType("钱包兑换转入", 62);
	
	public static final TransType COUPON_RECHARGE  = new TransType("彩金券兑换", 71);
	
	public static final TransType COMMISSION  = new TransType("佣金派发", 72);
	public static final TransType COMPENSATE  = new TransType("赔偿", 73);
	public static final TransType OTHERS  = new TransType("其他充值", 74);
	public static final TransType OTHERS_FRONTEND  = new TransType("前端专用其他充值", 75);
	
	public static final TransType GAME_FROZEN  = new TransType("游戏充值冻结", 201);
	public static final TransType GAME_COMSUME  = new TransType("游戏充值消费", 202);
	public static final TransType GAME_REFUND  = new TransType("游戏充值退款", 203);
}
