/**
 * 
 */
package com.lehecai.core.event;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * @author qatang
 * 活动派奖状态
 */
public class EventLogStatus extends IntegerBeanLabelItem {


	private static final long serialVersionUID = -530998782071935781L;

	private static final Logger logger = LoggerFactory.getLogger(EventLogStatus.class.getName());
	
	private static List<EventLogStatus> items = new ArrayList<EventLogStatus>();
	
	protected EventLogStatus(String name, int value) {
		super(EventLogStatus.class.getName(), name, value);
		items.add(this);
	}
	
	public static EventLogStatus getItem(int value){
		try {
			return (EventLogStatus)EventLogStatus.getResult(EventLogStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<EventLogStatus> getItems() {
		return items;
	}
	
	public static final EventLogStatus ALL = new EventLogStatus("全部", -1);
	public static final EventLogStatus UNREWARD = new EventLogStatus("未派奖", 0);
	public static final EventLogStatus REWARD = new EventLogStatus("已派奖", 1);

}
