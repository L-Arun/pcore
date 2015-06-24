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
public class JclqDynamicSaleStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 9133836199922834854L;

	private static final Logger logger = LoggerFactory.getLogger(JclqDynamicSaleStatus.class.getName());
	
	private static List<JclqDynamicSaleStatus> items = new ArrayList<JclqDynamicSaleStatus>();
	private static List<JclqDynamicSaleStatus> queryItems = new ArrayList<JclqDynamicSaleStatus>();
	
	protected JclqDynamicSaleStatus(String name, int value, boolean queryOnly) {
		super(JclqDynamicSaleStatus.class.getName(), name, value);
		
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	protected JclqDynamicSaleStatus(String name, int value) {
		this(name, value, false);
	}
	
	public static JclqDynamicSaleStatus getItem(int value){
		try {
			return (JclqDynamicSaleStatus)JclqDynamicSaleStatus.getResult(JclqDynamicSaleStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<JclqDynamicSaleStatus> getItems() {
		return items;
	}
	public static List<JclqDynamicSaleStatus> getItemsForQuery() {
		return queryItems;
	}
	
	public static final JclqDynamicSaleStatus SALE_UNOPEN = new JclqDynamicSaleStatus("浮动奖金不可销售", 1);
	public static final JclqDynamicSaleStatus SALE_OPEN = new JclqDynamicSaleStatus("浮动奖金可销售", 2);
}
