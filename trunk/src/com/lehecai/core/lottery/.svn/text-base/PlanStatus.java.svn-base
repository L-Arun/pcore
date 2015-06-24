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
 * 方案状态
 */
public class PlanStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 8815493451454402080L;

	private static final Logger logger = LoggerFactory.getLogger(PlanStatus.class.getName());
	
	private static List<PlanStatus> items = new ArrayList<PlanStatus>();
	
	protected PlanStatus(String name, int value) {
		super(PlanStatus.class.getName(), name, value);
		items.add(this);
	}
	
	public static PlanStatus getItem(int value){
		try {
			return (PlanStatus)PlanStatus.getResult(PlanStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<PlanStatus> getItems() {
		return items;
	}
	
	public static final PlanStatus ALL = new PlanStatus("全部", -1);
	public static final PlanStatus DEFAULT = new PlanStatus("默认", 0);

	public static final PlanStatus PAID_NOT = new PlanStatus("未支付", 1);
	public static final PlanStatus RECRUITING = new PlanStatus("招募中", 2);
	public static final PlanStatus PRINT_WAITING = new PlanStatus("待出票", 3);
	public static final PlanStatus PRINTED = new PlanStatus("已出票", 4);
	public static final PlanStatus CANCELLED = new PlanStatus("已撤单", 5);
	public static final PlanStatus ABORTED = new PlanStatus("未满员撤单", 6);
	public static final PlanStatus PRINTING = new PlanStatus("正在出票", 7);
	public static final PlanStatus PRINTED_PARTIAL = new PlanStatus("部分出票", 8);
	public static final PlanStatus UNPRINTED_OBSOLETE = new PlanStatus("未出票作废", 9);
	public static final PlanStatus PRINTED_FAILED = new PlanStatus("出票失败", 10);
	public static final PlanStatus CANCELLING = new PlanStatus("正在撤单", 11);		//client方案发起人合买撤单时，标记成此状态，由engine线程处理撤单返款
	public static final PlanStatus ABORTED_REFUNDING = new PlanStatus("未满员撤单返款中", 12);
	public static final PlanStatus PRINTED_FAILED_REFUNDING = new PlanStatus("出票失败返款中", 13);
	public static final PlanStatus UNPRINTED_OBSOLETE_REFUNDING = new PlanStatus("未出票作废返款中", 14);
	public static final PlanStatus NOTPAID_OBSOLETE = new PlanStatus("未支付作废", 15);
	public static final PlanStatus NOTPAID_OBSOLETEING = new PlanStatus("未支付作废中", 16);
}
