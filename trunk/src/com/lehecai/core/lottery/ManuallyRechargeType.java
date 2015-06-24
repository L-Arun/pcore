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
 * 手工充值类型
 */
public class ManuallyRechargeType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 6077383916299345697L;

	private static final Logger logger = LoggerFactory.getLogger(ManuallyRechargeType.class.getName());
	
	private static List<ManuallyRechargeType> items = new ArrayList<ManuallyRechargeType>();
	
	protected ManuallyRechargeType(String name, int value) {
		super(ManuallyRechargeType.class.getName(), name, value);
		items.add(this);
	}
	
	public static ManuallyRechargeType getItem(int value){
		try {
			return (ManuallyRechargeType)ManuallyRechargeType.getResult(ManuallyRechargeType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<ManuallyRechargeType> getItems() {
		return items;
	}
	
	public static final ManuallyRechargeType RESUPPLY_ORDER = new ManuallyRechargeType("补单", 1);
	public static final ManuallyRechargeType RECHARGE_MANUALLY = new ManuallyRechargeType("直接充钱", 2);
	
	public static final ManuallyRechargeType PRESENT_REFUND = new ManuallyRechargeType("彩金赠送", 3);
	public static final ManuallyRechargeType REPLENISH_REWARD = new ManuallyRechargeType("补充派奖", 4);
	
	public static final ManuallyRechargeType LEHECAI = new ManuallyRechargeType("内部充值", 5);
	public static final ManuallyRechargeType COMMISSION = new ManuallyRechargeType("佣金派发", 6);
	public static final ManuallyRechargeType COMPENSATE = new ManuallyRechargeType("赔偿", 7);
	public static final ManuallyRechargeType OTHERS = new ManuallyRechargeType("其他", 8);
}
