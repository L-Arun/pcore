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
 * @author yanweijie
 * 自动跟单类型列表
 */
public class AutoFollowType extends IntegerBeanLabelItem {
	private static final long serialVersionUID = -530998782071935781L;
	private static final Logger logger = LoggerFactory.getLogger(AutoFollowType.class.getName());
	
	private static List<AutoFollowType> items = new ArrayList<AutoFollowType>();
	
	protected AutoFollowType(String name, int value) {
		super(AutoFollowType.class.getName(), name, value);
		items.add(this);
	}
	
	public static AutoFollowType getItem(int value){
		try {
			return (AutoFollowType)AutoFollowType.getResult(AutoFollowType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<AutoFollowType> getItems() {
		return items;
	}
	
	public static final AutoFollowType ALL = new AutoFollowType("全部", -1);
	public static final AutoFollowType ATTENTION = new AutoFollowType("关注", 1);
	public static final AutoFollowType FOLLOW = new AutoFollowType("跟单", 2);
}
