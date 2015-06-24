/**
 * 
 */
package com.lehecai.core.api.bean.range.impl.converter;

import com.lehecai.core.api.bean.query.IQueryProp;
import com.lehecai.core.api.bean.range.IRangeProp;
import com.lehecai.core.api.bean.range.IRangePropConverter;
import com.lehecai.core.api.bean.range.impl.prop.RegionRangeProp;

/**
 * @author qatang
 *
 */
public class RegionRangePropConverter implements IRangePropConverter {

	@Override
	public IRangeProp convert(IQueryProp queryPropItem) {
		RegionRangeProp rangeProp = new RegionRangeProp();
		rangeProp.setName(queryPropItem.getName());
		rangeProp.setBegin(queryPropItem.getValues()[0]);
		rangeProp.setEnd(queryPropItem.getValues()[1]);
		return rangeProp;
	}

}
