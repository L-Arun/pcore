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
 * 方案创建类型
 */
public class PlanCreateType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 5854950131818565202L;

	private static final Logger logger = LoggerFactory.getLogger(PlanCreateType.class.getName());
	
	private static List<PlanCreateType> items = new ArrayList<PlanCreateType>();
	
	protected PlanCreateType(String name, int value) {
		super(PlanCreateType.class.getName(), name, value);
		items.add(this);
	}
	
	public static PlanCreateType getItem(int value){
		try {
			return (PlanCreateType)PlanCreateType.getResult(PlanCreateType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<PlanCreateType> getItems() {
		return items;
	}
	
	public static final PlanCreateType ALL = new PlanCreateType("全部", -1);
	
	public static final PlanCreateType DEFAULT = new PlanCreateType("默认", 0);
	public static final PlanCreateType FILTER = new PlanCreateType("在线过滤", 1);
	public static final PlanCreateType INTELLIGENCE = new PlanCreateType("智能过滤", 2);
	
	public static final PlanCreateType GAME_HORSE_RACING = new PlanCreateType("赛马游戏", 101);
	public static final PlanCreateType GAME_CAR_RACING = new PlanCreateType("赛车游戏", 102);
}
