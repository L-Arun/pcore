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
 * 停止追号类型
 */
public class StopChaseType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 2038636173258022837L;

	private static final Logger logger = LoggerFactory.getLogger(StopChaseType.class.getName());
	
	private static List<StopChaseType> items = new ArrayList<StopChaseType>();
	
	protected StopChaseType(String name, int value) {
		super(StopChaseType.class.getName(), name, value);
		
		items.add(this);
	}
	
	public static StopChaseType getItem(int value){
		try {
			return (StopChaseType)StopChaseType.getResult(StopChaseType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<StopChaseType> getItems() {
		return items;
	}
	
	public static final StopChaseType ALL = new StopChaseType("全部", -1);
	public static final StopChaseType DEFAULT = new StopChaseType("默认", 0);
	
	public static final StopChaseType STOP_NEVER = new StopChaseType("一直追号", 1);
	public static final StopChaseType STOP_AFTER_AWARDS = new StopChaseType("中奖后停止追号", 2);
}
