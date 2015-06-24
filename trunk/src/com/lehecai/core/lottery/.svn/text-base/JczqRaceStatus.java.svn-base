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
 * 竞彩足球状态
 */
public class JczqRaceStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 9133836199922834854L;

	private static final Logger logger = LoggerFactory.getLogger(JczqRaceStatus.class.getName());
	
	private static List<JczqRaceStatus> items = new ArrayList<JczqRaceStatus>();
	private static List<JczqRaceStatus> queryItems = new ArrayList<JczqRaceStatus>();
	
	protected JczqRaceStatus(String name, int value, boolean queryOnly) {
		super(JczqRaceStatus.class.getName(), name, value);
		
		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	protected JczqRaceStatus(String name, int value) {
		this(name, value, false);
	}
	
	public static JczqRaceStatus getItem(int value){
		try {
			return (JczqRaceStatus)JczqRaceStatus.getResult(JczqRaceStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<JczqRaceStatus> getItems() {
		return items;
	}
	public static List<JczqRaceStatus> getItemsForQuery() {
		return queryItems;
	}
	
	public static final JczqRaceStatus ALL = new JczqRaceStatus("全部", -1, true);
	public static final JczqRaceStatus UNOPEN = new JczqRaceStatus("未开启", 1);
	public static final JczqRaceStatus OPEN = new JczqRaceStatus("已开启", 2);
	public static final JczqRaceStatus CLOSE = new JczqRaceStatus("关闭", 3);
	public static final JczqRaceStatus DRAW = new JczqRaceStatus("已开奖", 4);
	public static final JczqRaceStatus REWARD = new JczqRaceStatus("已派奖", 5);
	public static final JczqRaceStatus RESULT_SET = new JczqRaceStatus("结果已公布", 6);
}
