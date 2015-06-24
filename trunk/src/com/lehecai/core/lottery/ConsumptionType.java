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
 * 消费类型
 */
public class ConsumptionType extends IntegerBeanLabelItem {

	private static final Logger logger = LoggerFactory.getLogger(ConsumptionType.class.getName());
	
	private static final long serialVersionUID = -2655180046354667807L;
	
	private static List<ConsumptionType> items = new ArrayList<ConsumptionType>();
	
	protected ConsumptionType(String name, int value) {
		super(ConsumptionType.class.getName(), name, value);
		items.add(this);
	}
	
	public static ConsumptionType getItem(int value){
		try {
			return (ConsumptionType)ConsumptionType.getResult(ConsumptionType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	/**
	 * @return 所有消费类型的列表
	 */
	public static List<ConsumptionType> getItems() {
		return items;
	}

	public static final ConsumptionType ALL = new ConsumptionType("全部", -1);
	
	public static final ConsumptionType CONSUME = new ConsumptionType("消费", 1);
	public static final ConsumptionType FREEZE = new ConsumptionType("冻结", 2);
	public static final ConsumptionType REFUND = new ConsumptionType("收入", 3);
	public static final ConsumptionType WITHDRAW = new ConsumptionType("提款", 4);
	public static final ConsumptionType DEDUCT = new ConsumptionType("扣款", 5);
	public static final ConsumptionType EXCHANGE = new ConsumptionType("兑换", 6);
}
