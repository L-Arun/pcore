/**
 * 
 */
package com.lehecai.core.api;

import java.util.HashMap;
import java.util.Map;

import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreHttpUtils;

/**
 * @author Sunshow
 *
 */
public class DirectApiRequest extends BaseApiRequest {
	
	private Map<String, String> paramsWhere;
	
	public void setParameter(String key, String value) {
		if (paramsWhere == null) {
			synchronized (this) {
				if (paramsWhere == null) {
					paramsWhere = new HashMap<String, String>();
				}
			}
		}
		paramsWhere.put(key, value);
	}
	
	@Override
	public String toQueryString() {
		return CoreHttpUtils.getQueryString(paramsWhere, CharsetConstant.CHARSET_UTF8);
	}

}
