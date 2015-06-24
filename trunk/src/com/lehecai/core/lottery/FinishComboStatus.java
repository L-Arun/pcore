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
 * 完成套餐状态
 * @author leiming
 *
 */
public class FinishComboStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 2038636173258022837L;

	private static final Logger logger = LoggerFactory.getLogger(FinishComboStatus.class.getName());
	
	private static List<FinishComboStatus> items = new ArrayList<FinishComboStatus>();
	
	protected FinishComboStatus(String name, int value) {
		super(FinishComboStatus.class.getName(), name, value);
		
		items.add(this);
	}
	
	public static FinishComboStatus getItem(int value){
		try {
			return (FinishComboStatus)FinishComboStatus.getResult(FinishComboStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<FinishComboStatus> getItems() {
		return items;
	}
	
	public static final FinishComboStatus ALL = new FinishComboStatus("全部", -1);
	public static final FinishComboStatus DEFAULT = new FinishComboStatus("默认", 0);
	
	public static final FinishComboStatus PROCEEDING = new FinishComboStatus("进行中", 1);
	public static final FinishComboStatus FINISHED = new FinishComboStatus("已终止", 2);
	public static final FinishComboStatus CANCELED = new FinishComboStatus("已取消", 3);
	
}
