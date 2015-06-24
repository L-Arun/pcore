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
 * 固定奖金销售状态
 */
public class JczqStaticSaleStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 9133836199922834854L;

	private static final Logger logger = LoggerFactory.getLogger(JczqStaticSaleStatus.class.getName());
	
	private static List<JczqStaticSaleStatus> items = new ArrayList<JczqStaticSaleStatus>();
	private static List<JczqStaticSaleStatus> queryItems = new ArrayList<JczqStaticSaleStatus>();
	
	protected JczqStaticSaleStatus(String name, int value, boolean queryOnly) {
		super(JczqStaticSaleStatus.class.getName(), name, value);
		
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	protected JczqStaticSaleStatus(String name, int value) {
		this(name, value, false);
	}
	
	public static JczqStaticSaleStatus getItem(int value){
		try {
			return (JczqStaticSaleStatus)JczqStaticSaleStatus.getResult(JczqStaticSaleStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<JczqStaticSaleStatus> getItems() {
		return items;
	}
	public static List<JczqStaticSaleStatus> getItemsForQuery() {
		return queryItems;
	}
	
	public static final JczqStaticSaleStatus SALE_UNOPEN = new JczqStaticSaleStatus("固定奖金不可销售", 1);
	public static final JczqStaticSaleStatus SALE_OPEN = new JczqStaticSaleStatus("固定奖金可销售", 2);
}
