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
 * @author Sunshow
 * 订单派奖状态
 */
public class PrizeStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 8439170604365702721L;

	private static final Logger logger = LoggerFactory.getLogger(PrizeStatus.class.getName());
	
	private static List<PrizeStatus> items = new ArrayList<PrizeStatus>();
	
	protected PrizeStatus(String name, int value) {
		super(PrizeStatus.class.getName(), name, value);
		items.add(this);
	}
	
	public static PrizeStatus getItem(int value){
		try {
			return (PrizeStatus)PrizeStatus.getResult(PrizeStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<PrizeStatus> getItems() {
		return items;
	}
	
	public static final PrizeStatus ALL = new PrizeStatus("全部", -1);
	public static final PrizeStatus DEFAULT = new PrizeStatus("默认", 0);

	public static final PrizeStatus PENDING = new PrizeStatus("未开奖", 1);
	public static final PrizeStatus DRAWN = new PrizeStatus("已开奖", 2);
	public static final PrizeStatus REWARDED = new PrizeStatus("已派奖", 3);
}
