package com.lehecai.core.lottery;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * 方案票状态
 * @author leiming
 *
 */
public class PlanTicketStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 8815493451454402080L;

	private static final Logger logger = LoggerFactory.getLogger(PlanTicketStatus.class.getName());
	
	private static List<PlanTicketStatus> items = new ArrayList<PlanTicketStatus>();
	
	protected PlanTicketStatus(String name, int value) {
		super(PlanTicketStatus.class.getName(), name, value);
		items.add(this);
	}
	
	public static PlanTicketStatus getItem(int value){
		try {
			return (PlanTicketStatus)PlanTicketStatus.getResult(PlanTicketStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<PlanTicketStatus> getItems() {
		return items;
	}
	
	public static final PlanTicketStatus ALL = new PlanTicketStatus("全部", -1);
	public static final PlanTicketStatus DEFAULT = new PlanTicketStatus("默认", 0);

	public static final PlanTicketStatus CAN_NOT_SPLIT = new PlanTicketStatus("不可拆票", 1);
	public static final PlanTicketStatus CAN_SPLIT = new PlanTicketStatus("可拆票", 2);
	public static final PlanTicketStatus SPLIT_COMPLETED = new PlanTicketStatus("已拆票", 3);
	
}
