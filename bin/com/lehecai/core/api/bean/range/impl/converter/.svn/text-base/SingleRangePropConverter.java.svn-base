/**
 * 
 */
package com.lehecai.core.api.bean.range.impl.converter;

import com.lehecai.core.api.bean.query.IQueryProp;
import com.lehecai.core.api.bean.range.IRangeProp;
import com.lehecai.core.api.bean.range.IRangePropConverter;
import com.lehecai.core.api.bean.range.impl.prop.SingleRangeProp;

/**
 * @author qatang
 *
 */
public class SingleRangePropConverter implements IRangePropConverter {

	@Override
	public IRangeProp convert(IQueryProp queryPropItem) {
		SingleRangeProp rangeProp = new SingleRangeProp();
		rangeProp.setName(queryPropItem.getName());
		rangeProp.setValue(queryPropItem.getValues()[0]);
		return rangeProp;
	}

}
