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
 * @author cs
 * 单场状态
 */
public class DcRaceStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 9133836199922834854L;

	private static final Logger logger = LoggerFactory.getLogger(DcRaceStatus.class.getName());
	
	private static List<DcRaceStatus> items = new ArrayList<DcRaceStatus>();
	private static List<DcRaceStatus> queryItems = new ArrayList<DcRaceStatus>();
	
	protected DcRaceStatus(String name, int value, boolean queryOnly) {
		super(DcRaceStatus.class.getName(), name, value);
		
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	protected DcRaceStatus(String name, int value) {
		this(name, value, false);
	}
	
	public static DcRaceStatus getItem(int value){
		try {
			return (DcRaceStatus)DcRaceStatus.getResult(DcRaceStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<DcRaceStatus> getItems() {
		return items;
	}
	public static List<DcRaceStatus> getItemsForQuery() {
		return queryItems;
	}
	
	public static final DcRaceStatus ALL = new DcRaceStatus("全部", -1, true);
	public static final DcRaceStatus NO_BUY = new DcRaceStatus("未销售", 1);
	public static final DcRaceStatus CAN_BUY = new DcRaceStatus("已开启", 2);
	public static final DcRaceStatus STOP_BUY = new DcRaceStatus("关闭", 3);
	public static final DcRaceStatus OPEN_BUY = new DcRaceStatus("已开奖", 4);
	public static final DcRaceStatus RETURN_PRIZE = new DcRaceStatus("已派奖", 5);
}
