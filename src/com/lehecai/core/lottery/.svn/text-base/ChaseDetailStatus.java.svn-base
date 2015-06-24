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
 * 追号记录状态
 */
public class ChaseDetailStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 4434211286757130042L;

	private static final Logger logger = LoggerFactory.getLogger(ChaseDetailStatus.class.getName());
	
	private static List<ChaseDetailStatus> items = new ArrayList<ChaseDetailStatus>();
	
	protected ChaseDetailStatus(String name, int value) {
		super(ChaseDetailStatus.class.getName(), name, value);
		
		items.add(this);
	}
	
	public static ChaseDetailStatus getItem(int value){
		try {
			return (ChaseDetailStatus)ChaseDetailStatus.getResult(ChaseDetailStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<ChaseDetailStatus> getItems() {
		return items;
	}
	
	public static final ChaseDetailStatus ALL = new ChaseDetailStatus("全部", -1);
	public static final ChaseDetailStatus DEFAULT = new ChaseDetailStatus("默认", 0);
	
	public static final ChaseDetailStatus WAITING = new ChaseDetailStatus("等待追号", 1);
	public static final ChaseDetailStatus CREATE_ORDER_FAILURE = new ChaseDetailStatus("创建订单失败", 2);
	public static final ChaseDetailStatus PAY_FAILURE = new ChaseDetailStatus("支付失败", 3);
	public static final ChaseDetailStatus SUCCESS = new ChaseDetailStatus("追号成功", 4);
	public static final ChaseDetailStatus CANCELLED = new ChaseDetailStatus("撤销", 5);
	public static final ChaseDetailStatus CHASE_FAILURE = new ChaseDetailStatus("追号失败", 6);
}
