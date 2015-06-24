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
 * 是否用于ivr
 */
public class WithIvrType extends IntegerBeanLabelItem {


	private static final long serialVersionUID = -530998782071935781L;

	private static final Logger logger = LoggerFactory.getLogger(WithIvrType.class.getName());
	
	private static List<WithIvrType> items = new ArrayList<WithIvrType>();
	
	protected WithIvrType(String name, int value) {
		super(WithIvrType.class.getName(), name, value);
		items.add(this);
	}
	
	public static WithIvrType getItem(int value){
		try {
			return (WithIvrType)WithIvrType.getResult(WithIvrType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<WithIvrType> getItems() {
		return items;
	}
	
	public static final WithIvrType NOT_USE = new WithIvrType("未使用", 0);
	public static final WithIvrType USED = new WithIvrType("已使用", 1);
	public static final WithIvrType BIND = new WithIvrType("已绑定", 2);
}
