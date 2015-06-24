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
 * @author CuiShuai
 * 来源状态
 */
public class SourceStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = -1454860113372053263L;

	private static final Logger logger = LoggerFactory.getLogger(SourceStatus.class.getName());
	
	private static List<SourceStatus> items = new ArrayList<SourceStatus>();
	
	protected SourceStatus(String name, int value) {
		super(SourceStatus.class.getName(), name, value);
		items.add(this);
	}
	
	public static SourceStatus getItem(int value){
		try {
			return (SourceStatus)SourceStatus.getResult(SourceStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<SourceStatus> getItems() {
		return items;
	}
	public static final SourceStatus ALL = new SourceStatus("全部", -1);
	public static final SourceStatus DISABLED = new SourceStatus("禁用", 0);
	public static final SourceStatus NORMAL = new SourceStatus("正常", 1);

}
