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
 * 操作类型
 */
public class OperationType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = -5972075110669149409L;

	private static final Logger logger = LoggerFactory.getLogger(OperationType.class.getName());
	
	private static List<OperationType> items = new ArrayList<OperationType>();
	
	protected OperationType(String name, int value) {
		super(OperationType.class.getName(), name, value);
		items.add(this);
	}
	
	public static OperationType getItem(int value){
		try {
			return (OperationType)OperationType.getResult(OperationType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<OperationType> getItems() {
		return items;
	}
	
	public static final OperationType ALL = new OperationType("全部", -1);
	public static final OperationType DEFAULT = new OperationType("默认", 0);

	public static final OperationType REGISTER = new OperationType("注册", 1);
	public static final OperationType LOGIN = new OperationType("登录", 2);
	public static final OperationType RECHARGE = new OperationType("充值", 3);
	public static final OperationType DG = new OperationType("代购选中方案", 4);
	public static final OperationType CONSUME = new OperationType("消费", 5);
	public static final OperationType REWARD = new OperationType("返奖", 6);
	public static final OperationType REFUND = new OperationType("退款", 7);
	
	public static final OperationType HM_LAUNCH = new OperationType("发起合买方案", 9);
	public static final OperationType HM_JOIN = new OperationType("参与合买方案", 10);
	public static final OperationType CHASE = new OperationType("追号", 11);
	public static final OperationType CHASE_CANCEL = new OperationType("取消追号", 12);
	public static final OperationType HM_JOIN_CANCEL = new OperationType("参与合买撤单", 13);
	public static final OperationType HM_LAUNCH_CANCEL = new OperationType("发起合买撤单", 14);
	public static final OperationType WITHDRAW = new OperationType("提款", 15);
	public static final OperationType HM_CANCEL = new OperationType("合买撤单", 16);
	public static final OperationType REGISTER_TRY = new OperationType("尝试注册", 17);
	public static final OperationType RECHARGE_TRY = new OperationType("尝试充值", 18);
	public static final OperationType VISIT = new OperationType("访问", 19);
	
	public static final OperationType AUTO_FOLLOW = new OperationType("自动跟单", 31);
	public static final OperationType AUTO_FOLLOW_CANCEL = new OperationType("取消自动跟单", 32);
	
	public static final OperationType LOGIN_TRY = new OperationType("尝试登录", 40);
	public static final OperationType LOGOUT = new OperationType("注销登录", 41);
	public static final OperationType PASSWORD_RESET = new OperationType("取回密码", 42);
	
	public static final OperationType PASSWORD_UPDATE = new OperationType("修改密码", 45);

}
