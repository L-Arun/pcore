/**
 * 
 */
package com.lehecai.core.api;


/**
 * @author sunshow
 *
 */
public class SimpleObjectApiBatchUpdateItem implements IApiBatchUpdateItem {

	private String key;		// 要更新的记录的主键值
	
	private Object values;

	public void setParameterForUpdate(Object value) {
		values = value;
	}
	
	@Override
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public Object getValues() {
		return values;
	}
	
}
