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
 * @author yanweijie
 * 银行卡类型列表
 */
public class BankCardType extends IntegerBeanLabelItem {
	private static final long serialVersionUID = -530998782071935781L;
	private static final Logger logger = LoggerFactory.getLogger(BankCardType.class.getName());
	
	private static List<BankCardType> items = new ArrayList<BankCardType>();
	
	protected BankCardType(String name, int value) {
		super(BankCardType.class.getName(), name, value);
		items.add(this);
	}
	
	public static BankCardType getItem(int value){
		try {
			return (BankCardType)BankCardType.getResult(BankCardType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<BankCardType> getItems() {
		return items;
	}
	
	public static final BankCardType ALL = new BankCardType("全部", -1);
	public static final BankCardType IVR = new BankCardType("易联IVR语音充值", 1);
}
