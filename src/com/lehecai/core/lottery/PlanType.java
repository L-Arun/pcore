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
 * 方案类型
 */
public class PlanType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = -341142019094299941L;

	private static final Logger logger = LoggerFactory.getLogger(PlanType.class.getName());
	
	private static List<PlanType> items = new ArrayList<PlanType>();
	private static List<PlanType> _items = new ArrayList<PlanType>();
	
	protected PlanType(String name, int value) {
		super(PlanType.class.getName(), name, value);
		if (value > 0) {
			_items.add(this);
		}
		items.add(this);
	}
	
	public static PlanType getItem(int value){
		try {
			return (PlanType)PlanType.getResult(PlanType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<PlanType> getItems() {
		return items;
	}
	
	public static List<PlanType> getSelectItems() {
		return _items;
	}

	public static final PlanType ALL = new PlanType("全部", -1);
	public static final PlanType DEFAULT = new PlanType("默认", 0);
	
	public static final PlanType DG = new PlanType("代购", 1);
	public static final PlanType HM = new PlanType("合买", 2);
	public static final PlanType CHASE = new PlanType("追号", 3);
	/*
	public static final PlanType AUTO_FOLLOW = new PlanType("自动跟单", 4);
	*/
	public static final PlanType COMBO = new PlanType("彩票套餐", 5);
}
