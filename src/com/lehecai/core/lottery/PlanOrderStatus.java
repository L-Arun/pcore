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
 * 方案订单状态
 */
public class PlanOrderStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = -6693180971917193980L;

	private static final Logger logger = LoggerFactory.getLogger(PlanOrderStatus.class.getName());
	
	private static List<PlanOrderStatus> items = new ArrayList<PlanOrderStatus>();
	
	protected PlanOrderStatus(String name, int value) {
		super(PlanOrderStatus.class.getName(), name, value);
		items.add(this);
	}
	
	public static PlanOrderStatus getItem(int value){
		try {
			return (PlanOrderStatus)PlanOrderStatus.getResult(PlanOrderStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<PlanOrderStatus> getItems() {
		return items;
	}
	
	public static final PlanOrderStatus ALL = new PlanOrderStatus("全部", -1);
	public static final PlanOrderStatus DEFAULT = new PlanOrderStatus("默认", 0);

	public static final PlanOrderStatus PAID_NOT = new PlanOrderStatus("未支付", 1);
	public static final PlanOrderStatus PAID = new PlanOrderStatus("已支付", 2);				// 冻结态
	public static final PlanOrderStatus REFUNDED = new PlanOrderStatus("已退款", 3);
	public static final PlanOrderStatus REFUNDED_PARTIAL = new PlanOrderStatus("部份退款", 4);
	
	public static final PlanOrderStatus CANCELLED = new PlanOrderStatus("已撤销", 5);
	public static final PlanOrderStatus PAID_FINISHED = new PlanOrderStatus("支付完成", 6);		// 从冻结态转支付态
	public static final PlanOrderStatus PAID_NOT_CANCELLED = new PlanOrderStatus("未支付作废", 7);	// 从未支付到撤销(作废)
}
