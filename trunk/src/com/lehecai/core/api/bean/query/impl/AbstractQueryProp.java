/**
 * 
 */
package com.lehecai.core.api.bean.query.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.api.bean.query.IQueryProp;
import com.lehecai.core.api.bean.query.QueryOperator;


/**
 * @author qatang
 *
 */
public abstract class AbstractQueryProp implements IQueryProp {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private String name;
	private QueryOperator operator;
	
	protected AbstractQueryProp(String name, QueryOperator operator) {
		this.name = name;
		this.operator = operator;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public QueryOperator getOperator() {
		return operator;
	}

}
