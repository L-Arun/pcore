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
 * 提成状态
 */
public class RebateStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(RebateStatus.class.getName());
	
	private static List<RebateStatus> items = new ArrayList<RebateStatus>();
	
	protected RebateStatus(String name, int value) {
		super(RebateStatus.class.getName(), name, value);
		
		items.add(this);
	}
	
	public static RebateStatus getItem(int value){
		try {
			return (RebateStatus)RebateStatus.getResult(RebateStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<RebateStatus> getItems() {
		return items;
	}
	
	public static final RebateStatus ALL = new RebateStatus("全部", -1);
	public static final RebateStatus DEFAULT = new RebateStatus("默认", 0);
	
	public static final RebateStatus NONEED = new RebateStatus("不需处理", 1);
	public static final RebateStatus PENDING = new RebateStatus("待处理", 2);
	public static final RebateStatus COMPLETED = new RebateStatus("已处理", 3);
}
