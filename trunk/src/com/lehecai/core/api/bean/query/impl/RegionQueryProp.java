/**
 * 
 */
package com.lehecai.core.api.bean.query.impl;

import com.lehecai.core.api.bean.query.QueryOperator;


/**
 * @author qatang
 *
 */
public class RegionQueryProp extends AbstractQueryProp {
	private String begin;
	private String end;
	
	public RegionQueryProp(String name, QueryOperator operator, String begin, String end) {
		super(name, operator);
		this.begin = begin;
		this.end = end;
	}
	
	@Override
	public String[] getValues() {
		String[] values = new String[2];
		values[0] = begin;
		values[1] = end;
		return values;
	}

}
