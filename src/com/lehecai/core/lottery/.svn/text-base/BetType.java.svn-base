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
 * 彩票投注类型
 * @author leiming
 *
 */
public class BetType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = -341142019094299941L;

	private static final Logger logger = LoggerFactory.getLogger(BetType.class.getName());
	
	private static List<BetType> items = new ArrayList<BetType>();
	private static List<BetType> selectItems = new ArrayList<BetType>();// 页面下拉列表选项
	
	
	protected BetType(String name, int value) {
		super(BetType.class.getName(), name, value);
		items.add(this);
		if(value>0){
			selectItems.add(this);
		}
	}
	
	public static BetType getItem(int value){
		try {
			return (BetType)BetType.getResult(BetType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<BetType> getItems() {
		return items;
	}
	
	public static List<BetType> getSelectItems() {
		return selectItems;
	}


	public static final BetType ALL = new BetType("全部", -1);
	public static final BetType DEFAULT = new BetType("默认", 0);
	
	public static final BetType JCLQ_STATIC_BET = new BetType("竞彩篮球固定奖金投注", 1);
	public static final BetType JCLQ_DYNAMIC_BET = new BetType("竞彩篮球浮动奖金投注", 2);
	
	public static final BetType JCZQ_STATIC_BET = new BetType("竞彩足球固定奖金投注", 3);
	public static final BetType JCZQ_DYNAMIC_BET = new BetType("竞彩足球浮动奖金投注", 4);
}
