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
 * 终端是否可出票的状态
 * 这里不是用YesNoStatus是为了以后可能的扩展
 */
public class TerminalStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 7800865957510748616L;

	private static final Logger logger = LoggerFactory.getLogger(TerminalStatus.class.getName());
	
	private static List<TerminalStatus> items = new ArrayList<TerminalStatus>();
	
	protected TerminalStatus(String name, int value) {
		super(TerminalStatus.class.getName(), name, value);
		
		items.add(this);
	}
	
	public static TerminalStatus getItem(int value){
		try {
			return (TerminalStatus)TerminalStatus.getResult(TerminalStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<TerminalStatus> getItems() {
		return items;
	}
	
	public static final TerminalStatus ENABLED = new TerminalStatus("可出票", 1);
	public static final TerminalStatus DISABLED = new TerminalStatus("不可出票", 2);
}
