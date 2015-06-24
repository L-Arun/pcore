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
 * 追号类型
 */
public class ChaseType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 5142886365319084750L;

	private static final Logger logger = LoggerFactory.getLogger(ChaseType.class.getName());
	
	private static List<ChaseType> items = new ArrayList<ChaseType>();
	
	protected ChaseType(String name, int value) {
		super(ChaseType.class.getName(), name, value);
		
		items.add(this);
	}
	
	public static ChaseType getItem(int value){
		try {
			return (ChaseType)ChaseType.getResult(ChaseType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<ChaseType> getItems() {
		return items;
	}
	
	public static final ChaseType ALL = new ChaseType("全部", -1);
	public static final ChaseType DEFAULT = new ChaseType("默认", 0);
	
	public static final ChaseType CHOOSE_SELF = new ChaseType("自选追号", 1);
	public static final ChaseType CHOOSE_RANDOM = new ChaseType("机选追号", 2);
	public static final ChaseType CHOOSE_DINDAN = new ChaseType("定胆追号", 3);
}
