/**
 * 
 */
package com.lehecai.core.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 公用数学算法
 * @author sunshow
 *
 */
public class CoreMathUtils {

	/**
	 * 排列算法，P(n, m)
	 * @param n
	 * @param m
	 * @return
	 */
	public static long permute(int n, int m) {
		long num = 1;
		for (int i = 0; i < m; i ++) {
			num *= (n - i);
		}
		return num;
	}
	
	/**
	 * 组合算法，C(n, m) = P(n, m) / P(m, m)
	 * @param n
	 * @param m
	 * @return
	 */
	public static long combine(int n, int m) {
		long num = permute(n, m);
		num /= permute(m, m);
		return num;
	}
	/**
	 * 指定方式保留指定位数的小数<br/>
	 * RoundingMode.UP  有值取大值(有后续位数就进位)<br/>
	 * RoundingMode.DOWN  有值取小值(抹掉后续位数)<br/>
	 * RoundingMode.HALF_UP 四舍五入<br/>
	 * @param value
	 * @param count
	 * @param roundingMode
	 * @return
	 */
	public static double keepPointCountByMode(double value, int count,RoundingMode roundingMode){
		double keepValue = BigDecimal.valueOf(value).setScale(count,roundingMode).doubleValue();
		return keepValue;
	}
	/**
	 * 保留小数点位数(抹掉后续数字)
	 * @param value
	 * @param count
	 * @return
	 */
	public static double keepPointCount(double value, int count){
		double keepValue = BigDecimal.valueOf(value).setScale(count,RoundingMode.DOWN).doubleValue();
		return keepValue;
	}
	/**
	 * 保留小数点后2位(抹掉后续数字)
	 * @param value
	 * @return
	 */
	public static double keepPoint2Bit(double value){
		return keepPointCount(value, 2);
	}
	/**
	 * 保留小数点后4位(百分比后2位)(抹掉后续数字)
	 * @param value
	 * @return
	 */
	public static double keepPoint4Bit(double value){
		return keepPointCount(value, 4);
	}
	/**
	 * 四舍五入保留2位
	 * @param value
	 * @return
	 */
	public static double keepPointRound2Bit(double value){
		return keepPointCountByMode(value, 2, RoundingMode.HALF_UP);
	}
	/**
	 * 四舍五入保留4位
	 * @param value
	 * @return
	 */
	public static double keepPointRound4Bit(double value){
		return keepPointCountByMode(value, 4, RoundingMode.HALF_UP);
	}
}
