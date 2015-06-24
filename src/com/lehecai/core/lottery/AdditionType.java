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
 * 是否追加列表
 */
public class AdditionType extends IntegerBeanLabelItem {


	private static final long serialVersionUID = -530998782071935781L;

	private static final Logger logger = LoggerFactory.getLogger(AdditionType.class.getName());
	
	private static List<AdditionType> items = new ArrayList<AdditionType>();
	
	protected AdditionType(String name, int value) {
		super(AdditionType.class.getName(), name, value);
		items.add(this);
	}
	
	public static AdditionType getItem(int value){
		try {
			return (AdditionType)AdditionType.getResult(AdditionType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<AdditionType> getItems() {
		return items;
	}
	
	public static final AdditionType ALL = new AdditionType("不限制", -1);
	public static final AdditionType DEFAULT = new AdditionType("无追加", 0);
	public static final AdditionType BC = new AdditionType("追加", 1);
}
