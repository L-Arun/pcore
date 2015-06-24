/**
 * 
 */
package com.lehecai.core.api;

import net.sf.json.JSONObject;

/**
 * @author sunshow
 *
 */
public class SimpleApiBatchUpdateItem implements IApiBatchUpdateItem {

	private String key;		// 要更新的记录的主键值
	
	private JSONObject values = new JSONObject();

	public void setParameterForUpdate(String key, String value) {
		values.put(key, value);
	}
	
	@Override
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public JSONObject getValues() {
		return values;
	}
	
}
