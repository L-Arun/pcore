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
public class JczqDynamicDrawStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 9133836199922834854L;

	private static final Logger logger = LoggerFactory.getLogger(JczqDynamicDrawStatus.class.getName());
	
	private static List<JczqDynamicDrawStatus> items = new ArrayList<JczqDynamicDrawStatus>();
	private static List<JczqDynamicDrawStatus> queryItems = new ArrayList<JczqDynamicDrawStatus>();
	
	protected JczqDynamicDrawStatus(String name, int value, boolean queryOnly) {
		super(JczqDynamicDrawStatus.class.getName(), name, value);
		
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	protected JczqDynamicDrawStatus(String name, int value) {
		this(name, value, false);
	}
	
	public static JczqDynamicDrawStatus getItem(int value){
		try {
			return (JczqDynamicDrawStatus)JczqDynamicDrawStatus.getResult(JczqDynamicDrawStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<JczqDynamicDrawStatus> getItems() {
		return items;
	}
	public static List<JczqDynamicDrawStatus> getItemsForQuery() {
		return queryItems;
	}
	
	public static final JczqDynamicDrawStatus ALL = new JczqDynamicDrawStatus("全部", -1 ,true);
	
	public static final JczqDynamicDrawStatus UNOPEN = new JczqDynamicDrawStatus("浮动奖金不可开奖", 1);
	public static final JczqDynamicDrawStatus OPEN = new JczqDynamicDrawStatus("浮动奖金可开奖", 2);
}
