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
 *
 */
public class WalletType extends IntegerBeanLabelItem {

	private static final Logger logger = LoggerFactory.getLogger(WalletType.class.getName());
	
	private static final long serialVersionUID = -2655180046354667807L;
	
	private static List<WalletType> items = new ArrayList<WalletType>();
	
	protected WalletType(String name, int value) {
		super(WalletType.class.getName(), name, value);
		items.add(this);
	}
	
	public static WalletType getItem(int value){
		try {
			return (WalletType)WalletType.getResult(WalletType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<WalletType> getItems() {
		return items;
	}

	public static final WalletType ALL = new WalletType("全部", -1);
	public static final WalletType SYSTEM = new WalletType("系统钱包", 0);	// 禁止使用
	
	public static final WalletType CASH = new WalletType("现金钱包", 1);
	public static final WalletType GIFT = new WalletType("彩金钱包", 2);
	
	public static final WalletType LEHECAI = new WalletType("内部钱包", 30);
	
	public static final WalletType COMBO = new WalletType("套餐钱包", 50);
	
	public static final WalletType LOTTERY_ZQDC = new WalletType("单场彩金钱包", 101);
	public static final WalletType LOTTERY_JCLQ = new WalletType("竞彩篮球彩金钱包", 102);
	public static final WalletType LOTTERY_SSQ = new WalletType("双色球彩金钱包", 103);
	public static final WalletType LOTTERY_GDKL10 = new WalletType("广东快乐十分彩金钱包", 104);
	public static final WalletType LOTTERY_SPORT = new WalletType("竞技彩彩金钱包", 105);
}
