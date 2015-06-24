/**
 * 
 */
package com.lehecai.core.api.bean.query.impl;

import java.util.List;

import com.lehecai.core.api.bean.query.QueryOperator;


/**
 * @author qatang
 *
 */
public class ListQueryProp extends AbstractQueryProp {
	private List<String> valueList;
	
	public ListQueryProp(String name, QueryOperator operator, List<String> valueList) {
		super(name, operator);
		this.valueList = valueList;
	}
	
	@Override
	public String[] getValues() {
		if (valueList == null) {
			return null;
		}
		return valueList.toArray(new String[valueList.size()]);
	}

}
