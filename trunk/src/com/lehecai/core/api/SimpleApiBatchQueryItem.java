/**
 * 
 */
package com.lehecai.core.api;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanweijie
 *
 */
public class SimpleApiBatchQueryItem implements IApiBatchQueryItem {

	 private List<ApiRequestWhere> values = new ArrayList<ApiRequestWhere>();
	 
	public void setParameter(String key, String value) {
		ApiRequestWhere parameter = new ApiRequestWhere(key, value, ApiConstant.API_OP_EQUAL);
		values.add(parameter);
	}

	@Override
	public List<ApiRequestWhere> getValues() {
		return values;
	}
	
}
