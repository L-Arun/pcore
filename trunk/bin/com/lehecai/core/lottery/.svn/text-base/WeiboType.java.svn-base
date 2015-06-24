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
 * 微博类型
 * @author qatang
 * 
 */
public class WeiboType extends IntegerBeanLabelItem {


	private static final long serialVersionUID = -530998782071935781L;

	private static final Logger logger = LoggerFactory.getLogger(WeiboType.class.getName());
	
	private static List<WeiboType> items = new ArrayList<WeiboType>();
	
	protected WeiboType(String name, int value) {
		super(WeiboType.class.getName(), name, value);
		items.add(this);
	}
	
	public static WeiboType getItem(int value){
		try {
			return (WeiboType)WeiboType.getResult(WeiboType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<WeiboType> getItems() {
		return items;
	}
	
	public static final WeiboType SINA = new WeiboType("新浪微博", 1);
	public static final WeiboType TENCENT = new WeiboType("腾讯微博", 2);
	public static final WeiboType SOHU = new WeiboType("搜狐微博", 3);
}
