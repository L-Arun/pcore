/**
 * 
 */
package com.lehecai.core.event;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * @author chirowong
 * 欧洲杯竞猜类型
 */
public class EuroCupType extends IntegerBeanLabelItem {



	/**
	 * 
	 */
	private static final long serialVersionUID = 8383898733499785411L;

	private static final Logger logger = LoggerFactory.getLogger(EuroCupType.class.getName());
	
	private static List<EuroCupType> items = new ArrayList<EuroCupType>();
	
	protected EuroCupType(String name, int value) {
		super(EuroCupType.class.getName(), name, value);
		items.add(this);
	}
	
	public static EuroCupType getItem(int value){
		try {
			return (EuroCupType)EuroCupType.getResult(EuroCupType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<EuroCupType> getItems() {
		return items;
	}

	public static final EuroCupType ALL = new EuroCupType("全部", -1);
	
	public static final EuroCupType DCJCBDSPF = new EuroCupType("单场竞猜北单胜平负", 1);				
	public static final EuroCupType TOP8 = new EuroCupType("八强竞猜", 2);
	public static final EuroCupType TOP4 = new EuroCupType("四强竞猜", 3);
	public static final EuroCupType TOP1 = new EuroCupType("冠军竞猜", 4);
	public static final EuroCupType DCJCBDBF = new EuroCupType("单场竞猜北单比分", 5);
	public static final EuroCupType DCJCSPF = new EuroCupType("单场竞猜竞彩足球胜平负", 6);
	public static final EuroCupType DCJCBF = new EuroCupType("单场竞猜竞彩足球比分", 7);
}
