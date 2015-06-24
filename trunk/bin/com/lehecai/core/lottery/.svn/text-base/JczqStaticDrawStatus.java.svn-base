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
 * 固定奖金开奖状态
 */
public class JczqStaticDrawStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 9133836199922834854L;

	private static final Logger logger = LoggerFactory.getLogger(JczqStaticDrawStatus.class.getName());
	
	private static List<JczqStaticDrawStatus> items = new ArrayList<JczqStaticDrawStatus>();
	private static List<JczqStaticDrawStatus> queryItems = new ArrayList<JczqStaticDrawStatus>();
	
	protected JczqStaticDrawStatus(String name, int value, boolean queryOnly) {
		super(JczqStaticDrawStatus.class.getName(), name, value);
		
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	protected JczqStaticDrawStatus(String name, int value) {
		this(name, value, false);
	}
	
	public static JczqStaticDrawStatus getItem(int value){
		try {
			return (JczqStaticDrawStatus)JczqStaticDrawStatus.getResult(JczqStaticDrawStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<JczqStaticDrawStatus> getItems() {
		return items;
	}
	public static List<JczqStaticDrawStatus> getItemsForQuery() {
		return queryItems;
	}
	
	public static final JczqStaticDrawStatus ALL = new JczqStaticDrawStatus("全部", -1 ,true);
	
	public static final JczqStaticDrawStatus UNOPEN = new JczqStaticDrawStatus("固定奖金不可开奖", 1);
	public static final JczqStaticDrawStatus OPEN = new JczqStaticDrawStatus("固定奖金可开奖", 2);
}
