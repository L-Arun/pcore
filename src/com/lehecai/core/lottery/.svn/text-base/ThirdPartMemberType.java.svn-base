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
 * 银行列表
 */
public class ThirdPartMemberType extends IntegerBeanLabelItem {


	private static final long serialVersionUID = -530998782071935781L;

	private static final Logger logger = LoggerFactory.getLogger(ThirdPartMemberType.class.getName());
	
	private static List<ThirdPartMemberType> items = new ArrayList<ThirdPartMemberType>();
	
	protected ThirdPartMemberType(String name, int value) {
		super(ThirdPartMemberType.class.getName(), name, value);
		items.add(this);
	}
	
	public static ThirdPartMemberType getItem(int value){
		try {
			return (ThirdPartMemberType)ThirdPartMemberType.getResult(ThirdPartMemberType.class.getName(), value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static List<ThirdPartMemberType> getItems() {
		return items;
	}
	
	public static final ThirdPartMemberType ALL = new ThirdPartMemberType("全部", -1);
	
	public static final ThirdPartMemberType BAIDU = new ThirdPartMemberType("百度", 1);
	public static final ThirdPartMemberType ALIPAY = new ThirdPartMemberType("支付宝", 2);
	public static final ThirdPartMemberType ALIPAY_QUICKLOGIN = new ThirdPartMemberType("支付宝快捷", 3);
	public static final ThirdPartMemberType HOOPCHINA = new ThirdPartMemberType("虎扑", 4);
	public static final ThirdPartMemberType SINAWEIBO = new ThirdPartMemberType("新浪微博", 5);
	public static final ThirdPartMemberType CHINA = new ThirdPartMemberType("中华网", 6);
	public static final ThirdPartMemberType GANJI = new ThirdPartMemberType("赶集网", 7);
	public static final ThirdPartMemberType TENCENT = new ThirdPartMemberType("腾讯", 8);
	public static final ThirdPartMemberType CAIBAOBEI = new ThirdPartMemberType("彩宝贝", 9);
	public static final ThirdPartMemberType GOYOO = new ThirdPartMemberType("光音网络", 10);
	public static final ThirdPartMemberType SOHU = new ThirdPartMemberType("搜狐", 11);
	public static final ThirdPartMemberType BAOFENG = new ThirdPartMemberType("暴风影音", 12);
}
