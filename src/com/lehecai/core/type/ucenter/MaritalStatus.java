/**
 * 
 */
package com.lehecai.core.type.ucenter;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * 婚姻状况
 * @author qatang
 *  
 */
public class MaritalStatus extends IntegerBeanLabelItem {
	private static final long serialVersionUID = 1497568813772971022L;

	private static final Logger logger = LoggerFactory.getLogger(MaritalStatus.class.getName());
	
	private static List<MaritalStatus> items = new ArrayList<MaritalStatus>();
	private static List<MaritalStatus> queryItems = new ArrayList<MaritalStatus>();
	
	protected MaritalStatus(String name, int value, boolean queryOnly) {
		super(MaritalStatus.class.getName(), name, value);
		
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	
	protected MaritalStatus(String name, int value) {
		this(name, value, false);
	}
	
	public static MaritalStatus getItem(int value){
		try {
			return (MaritalStatus)MaritalStatus.getResult(MaritalStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<MaritalStatus> getItems() {
		return items;
	}
	
	public static List<MaritalStatus> getItemsForQuery() {
		return queryItems;
	}

	public static final MaritalStatus ALL = new MaritalStatus("全部", -1, true);
	
	public static final MaritalStatus unmarried = new MaritalStatus("未婚", 1);
	public static final MaritalStatus married = new MaritalStatus("已婚", 2);
}
