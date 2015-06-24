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
 * 竞彩篮球状态
 */
public class JclqRaceStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 9133836199922834854L;

	private static final Logger logger = LoggerFactory.getLogger(JclqRaceStatus.class.getName());
	
	private static List<JclqRaceStatus> items = new ArrayList<JclqRaceStatus>();
	private static List<JclqRaceStatus> queryItems = new ArrayList<JclqRaceStatus>();
	
	protected JclqRaceStatus(String name, int value, boolean queryOnly) {
		super(JclqRaceStatus.class.getName(), name, value);
		
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	protected JclqRaceStatus(String name, int value) {
		this(name, value, false);
	}
	
	public static JclqRaceStatus getItem(int value){
		try {
			return (JclqRaceStatus)JclqRaceStatus.getResult(JclqRaceStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<JclqRaceStatus> getItems() {
		return items;
	}
	public static List<JclqRaceStatus> getItemsForQuery() {
		return queryItems;
	}
	
	public static final JclqRaceStatus ALL = new JclqRaceStatus("全部", -1, true);
	public static final JclqRaceStatus UNOPEN = new JclqRaceStatus("未开启", 1);
	public static final JclqRaceStatus OPEN = new JclqRaceStatus("已开启", 2);
	public static final JclqRaceStatus CLOSE = new JclqRaceStatus("关闭", 3);
	public static final JclqRaceStatus DRAW = new JclqRaceStatus("已开奖", 4);
	public static final JclqRaceStatus REWARD = new JclqRaceStatus("已派奖", 5);
	public static final JclqRaceStatus RESULT_SET = new JclqRaceStatus("结果已公布", 6);
}
