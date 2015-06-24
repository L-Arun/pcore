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
 * 方案订单类型
 */
public class PlanOrderType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = -3903706888276677204L;

	private static final Logger logger = LoggerFactory.getLogger(PlanOrderType.class.getName());
	
	private static List<PlanOrderType> items = new ArrayList<PlanOrderType>();
	
	protected PlanOrderType(String name, int value) {
		super(PlanOrderType.class.getName(), name, value);
		items.add(this);
	}
	
	public static PlanOrderType getItem(int value){
		try {
			return (PlanOrderType)PlanOrderType.getResult(PlanOrderType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<PlanOrderType> getItems() {
		return items;
	}
	
	public static final PlanOrderType ALL = new PlanOrderType("全部", -1);
	public static final PlanOrderType DEFAULT = new PlanOrderType("默认", 0);
	
	public static final PlanOrderType NORMAL = new PlanOrderType("普通代购", 1);
	public static final PlanOrderType SYNDICATE_FOUNDER = new PlanOrderType("发起合买", 2);
	public static final PlanOrderType SYNDICATE_RESERVED = new PlanOrderType("合买保底", 3);
	public static final PlanOrderType SYNDICATE_FOLLOW = new PlanOrderType("合买跟单", 4);
	public static final PlanOrderType CHASE = new PlanOrderType("自动追号", 5);
	public static final PlanOrderType SYNDICATE_AUTOFOLLOW = new PlanOrderType("自动跟单", 6);
	public static final PlanOrderType COMBO = new PlanOrderType("彩票套餐", 7);
	

}
