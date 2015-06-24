package com.lehecai.core.util;

import java.text.NumberFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 数字工具类
 * @author yanweijie
 *
 */
public class CoreNumberUtil {
	
	private static Logger logger = LoggerFactory.getLogger(CoreNumberUtil.class.getName());
	
	/**
	 * 格式化数字-设置不以','隔开并保留2位小数
	 * @param amount 被格式化的数字
	 * @return
	 */
	public static String formatNumBy2Digits(double amount){
		return CoreNumberUtil.formatNumber(amount, false, 2, 2);
	}
	
	/**
	 * 格式化数字-设置不以','隔开并保留0位小数
	 * @param amount 被格式化的数字
	 * @return
	 */
	public static String formatNumBy0Digits(double amount){
		return CoreNumberUtil.formatNumber(amount, false, 0, 0);
	}
	
	/**
	 * 格式化数字-设置是否以','隔开，设置最多小数位数，设置最少小数位数
	 * @param amount 被格式化的数字
	 * @param groupUsed 设置是否以','隔开
	 * @param maximumFractionDigits 设置最多小数位数
	 * @param minimumFractionDigits 设置最少小数位数
	 * @return
	 */
	public static String formatNumber(double amount, boolean groupUsed, 
			int maximumFractionDigits,int minimumFractionDigits) {
		try {
			NumberFormat format = NumberFormat.getInstance();
			
			format.setGroupingUsed(groupUsed);		//设成false，不以','隔开
			format.setMaximumFractionDigits(maximumFractionDigits);	//设置最多小数位数
			format.setMinimumFractionDigits(minimumFractionDigits);	//设置最少小数位数
			
			return format.format(amount);
		} catch (Exception e) {
			logger.error("格式化数据错误{}",e.getMessage());
			return null;
		}
	}
}
