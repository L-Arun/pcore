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
 * @author qatang
 * 浮动奖金销售状态
 */
public class JczqDynamicSaleStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 9133836199922834854L;

	private static final Logger logger = LoggerFactory.getLogger(JczqDynamicSaleStatus.class.getName());
	
	private static List<JczqDynamicSaleStatus> items = new ArrayList<JczqDynamicSaleStatus>();
	private static List<JczqDynamicSaleStatus> queryItems = new ArrayList<JczqDynamicSaleStatus>();
	
	protected JczqDynamicSaleStatus(String name, int value, boolean queryOnly) {
		super(JczqDynamicSaleStatus.class.getName(), name, value);
		
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	protected JczqDynamicSaleStatus(String name, int value) {
		this(name, value, false);
	}
	
	public static JczqDynamicSaleStatus getItem(int value){
		try {
			return (JczqDynamicSaleStatus)JczqDynamicSaleStatus.getResult(JczqDynamicSaleStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<JczqDynamicSaleStatus> getItems() {
		return items;
	}
	public static List<JczqDynamicSaleStatus> getItemsForQuery() {
		return queryItems;
	}
	
	public static final JczqDynamicSaleStatus SALE_UNOPEN = new JczqDynamicSaleStatus("浮动奖金不可销售", 1);
	public static final JczqDynamicSaleStatus SALE_OPEN = new JczqDynamicSaleStatus("浮动奖金可销售", 2);
}
