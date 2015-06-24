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
 * 胜负过关即时SP值
 */
public class SfggSPType extends IntegerBeanLabelItem {


	private static final long serialVersionUID = 2465840431256917709L;

	private static final Logger logger = LoggerFactory.getLogger(SfggSPType.class.getName());
	
	private static List<SfggSPType> items = new ArrayList<SfggSPType>();
	
	protected SfggSPType(String name, int value) {
		super(SfggSPType.class.getName(), name, value);
		items.add(this);
	}
	
	public static SfggSPType getItem(int value){
		try {
			return (SfggSPType)SfggSPType.getResult(SfggSPType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<SfggSPType> getItems() {
		return items;
	}
	
	
	//胜负
	public static final SfggSPType SFP_S = new SfggSPType("胜平负-胜", 1);
	public static final SfggSPType SFP_F = new SfggSPType("胜负平-负",2);

	@Override
	public String toString() {
		return this.name;
	}

}
