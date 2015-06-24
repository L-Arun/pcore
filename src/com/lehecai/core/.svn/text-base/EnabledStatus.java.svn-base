/**
 * 
 */
package com.lehecai.core;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sunshow
 */
public class EnabledStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 7743984145331545324L;

	private static final Logger logger = LoggerFactory.getLogger(EnabledStatus.class.getName());
	
	private static List<EnabledStatus> items = new ArrayList<EnabledStatus>();
	private static List<EnabledStatus> queryItems = new ArrayList<EnabledStatus>();
	
	protected EnabledStatus(String name, int value, boolean queryOnly) {
		super(EnabledStatus.class.getName(), name, value);

		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	
	protected EnabledStatus(String name, int value) {
		this(name, value, false);
	}
	
	public static EnabledStatus getItem(int value){
		try {
			return (EnabledStatus)EnabledStatus.getResult(EnabledStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<EnabledStatus> getItems() {
		return items;
	}
	
	public static List<EnabledStatus> getItemsForQuery() {
		return queryItems;
	}

	public static final EnabledStatus ALL = new EnabledStatus("全部", -1, true);
	
	public static final EnabledStatus ENABLED = new EnabledStatus("已启用", 1);
	public static final EnabledStatus DISABLED = new EnabledStatus("已禁用", 0);

}
