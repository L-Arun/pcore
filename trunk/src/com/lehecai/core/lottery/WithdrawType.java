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
 * 提款类型
 */
public class WithdrawType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 3116842341656386140L;

	private static final Logger logger = LoggerFactory.getLogger(WithdrawType.class.getName());
	
	private static List<WithdrawType> items = new ArrayList<WithdrawType>();
	
	protected WithdrawType(String name, int value) {
		super(WithdrawType.class.getName(), name, value);
		items.add(this);
	}
	
	public static WithdrawType getItem(int value){
		try {
			return (WithdrawType)WithdrawType.getResult(WithdrawType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<WithdrawType> getItems() {
		return items;
	}
	
	public static final WithdrawType ALL = new WithdrawType("全部", -1);
	public static final WithdrawType DEFAULT = new WithdrawType("默认", 0);
	public static final WithdrawType BANK = new WithdrawType("银行直汇", 1);
	public static final WithdrawType IPS = new WithdrawType("IPS转账", 2);
}
