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
 * 平台类型
 */
public class PlatformType extends IntegerBeanLabelItem {


	private static final long serialVersionUID = -530998782071935781L;

	protected static final Logger logger = LoggerFactory.getLogger(PlatformType.class.getName());
	
	private static List<PlatformType> items = new ArrayList<PlatformType>();
	private static List<PlatformType> _items = new ArrayList<PlatformType>();
	
	protected PlatformType(String name, int value) {
		super(PlatformType.class.getName(), name, value);
		if (value != -1) {
			_items.add(this);
		}
		items.add(this);
	}
	
	public static PlatformType getItem(int value) {
		// 平台号存在特殊定义，需要做特殊处理
		if (contain(value)) {
			// 对于存在的定义，直接返回实际类型
			return (PlatformType)PlatformType.getResult(PlatformType.class.getName(), value);
		}
		// > 1000，都认为是新版手机客户端使用的OPENAPI
		if (value > 1000) {
			return USER_PLATFORM_OPENAPI;
		}
		// 其他情况，返回未知
		return UNKNOWN;
	}
	
	public static boolean contain(int value) {
		return PlatformType.contain(PlatformType.class.getName(), value);
	}
	
	public static List<PlatformType> getItems() {
		return items;
	}
	
	public static List<PlatformType> getSelectItems() {
		return _items;
	}
	
	public static final PlatformType ALL = new PlatformType("全部", -1);

	public static final PlatformType UNKNOWN = new PlatformType("未知", 0);
	
	public static final PlatformType USER_PLATFORM_MAIN = new PlatformType("网页主平台", 1);
	public static final PlatformType USER_PLATFORM_WAP = new PlatformType("WAP", 2);
	public static final PlatformType USER_PLATFORM_ADMIN = new PlatformType("后台", 3);
	public static final PlatformType USER_PLATFORM_OPENAPI = new PlatformType("OPENAPI", 4);

	public static final PlatformType USER_PLATFORM_WAP_HOOPCHINA = new PlatformType("WAP_hoopchina", 200);
	public static final PlatformType USER_PLATFORM_WAP_78500 = new PlatformType("WAP_78500", 201);
	public static final PlatformType USER_PLATFORM_WAP_HICLOUD = new PlatformType("WAP_HICLOUD", 202);
	
	public static final PlatformType USER_PLATFORM_MOBILE_J2ME = new PlatformType("j2me客户端", 100);
	public static final PlatformType USER_PLATFORM_MOBILE_IPHONE = new PlatformType("iphone客户端", 101);
	public static final PlatformType USER_PLATFORM_MOBILE_ANDROID = new PlatformType("android客户端", 102);
	public static final PlatformType USER_PLATFORM_MOBILE_KJAVA = new PlatformType("kjava客户端", 103);

	public static final PlatformType USER_PLATFORM_MOBILE_GENERIC = new PlatformType("默认的手机客户端", 999);
	
	public static final PlatformType USER_PLATFORM_MAIN_BAIDU = new PlatformType("网页主平台_baidu", 500);
	public static final PlatformType USER_PLATFORM_MAIN_SOHU = new PlatformType("网页主平台_sohu", 501);
	public static final PlatformType USER_PLATFORM_MAIN_HOOPCHINA = new PlatformType("网页主平台_hoopchina", 502);
	public static final PlatformType USER_PLATFORM_MAIN_GANJI = new PlatformType("网页主平台_ganji", 503);
	public static final PlatformType USER_PLATFORM_MAIN_CHINA = new PlatformType("网页主平台_china", 504);
	public static final PlatformType USER_PLATFORM_MAIN_VIP = new PlatformType("网页主平台_vip", 505);
	public static final PlatformType USER_PLATFORM_MAIN_78500 = new PlatformType("网页主平台_78500", 506);
	public static final PlatformType USER_PLATFORM_MAIN_BAOFENG = new PlatformType("网页主平台_baofeng", 507);
	
}
