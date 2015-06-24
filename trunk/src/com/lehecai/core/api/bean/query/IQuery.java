/**
 * 
 */
package com.lehecai.core.api.bean.query;

import java.util.List;

import com.lehecai.core.api.ApiRequestOrder;
import com.lehecai.core.api.ApiRequestRange;

/**
 * @author qatang
 *
 */
public interface IQuery {

	public List<IQueryProp> getQueryPropItemList();
	
	public ApiRequestRange getRange();
	
	public List<ApiRequestOrder> getOrderList();

}
