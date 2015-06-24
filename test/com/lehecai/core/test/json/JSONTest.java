/**
 * 
 */
package com.lehecai.core.test.json;

import net.sf.json.JSONNull;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.util.CoreStringUtils;

/**
 * @author Sunshow
 *
 */
public class JSONTest {

	private static final Logger logger = LoggerFactory.getLogger(JSONTest.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JSONObject json = new JSONObject();
		json.put("key", "测试");
		
		String unicode = json.toString();
		logger.info("unicode编码后的字符串为：{}", unicode);
		
		logger.info("unicode解码后的字符串为：{}", CoreStringUtils.unicodeToString(unicode));
		
		logger.info(CoreStringUtils.unicodeToString("\u6821\u9a8c\u6570\u636e\u51fa\u9519"));
		
		json = JSONObject.fromObject("{\"test\":null}");
		System.out.println(json.getJSONObject("test"));
		System.out.println(json.get("test") instanceof JSONNull);
	}

}
