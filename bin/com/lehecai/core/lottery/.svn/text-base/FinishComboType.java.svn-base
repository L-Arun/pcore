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
 * 完成套餐类型
 * @author leiming
 *
 */
public class FinishComboType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 2038636173258022837L;

	private static final Logger logger = LoggerFactory.getLogger(FinishComboType.class.getName());
	
	private static List<FinishComboType> items = new ArrayList<FinishComboType>();
	
	protected FinishComboType(String name, int value) {
		super(FinishComboType.class.getName(), name, value);
		
		items.add(this);
	}
	
	public static FinishComboType getItem(int value){
		try {
			return (FinishComboType)FinishComboType.getResult(FinishComboType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<FinishComboType> getItems() {
		return items;
	}
	
	public static final FinishComboType ALL = new FinishComboType("全部", -1);
	public static final FinishComboType DEFAULT = new FinishComboType("默认", 0);
	
	public static final FinishComboType PLAN_FINISH = new FinishComboType("方案完成", 1);
	public static final FinishComboType PLAN_WIN = new FinishComboType("单期中奖奖金超过或等于**元结束", 2);
	public static final FinishComboType PLAN_WIN_PRIZE_1 = new FinishComboType("中一等奖后结束", 3);
	public static final FinishComboType PLAN_WIN_PRIZE_2_UP = new FinishComboType("中二等奖及以上后结束", 4);
}
