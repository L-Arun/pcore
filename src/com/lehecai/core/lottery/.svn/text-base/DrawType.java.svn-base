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
 * 彩票开奖类型
 * @author leiming
 *
 */
public class DrawType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = -341142019094299941L;

	private static final Logger logger = LoggerFactory.getLogger(DrawType.class.getName());
	
	private static List<DrawType> items = new ArrayList<DrawType>();
	private static List<DrawType> selectItems = new ArrayList<DrawType>();// 页面下拉列表选项
	
	
	protected DrawType(String name, int value) {
		super(DrawType.class.getName(), name, value);
		items.add(this);
		if(value>0){
			selectItems.add(this);
		}
	}
	
	public static DrawType getItem(int value){
		try {
			return (DrawType)DrawType.getResult(DrawType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<DrawType> getItems() {
		return items;
	}
	
	public static List<DrawType> getSelectItems() {
		return selectItems;
	}


	public static final DrawType ALL = new DrawType("全部", -1);
	public static final DrawType DEFAULT = new DrawType("默认", 0);
	
	public static final DrawType WHOLE_DRAW = new DrawType("完整开奖", 1);
	public static final DrawType PRE_DRAW = new DrawType("预开奖", 2);
	public static final DrawType PRIZE_DRAW = new DrawType("计算奖金", 3);
	
}
