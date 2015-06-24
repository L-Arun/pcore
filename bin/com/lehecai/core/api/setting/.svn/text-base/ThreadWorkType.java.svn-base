/**
 * 
 */
package com.lehecai.core.api.setting;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * 线程工作类型  启动 停止 重启
 * @author leiming
 *
 */
public class ThreadWorkType extends IntegerBeanLabelItem {

	private static final Logger logger = LoggerFactory.getLogger(ThreadWorkType.class.getName());
	
	private static final long serialVersionUID = -2655180046354667807L;
	
	private static List<ThreadWorkType> items = new ArrayList<ThreadWorkType>();
	private static List<ThreadWorkType> startStopItems = new ArrayList<ThreadWorkType>();
	
	protected ThreadWorkType(String name, int value) {
		super(ThreadWorkType.class.getName(), name, value);
		if(value < 3){
			startStopItems.add(this);
		}
		items.add(this);
	}
	
	public static ThreadWorkType getItem(int value){
		try {
			return (ThreadWorkType)ThreadWorkType.getResult(ThreadWorkType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<ThreadWorkType> getItems() {
		return items;
	}
	public static List<ThreadWorkType> getStartStopItems() {
		return startStopItems;
	}

	public static final ThreadWorkType START_THREAD = new ThreadWorkType("启动", 1);
	public static final ThreadWorkType STOP_THREAD = new ThreadWorkType("停止", 2);
	public static final ThreadWorkType RELOAD_THREAD = new ThreadWorkType("重启", 3);
	
}
