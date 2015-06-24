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
 * 是否用于提款
 */
public class WithWithdrawType extends IntegerBeanLabelItem {


	private static final long serialVersionUID = -530998782071935781L;

	private static final Logger logger = LoggerFactory.getLogger(WithWithdrawType.class.getName());
	
	private static List<WithWithdrawType> items = new ArrayList<WithWithdrawType>();
	
	protected WithWithdrawType(String name, int value) {
		super(WithWithdrawType.class.getName(), name, value);
		items.add(this);
	}
	
	public static WithWithdrawType getItem(int value){
		try {
			return (WithWithdrawType)WithWithdrawType.getResult(WithWithdrawType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<WithWithdrawType> getItems() {
		return items;
	}
	
	public static final WithWithdrawType NOT_USE = new WithWithdrawType("未使用", 0);
	public static final WithWithdrawType USED = new WithWithdrawType("已使用", 1);
	public static final WithWithdrawType PRIOR = new WithWithdrawType("优先使用", 2);
}
