package com.lehecai.core.lottery;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * 套餐销售状态
 * @author leiming
 *
 */
public class ComboSaleStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 7743984145331545324L;

	private static final Logger logger = LoggerFactory.getLogger(ComboSaleStatus.class.getName());
	
	private static List<ComboSaleStatus> items = new ArrayList<ComboSaleStatus>();
	private static List<ComboSaleStatus> queryItems = new ArrayList<ComboSaleStatus>();
	
	protected ComboSaleStatus(String name, int value, boolean queryOnly) {
		super(ComboSaleStatus.class.getName(), name, value);

		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	
	protected ComboSaleStatus(String name, int value) {
		this(name, value, false);
	}
	
	public static ComboSaleStatus getItem(int value){
		try {
			return (ComboSaleStatus)ComboSaleStatus.getResult(ComboSaleStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<ComboSaleStatus> getItems() {
		return items;
	}
	
	public static List<ComboSaleStatus> getItemsForQuery() {
		return queryItems;
	}

	public static final ComboSaleStatus ALL = new ComboSaleStatus("全部", -1);
	
	public static final ComboSaleStatus DISABLED = new ComboSaleStatus("不可用", 0);
	public static final ComboSaleStatus ENABLED = new ComboSaleStatus("可用", 1);

}
