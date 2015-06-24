/**
 * 
 */
package com.lehecai.core.type.ucenter;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * ucenter与子系统同步数据的方式
 * @author qatang
 * 
 */
public class SyncOperationType extends IntegerBeanLabelItem {
	private static final long serialVersionUID = 56751664345750721L;

	private static final Logger logger = LoggerFactory.getLogger(SyncOperationType.class.getName());
	
	private static List<SyncOperationType> items = new ArrayList<SyncOperationType>();
	
	protected SyncOperationType(String name, int value) {
		super(SyncOperationType.class.getName(), name, value);
		items.add(this);
	}
	
	public static SyncOperationType getItem(int value){
		try {
			return (SyncOperationType)SyncOperationType.getResult(SyncOperationType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<SyncOperationType> getItems() {
		return items;
	}

	public static final SyncOperationType CREATE = new SyncOperationType("创建", 1);				
	public static final SyncOperationType UPDATE = new SyncOperationType("修改", 2);
	public static final SyncOperationType DELETE = new SyncOperationType("删除", 3);
}
