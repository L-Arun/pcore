package com.lehecai.core.api;

import org.apache.commons.lang.StringUtils;

/**
 * 模拟select col1, col2, ...
 * @author sunshow
 *
 */
public class ApiRequestSelect {

	private String[] columns;
	
	public ApiRequestSelect(String[] columns) {
		this.columns = columns;
	}
	
	public String toString() {
		if (this.columns != null) {
			return StringUtils.join(columns, ",");
		}
		
		return "*";
	}
}
