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
public class JclqStaticDrawStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 9133836199922834854L;

	private static final Logger logger = LoggerFactory.getLogger(JclqStaticDrawStatus.class.getName());
	
	private static List<JclqStaticDrawStatus> items = new ArrayList<JclqStaticDrawStatus>();
	private static List<JclqStaticDrawStatus> queryItems = new ArrayList<JclqStaticDrawStatus>();
	
	protected JclqStaticDrawStatus(String name, int value, boolean queryOnly) {
		super(JclqStaticDrawStatus.class.getName(), name, value);
		
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	protected JclqStaticDrawStatus(String name, int value) {
		this(name, value, false);
	}
	
	public static JclqStaticDrawStatus getItem(int value){
		try {
			return (JclqStaticDrawStatus)JclqStaticDrawStatus.getResult(JclqStaticDrawStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<JclqStaticDrawStatus> getItems() {
		return items;
	}
	public static List<JclqStaticDrawStatus> getItemsForQuery() {
		return queryItems;
	}
	
	public static final JclqStaticDrawStatus ALL = new JclqStaticDrawStatus("全部", -1 ,true);
	
	public static final JclqStaticDrawStatus UNOPEN = new JclqStaticDrawStatus("固定奖金不可开奖", 1);
	public static final JclqStaticDrawStatus OPEN = new JclqStaticDrawStatus("固定奖金可开奖", 2);
}
