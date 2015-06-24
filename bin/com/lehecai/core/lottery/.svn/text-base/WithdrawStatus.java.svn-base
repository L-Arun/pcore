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
 * 提款处理状态
 */
public class WithdrawStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = -5135248031959470851L;

	private static final Logger logger = LoggerFactory.getLogger(WithdrawStatus.class.getName());
	
	private static List<WithdrawStatus> items = new ArrayList<WithdrawStatus>();
	
	protected WithdrawStatus(String name, int value) {
		super(WithdrawStatus.class.getName(), name, value);
		items.add(this);
	}
	
	public static WithdrawStatus getItem(int value){
		try {
			return (WithdrawStatus)WithdrawStatus.getResult(WithdrawStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<WithdrawStatus> getItems() {
		return items;
	}

	public static final WithdrawStatus ALL = new WithdrawStatus("全部", -1);
	public static final WithdrawStatus DEFAULT = new WithdrawStatus("默认", 0);
	public static final WithdrawStatus APPLYING = new WithdrawStatus("申请中", 1);
	public static final WithdrawStatus HANDLING = new WithdrawStatus("处理中", 2);
	public static final WithdrawStatus APPROVE = new WithdrawStatus("批准", 3);
	public static final WithdrawStatus REFUSE = new WithdrawStatus("拒绝", 4);
	public static final WithdrawStatus CANCELED = new WithdrawStatus("已撤销", 5);
	public static final WithdrawStatus REMITTED = new WithdrawStatus("已汇款", 6);
	public static final WithdrawStatus REMITFAILURE = new WithdrawStatus("汇款失败", 7);
	public static final WithdrawStatus DELAYED = new WithdrawStatus("推迟处理", 8);
	public static final WithdrawStatus AUDIT = new WithdrawStatus("提款审核", 9);
	public static final WithdrawStatus DELAYEDFOR1DAY = new WithdrawStatus("推迟1天处理", 10);
	public static final WithdrawStatus DELAYEDFOR15DAYS = new WithdrawStatus("推迟15天处理", 11);
	public static final WithdrawStatus REMITTANCE_REFUND = new WithdrawStatus("汇款退票", 12);

}
