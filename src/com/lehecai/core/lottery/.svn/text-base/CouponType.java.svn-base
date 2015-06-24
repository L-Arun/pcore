package com.lehecai.core.lottery;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * @author liurd
 */
public class CouponType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 7743984145331545324L;

	private static final Logger logger = LoggerFactory.getLogger(CouponType.class.getName());
	
	private static List<CouponType> items = new ArrayList<CouponType>();
	private static List<CouponType> queryItems = new ArrayList<CouponType>();
	
	protected CouponType(String name, int value, boolean queryOnly) {
		super(CouponType.class.getName(), name, value);

		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	
	protected CouponType(String name, int value) {
		this(name, value, false);
	}
	
	public static CouponType getItem(int value){
		try {
			return (CouponType)CouponType.getResult(CouponType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<CouponType> getItems() {
		return items;
	}
	
	public static List<CouponType> getItemsForQuery() {
		return queryItems;
	}

	public static final CouponType ALL = new CouponType("全部", 0);
	
	public static final CouponType COUPON_TYPE_BASIC = new CouponType("未绑定", 1);
	public static final CouponType COUPON_TYPE_USER_BOUND = new CouponType("绑定用户", 2);
	public static final CouponType COUPON_TYPE_EVENT_BOUND = new CouponType("绑定活动（暂时不会有这个类型）", 3);
	public static final CouponType COUPON_TYPE_EVENT_USER_BOUND = new CouponType("单活动用户只能使用一张券", 4);

} 

