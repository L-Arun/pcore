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
 * 彩期状态
 */
public class PhaseStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 9133836199922834854L;

	private static final Logger logger = LoggerFactory.getLogger(PhaseStatus.class.getName());
	
	private static List<PhaseStatus> items = new ArrayList<PhaseStatus>();
	private static List<PhaseStatus> queryItems = new ArrayList<PhaseStatus>();
	
	protected PhaseStatus(String name, int value, boolean queryOnly) {
		super(PhaseStatus.class.getName(), name, value);
		
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	protected PhaseStatus(String name, int value) {
		this(name, value, false);
	}
	
	public static PhaseStatus getItem(int value){
		try {
			return (PhaseStatus)PhaseStatus.getResult(PhaseStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<PhaseStatus> getItems() {
		return items;
	}
	public static List<PhaseStatus> getItemsForQuery() {
		return queryItems;
	}
	
	public static final PhaseStatus ALL = new PhaseStatus("全部", -1 ,true);
	//public static final PhaseStatus DEFAULT = new PhaseStatus("默认", 0);
	
	public static final PhaseStatus UNOPEN = new PhaseStatus("未开启", 1);
	public static final PhaseStatus OPEN = new PhaseStatus("已开启", 2);
	public static final PhaseStatus CLOSE = new PhaseStatus("关闭", 3);
	public static final PhaseStatus RESULT_SET = new PhaseStatus("结果已公布", 6);
	public static final PhaseStatus DRAW = new PhaseStatus("已开奖", 4);
	public static final PhaseStatus REWARD = new PhaseStatus("已派奖", 5);
	public static final PhaseStatus DISABLED = new PhaseStatus("不可用", 9);
}
