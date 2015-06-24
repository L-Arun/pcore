package com.lehecai.core.lottery;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.IntegerBeanLabelItem;

/**
 * @author liurd
 */
public class CouponStatus extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 7743984145331545324L;

	private static final Logger logger = LoggerFactory.getLogger(CouponStatus.class.getName());
	
	private static List<CouponStatus> items = new ArrayList<CouponStatus>();
	private static List<CouponStatus> queryItems = new ArrayList<CouponStatus>();
	
	protected CouponStatus(String name, int value, boolean queryOnly) {
		super(CouponStatus.class.getName(), name, value);

		queryItems.add(this);
		if (!queryOnly) {
			items.add(this);
		}
	}
	
	protected CouponStatus(String name, int value) {
		this(name, value, false);
	}
	
	public static CouponStatus getItem(int value){
		try {
			return (CouponStatus)CouponStatus.getResult(CouponStatus.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<CouponStatus> getItems() {
		return items;
	}
	
	public static List<CouponStatus> getItemsForQuery() {
		return queryItems;
	}

	public static final CouponStatus ALL = new CouponStatus("全部", -1);
	
	public static final CouponStatus COUPON_STATUS_NOTINUSE = new CouponStatus("未激活", 0);
	public static final CouponStatus COUPON_STATUS_AVAILABLE = new CouponStatus("有效", 1);
	public static final CouponStatus COUPON_STATUS_EXPIRED = new CouponStatus("已过期", 2);
	public static final CouponStatus COUPON_STATUS_DISABLED = new CouponStatus("已禁用", 3);
	public static final CouponStatus COUPON_STATUS_DELETED = new CouponStatus("已删除", 4);
	public static final CouponStatus COUPON_STATUS_USED = new CouponStatus("已使用", 5);

}
