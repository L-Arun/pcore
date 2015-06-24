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
 * 欧洲杯开奖状态
 */
public class EuroCupOrderStatus extends IntegerBeanLabelItem {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7009455804239792650L;

	private static final Logger logger = LoggerFactory.getLogger(EuroCupOrderStatus.class.getName());
	
	private static List<EuroCupOrderStatus> items = new ArrayList<EuroCupOrderStatus>();
	
	protected EuroCupOrderStatus(String name, int value) {
		super(EuroCupOrderStatus.class.getName(), name, value);
		items.add(this);
	}
	
	public static EuroCupOrderStatus getItem(int value){
		try {
			return (EuroCupOrderStatus)EuroCupOrderStatus.getResult(EuroCupOrderStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<EuroCupOrderStatus> getItems() {
		return items;
	}

	public static final EuroCupOrderStatus ALL = new EuroCupOrderStatus("全部", -1);
	
	public static final EuroCupOrderStatus NOT_PAID = new EuroCupOrderStatus(" 等待开奖", 0);
	public static final EuroCupOrderStatus PAID = new EuroCupOrderStatus("未中奖", 1);				
	public static final EuroCupOrderStatus RECHARGE = new EuroCupOrderStatus("等待派奖", 2);
	public static final EuroCupOrderStatus ERROR = new EuroCupOrderStatus("已派奖", 3);
}
