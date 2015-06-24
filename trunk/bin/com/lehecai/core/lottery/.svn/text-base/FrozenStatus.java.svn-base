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
 * 
 * 冻结状态
 */
public class FrozenStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = -1454860113372053263L;

	private static final Logger logger = LoggerFactory.getLogger(FrozenStatus.class.getName());
	
	private static List<FrozenStatus> items = new ArrayList<FrozenStatus>();
	
	protected FrozenStatus(String name, int value) {
		super(FrozenStatus.class.getName(), name, value);
		items.add(this);
	}
	
	public static FrozenStatus getItem(int value){
		try {
			return (FrozenStatus)FrozenStatus.getResult(FrozenStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<FrozenStatus> getItems() {
		return items;
	}
	
	public static final FrozenStatus ALL = new FrozenStatus("全部", -1);
	public static final FrozenStatus FROZEN	 = new FrozenStatus("已冻结，未扣款", 0);	
	public static final FrozenStatus DEDUCT = new FrozenStatus("已扣款", 1);
	public static final FrozenStatus UNFREZEN = new FrozenStatus("取消冻结", 2);

}
