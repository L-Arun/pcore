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
 * 追号状态
 */
public class ChaseStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 4434211286757130042L;

	private static final Logger logger = LoggerFactory.getLogger(ChaseStatus.class.getName());
	
	private static List<ChaseStatus> items = new ArrayList<ChaseStatus>();
	
	protected ChaseStatus(String name, int value) {
		super(ChaseStatus.class.getName(), name, value);
		
		items.add(this);
	}
	
	public static ChaseStatus getItem(int value){
		try {
			return (ChaseStatus)ChaseStatus.getResult(ChaseStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<ChaseStatus> getItems() {
		return items;
	}
	
	public static final ChaseStatus ALL = new ChaseStatus("全部", -1);
	public static final ChaseStatus DEFAULT = new ChaseStatus("默认", 0);
	
	public static final ChaseStatus CHASING = new ChaseStatus("正在追号中", 1);
	public static final ChaseStatus COMPLETED = new ChaseStatus("追号完成", 2);
	public static final ChaseStatus STOPPED = new ChaseStatus("追号中奖中止", 3);
	public static final ChaseStatus CANCELLED = new ChaseStatus("追号撤销", 4);
	public static final ChaseStatus DRAWFAILED = new ChaseStatus("开奖失败撤销", 5);
}
