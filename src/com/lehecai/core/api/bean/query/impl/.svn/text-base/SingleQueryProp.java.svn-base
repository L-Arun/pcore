/**
 * 
 */
package com.lehecai.core.api.bean.query.impl;

import com.lehecai.core.api.bean.query.QueryOperator;


/**
 * @author qatang
 *
 */
public class SingleQueryProp extends AbstractQueryProp {
	private String value;
	
	public SingleQueryProp(String name, QueryOperator operator, String value) {
		super(name, operator);
		this.value = value;
	}
	
	@Override
	public String[] getValues() {
		String[] values = new String[1];
		values[0] = value;
		return values;
	}
}
