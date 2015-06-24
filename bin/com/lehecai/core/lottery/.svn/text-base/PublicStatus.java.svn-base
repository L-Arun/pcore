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
 * 方案类型
 */
public class PublicStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 4751059016995873521L;

	private static final Logger logger = LoggerFactory.getLogger(PublicStatus.class.getName());
	
	private static List<PublicStatus> items = new ArrayList<PublicStatus>();
	
	protected PublicStatus(String name, int value) {
		super(PublicStatus.class.getName(), name, value);
		items.add(this);
	}
	
	public static PublicStatus getItem(int value){
		try {
			return (PublicStatus)PublicStatus.getResult(PublicStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<PublicStatus> getItems() {
		return items;
	}

	public static final PublicStatus ALL = new PublicStatus("全部", -1);
	public static final PublicStatus DEFAULT = new PublicStatus("默认", 0);
	
	public static final PublicStatus PRIVATE = new PublicStatus("不公开", 1);
	public static final PublicStatus PUBLIC = new PublicStatus("公开", 2);
	public static final PublicStatus PUBLIC_AFTER_TERMINATED = new PublicStatus("截止后公开", 3);
	public static final PublicStatus PUBLIC_AFTER_DREW = new PublicStatus("开奖后公开", 4);
	public static final PublicStatus PUBLIC_AFTER_WON = new PublicStatus("中奖后公开", 5);
}
