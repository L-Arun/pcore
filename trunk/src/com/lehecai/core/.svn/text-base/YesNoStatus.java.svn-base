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
public class YesNoStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = -8013814461233302001L;

	private static final Logger logger = LoggerFactory.getLogger(YesNoStatus.class.getName());
	
	private static List<YesNoStatus> items = new ArrayList<YesNoStatus>();
	private static List<YesNoStatus> queryItems = new ArrayList<YesNoStatus>();
	
	protected YesNoStatus(String name, int value, boolean queryOnly) {
		super(YesNoStatus.class.getName(), name, value);
		
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	
	protected YesNoStatus(String name, int value) {
		this(name, value, false);
	}
	
	public static YesNoStatus getItem(int value){
		try {
			return (YesNoStatus)YesNoStatus.getResult(YesNoStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<YesNoStatus> getItems() {
		return items;
	}
	
	public static List<YesNoStatus> getItemsForQuery() {
		return queryItems;
	}

	public static final YesNoStatus ALL = new YesNoStatus("全部", -1, true);
	
	public static final YesNoStatus YES = new YesNoStatus("是", 1);
	public static final YesNoStatus NO = new YesNoStatus("否", 0);

}
