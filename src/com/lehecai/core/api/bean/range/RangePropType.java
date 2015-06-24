package com.lehecai.core.api.bean.range;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * 产生Range条件的属性类型
 * @author sunshow
 *
 */
public class RangePropType extends IntegerBeanLabelItem {
	
	private static final long serialVersionUID = -2834020358113318600L;

	private static final Logger logger = LoggerFactory.getLogger(RangePropType.class.getName());

	private static List<RangePropType> _items = new ArrayList<RangePropType>();
	
	private static List<RangePropType> items;
	
	protected RangePropType(String name, int value) {
		super(RangePropType.class.getName(), name, value);
		_items.add(this);
	}
	
	public static RangePropType getItem(int value){
		try {
			return (RangePropType)RangePropType.getResult(RangePropType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<RangePropType> getItems() {
		return items;
	}
	
	/**
	 * 有此属性条件直接使用此属性
	 */
	public final static RangePropType BREAK = new RangePropType("直接返回边界属性", 1);

	/**
	 * 常规属性，返回此属性的上下边界供所有属性整合
	 */
	public final static RangePropType NORMAL = new RangePropType("一般属性", 2);
	
	/**
	 * Range进行合并时，如果遇到此类型的，将本条属性规则放置到末尾进行合并
	 */
	public final static RangePropType FINAL = new RangePropType("末尾属性", 3);
	
	static {
		synchronized (_items) {
			items = Collections.unmodifiableList(_items);
		}
	}
}

