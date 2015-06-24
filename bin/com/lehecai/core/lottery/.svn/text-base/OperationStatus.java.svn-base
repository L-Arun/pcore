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
 * 操作结果状态
 */
public class OperationStatus extends IntegerBeanLabelItem {

	private static final Logger logger = LoggerFactory.getLogger(OperationStatus.class.getName());
	
	private static final long serialVersionUID = -2655180046354667807L;
	
	private static List<OperationStatus> items = new ArrayList<OperationStatus>();
	
	protected OperationStatus(String name, int value) {
		super(OperationStatus.class.getName(), name, value);
		items.add(this);
	}
	
	public static OperationStatus getItem(int value){
		try {
			return (OperationStatus)OperationStatus.getResult(OperationStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<OperationStatus> getItems() {
		return items;
	}

	public static final OperationStatus ALL = new OperationStatus("全部", -1);
	public static final OperationStatus PENDING = new OperationStatus("待处理", 0);
	public static final OperationStatus SUCCESSFUL = new OperationStatus("成功", 1);
	public static final OperationStatus FAILED = new OperationStatus("失败", 2);

}
