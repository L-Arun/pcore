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
 * 选号类型
 */
public class SelectType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = -2942202651621437036L;

	private static final Logger logger = LoggerFactory.getLogger(SelectType.class.getName());
	
	private static List<SelectType> items = new ArrayList<SelectType>();
	
	protected SelectType(String name, int value) {
		super(SelectType.class.getName(), name, value);
		items.add(this);
	}
	
	public static SelectType getItem(int value){
		try {
			return (SelectType)SelectType.getResult(SelectType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<SelectType> getItems() {
		return items;
	}

	public static final SelectType ALL = new SelectType("全部", -1);
	public static final SelectType DEFAULT = new SelectType("默认", 0);
	
	public static final SelectType UPLOAD = new SelectType("文件上传", 1);
	public static final SelectType CHOOSE_SELF = new SelectType("自选", 2);
	public static final SelectType RAND = new SelectType("机选", 3);
}
