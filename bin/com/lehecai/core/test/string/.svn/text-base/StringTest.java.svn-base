/**
 * 
 */
package com.lehecai.core.test.string;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.lehecai.core.util.CoreStringUtils;

/**
 * @author Sunshow
 *
 */
public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String pattern = "My name is %s";
		String name = "Sunshow";
		
		System.out.println(String.format(pattern, name));
		
		double zero = 1099.08;
		double d = 11.1;
		double s = zero + d;
		System.out.println("s:"+String.valueOf(s));
		JSONObject js = new JSONObject();
		js.put("ss", s);
		System.out.println(js.toString());
		
		NumberFormat format = new DecimalFormat("#0.00");
        double a = 1.9;
        double b = 0.3;
        System.out.println(a+b);
        double y = Double.valueOf(format.format(a + b));
        System.out.println(y);

        build("My name is %s, %d years old", "Sunshow", 26);
        
        String phaseStr = "第11111期";
        System.out.println(CoreStringUtils.substringBetween(phaseStr, "第", "期"));
        System.out.println(StringUtils.substringBetween(phaseStr, "第", "期"));
	}

	public static void build(String pattern, Object... params) {
		System.out.println(String.format(pattern, params));
	}
}
