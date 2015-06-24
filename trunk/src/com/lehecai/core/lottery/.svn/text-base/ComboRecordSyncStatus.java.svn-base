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
 * 套餐同步状态
 * @author leiming
 *
 */
public class ComboRecordSyncStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 2038636173258022837L;

	private static final Logger logger = LoggerFactory.getLogger(ComboRecordSyncStatus.class.getName());
	
	private static List<ComboRecordSyncStatus> items = new ArrayList<ComboRecordSyncStatus>();
	
	protected ComboRecordSyncStatus(String name, int value) {
		super(ComboRecordSyncStatus.class.getName(), name, value);
		
		items.add(this);
	}
	
	public static ComboRecordSyncStatus getItem(int value){
		try {
			return (ComboRecordSyncStatus)ComboRecordSyncStatus.getResult(ComboRecordSyncStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<ComboRecordSyncStatus> getItems() {
		return items;
	}
	
	public static final ComboRecordSyncStatus ALL = new ComboRecordSyncStatus("全部", -1);
	public static final ComboRecordSyncStatus PENDING = new ComboRecordSyncStatus("套餐执行记录未同步", 0);
	public static final ComboRecordSyncStatus DONE = new ComboRecordSyncStatus("套餐执行记录已同步", 1);
	
}
