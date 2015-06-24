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
 * 套餐选号类型
 * @author leiming
 *
 */
public class ComboSelectType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 2038636173258022837L;

	private static final Logger logger = LoggerFactory.getLogger(ComboSelectType.class.getName());
	
	private static List<ComboSelectType> items = new ArrayList<ComboSelectType>();
	
	protected ComboSelectType(String name, int value) {
		super(ComboSelectType.class.getName(), name, value);
		
		items.add(this);
	}
	
	public static ComboSelectType getItem(int value){
		try {
			return (ComboSelectType)ComboSelectType.getResult(ComboSelectType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<ComboSelectType> getItems() {
		return items;
	}
	
	public static final ComboSelectType ALL = new ComboSelectType("全部", -1);
	public static final ComboSelectType DEFAULT = new ComboSelectType("默认", 0);
	
	public static final ComboSelectType USER = new ComboSelectType("自选", 1);
	public static final ComboSelectType RANDOM = new ComboSelectType("随机选号", 2);
	public static final ComboSelectType DANSHA = new ComboSelectType("胆杀随机选号", 3);
	public static final ComboSelectType LUCKY = new ComboSelectType("幸运选号", 4);
}
