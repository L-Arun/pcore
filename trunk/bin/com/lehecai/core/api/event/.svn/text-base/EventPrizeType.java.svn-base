package com.lehecai.core.api.event;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * @author yanweijie
 *
 */
public class EventPrizeType extends IntegerBeanLabelItem {
	private static final Logger logger = LoggerFactory.getLogger(EventPrizeType.class.getName());
	private static final long serialVersionUID = -2655180046354667807L;
	
	private static List<EventPrizeType> items = new ArrayList<EventPrizeType>();
	
	protected EventPrizeType(String name, int value) {
		super(EventPrizeType.class.getName(), name, value);
		items.add(this);
	}
	
	public static EventPrizeType getItem(int value){
		try {
			return (EventPrizeType)EventPrizeType.getResult(EventPrizeType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<EventPrizeType> getItems() {
		return items;
	}

	public static final EventPrizeType GIFT = new EventPrizeType("彩金", 1);
	public static final EventPrizeType CREDIT = new EventPrizeType("彩贝", 2);
	public static final EventPrizeType GIFT_CARD = new EventPrizeType("彩金卡", 3);
	public static final EventPrizeType PRESENT = new EventPrizeType("礼品", 4);
	public static final EventPrizeType COIN = new EventPrizeType("金币", 5);
}
