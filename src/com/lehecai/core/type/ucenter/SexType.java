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
 * 性别
 * @author qatang
 *  
 */
public class SexType extends IntegerBeanLabelItem {
	private static final long serialVersionUID = 1497568813772971022L;

	private static final Logger logger = LoggerFactory.getLogger(SexType.class.getName());
	
	private static List<SexType> items = new ArrayList<SexType>();
	private static List<SexType> queryItems = new ArrayList<SexType>();
	
	protected SexType(String name, int value, boolean queryOnly) {
		super(SexType.class.getName(), name, value);
		
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	
	protected SexType(String name, int value) {
		this(name, value, false);
	}
	
	public static SexType getItem(int value){
		try {
			return (SexType)SexType.getResult(SexType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<SexType> getItems() {
		return items;
	}
	
	public static List<SexType> getItemsForQuery() {
		return queryItems;
	}

	public static final SexType ALL = new SexType("全部", -1, true);
	
	public static final SexType MALE = new SexType("男", 1);
	public static final SexType FEMALE = new SexType("女", 2);
}
