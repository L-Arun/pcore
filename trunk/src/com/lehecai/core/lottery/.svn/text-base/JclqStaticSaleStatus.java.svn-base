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
public class JclqStaticSaleStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 9133836199922834854L;

	private static final Logger logger = LoggerFactory.getLogger(JclqStaticSaleStatus.class.getName());
	
	private static List<JclqStaticSaleStatus> items = new ArrayList<JclqStaticSaleStatus>();
	private static List<JclqStaticSaleStatus> queryItems = new ArrayList<JclqStaticSaleStatus>();
	
	protected JclqStaticSaleStatus(String name, int value, boolean queryOnly) {
		super(JclqStaticSaleStatus.class.getName(), name, value);
		
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	protected JclqStaticSaleStatus(String name, int value) {
		this(name, value, false);
	}
	
	public static JclqStaticSaleStatus getItem(int value){
		try {
			return (JclqStaticSaleStatus)JclqStaticSaleStatus.getResult(JclqStaticSaleStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<JclqStaticSaleStatus> getItems() {
		return items;
	}
	public static List<JclqStaticSaleStatus> getItemsForQuery() {
		return queryItems;
	}
	
	public static final JclqStaticSaleStatus SALE_UNOPEN = new JclqStaticSaleStatus("固定奖金不可销售", 1);
	public static final JclqStaticSaleStatus SALE_OPEN = new JclqStaticSaleStatus("固定奖金可销售", 2);
}
