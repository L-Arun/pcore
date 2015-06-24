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
 * 开奖结果范围类型：1-数字区间|2-指定号码范围, 
 */
public class ResultRegionType extends IntegerBeanLabelItem {
	private static final long serialVersionUID = 1497568813772971022L;

	private static final Logger logger = LoggerFactory.getLogger(ResultRegionType.class.getName());
	
	private static List<ResultRegionType> items = new ArrayList<ResultRegionType>();
	private static List<ResultRegionType> queryItems = new ArrayList<ResultRegionType>();
	
	protected ResultRegionType(String name, int value, boolean queryOnly) {
		super(ResultRegionType.class.getName(), name, value);
		
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	
	protected ResultRegionType(String name, int value) {
		this(name, value, false);
	}
	
	public static ResultRegionType getItem(int value){
		try {
			return (ResultRegionType)ResultRegionType.getResult(ResultRegionType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<ResultRegionType> getItems() {
		return items;
	}
	
	public static List<ResultRegionType> getItemsForQuery() {
		return queryItems;
	}

	public static final ResultRegionType ALL = new ResultRegionType("全部", -1, true);
	
	public static final ResultRegionType DIGITAL_SECTION = new ResultRegionType("数字区间", 1);
	public static final ResultRegionType DESIGNATED_SECTION = new ResultRegionType("指定号码范围", 2);
}
