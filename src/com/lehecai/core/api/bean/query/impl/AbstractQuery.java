/**
 * 
 */
package com.lehecai.core.api.bean.query.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.api.ApiRequestOrder;
import com.lehecai.core.api.ApiRequestRange;
import com.lehecai.core.api.bean.query.IQuery;
import com.lehecai.core.api.bean.query.IQueryProp;


/**
 * @author qatang
 *
 */
public abstract class AbstractQuery implements IQuery {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private List<IQueryProp> queryPropItemList;
	private ApiRequestRange range;
	private List<ApiRequestOrder> orderList;
	
	@Override
	public List<IQueryProp> getQueryPropItemList() {
		return queryPropItemList;
	}
	
	@Override
	public ApiRequestRange getRange() {
		return range;
	}
	
	@Override
	public List<ApiRequestOrder> getOrderList() {
		return orderList;
	}

	public void setQueryPropItemList(List<IQueryProp> queryPropItemList) {
		this.queryPropItemList = queryPropItemList;
	}

	public void setRange(ApiRequestRange range) {
		this.range = range;
	}

	public void setOrderList(List<ApiRequestOrder> orderList) {
		this.orderList = orderList;
	}
}
