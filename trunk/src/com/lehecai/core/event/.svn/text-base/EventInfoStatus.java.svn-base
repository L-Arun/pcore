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
 * 活动状态
 */
public class EventInfoStatus extends IntegerBeanLabelItem {


	private static final long serialVersionUID = -530998782071935781L;

	private static final Logger logger = LoggerFactory.getLogger(EventInfoStatus.class.getName());
	
	private static List<EventInfoStatus> items = new ArrayList<EventInfoStatus>();
	
	protected EventInfoStatus(String name, int value) {
		super(EventInfoStatus.class.getName(), name, value);
		items.add(this);
	}
	
	public static EventInfoStatus getItem(int value){
		try {
			return (EventInfoStatus)EventInfoStatus.getResult(EventInfoStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<EventInfoStatus> getItems() {
		return items;
	}
	
	public static final EventInfoStatus ALL = new EventInfoStatus("全部", -1);
	public static final EventInfoStatus CLOSE = new EventInfoStatus("活动关闭", 0);
	public static final EventInfoStatus OPEN = new EventInfoStatus("活动开启", 1);

}
