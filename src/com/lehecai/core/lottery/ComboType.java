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
 * 草票套餐类型列表
 */
public class ComboType extends IntegerBeanLabelItem {
	private static final long serialVersionUID = -530998782071935781L;
	private static final Logger logger = LoggerFactory.getLogger(ComboType.class.getName());
	
	private static List<ComboType> items = new ArrayList<ComboType>();
	
	protected ComboType(String name, int value) {
		super(ComboType.class.getName(), name, value);
		items.add(this);
	}
	
	public static ComboType getItem(int value){
		try {
			return (ComboType)ComboType.getResult(ComboType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<ComboType> getItems() {
		return items;
	}
	
	public static List<ComboType> getCheckItems() {
		List<ComboType> list = new ArrayList<ComboType>();
		list.add(ComboType.LOTTERYCOMBO_TYPE_USER);
		list.add(ComboType.LOTTERYCOMBO_TYPE_RANDOM);
		list.add(ComboType.LOTTERYCOMBO_TYPE_DANSHA);
		list.add(ComboType.LOTTERYCOMBO_TYPE_LUCKY);
		return list;
	}
	
	public static final ComboType ALL = new ComboType("全部", -1);
	public static final ComboType LOTTERYCOMBO_TYPE_USER = new ComboType("自选", 1);
	public static final ComboType LOTTERYCOMBO_TYPE_RANDOM = new ComboType("随机选号", 2);
	public static final ComboType LOTTERYCOMBO_TYPE_DANSHA = new ComboType("胆杀随机选号", 3);
	public static final ComboType LOTTERYCOMBO_TYPE_LUCKY = new ComboType("幸运选号", 4);
}
