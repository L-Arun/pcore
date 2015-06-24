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
 *
 */
public class IdType extends IntegerBeanLabelItem {

	private static final Logger logger = LoggerFactory.getLogger(IdType.class.getName());
	
	private static final long serialVersionUID = -2655180046354667807L;
	
	private static List<IdType> items = new ArrayList<IdType>();
	
	protected IdType(String name, int value) {
		super(IdType.class.getName(), name, value);
		items.add(this);
	}
	
	public static IdType getItem(int value){
		try {
			return (IdType)IdType.getResult(IdType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<IdType> getItems() {
		return items;
	}

	public static final IdType DEFAULT = new IdType("默认", 0);
	public static final IdType IDCARD = new IdType("身份证", 1);
	
}
