package com.lehecai.core.api.bean.range;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

public class RangeType extends IntegerBeanLabelItem {
	

	private static final long serialVersionUID = -6882074790745583890L;

	private static final Logger logger = LoggerFactory.getLogger(RangeType.class.getName());

	private static List<RangeType> _items = new ArrayList<RangeType>();
	
	private static List<RangeType> items;
	
	protected RangeType(String name, int value) {
		super(RangeType.class.getName(), name, value);
		_items.add(this);
	}
	
	public static RangeType getItem(int value){
		try {
			return (RangeType)RangeType.getResult(RangeType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<RangeType> getItems() {
		return items;
	}
	
	public final static RangeType DATE = new RangeType("时间类型", 1);

	public final static RangeType AUTO_INCREMENT = new RangeType("自增类型", 2);
	
	static {
		synchronized (_items) {
			items = Collections.unmodifiableList(_items);
		}
	}
}

