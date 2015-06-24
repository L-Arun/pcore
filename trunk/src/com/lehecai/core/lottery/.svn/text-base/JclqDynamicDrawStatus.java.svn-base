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
 * @author qatang
 * 浮动奖金开奖状态
 */
public class JclqDynamicDrawStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 9133836199922834854L;

	private static final Logger logger = LoggerFactory.getLogger(JclqDynamicDrawStatus.class.getName());
	
	private static List<JclqDynamicDrawStatus> items = new ArrayList<JclqDynamicDrawStatus>();
	private static List<JclqDynamicDrawStatus> queryItems = new ArrayList<JclqDynamicDrawStatus>();
	
	protected JclqDynamicDrawStatus(String name, int value, boolean queryOnly) {
		super(JclqDynamicDrawStatus.class.getName(), name, value);
		
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	protected JclqDynamicDrawStatus(String name, int value) {
		this(name, value, false);
	}
	
	public static JclqDynamicDrawStatus getItem(int value){
		try {
			return (JclqDynamicDrawStatus)JclqDynamicDrawStatus.getResult(JclqDynamicDrawStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<JclqDynamicDrawStatus> getItems() {
		return items;
	}
	public static List<JclqDynamicDrawStatus> getItemsForQuery() {
		return queryItems;
	}
	
	public static final JclqDynamicDrawStatus ALL = new JclqDynamicDrawStatus("全部", -1 ,true);
	
	public static final JclqDynamicDrawStatus UNOPEN = new JclqDynamicDrawStatus("浮动奖金不可开奖", 1);
	public static final JclqDynamicDrawStatus OPEN = new JclqDynamicDrawStatus("浮动奖金可开奖", 2);
}
