/**
 * 
 */
package com.lehecai.core.api.bean.range.impl.handler;

import java.util.Date;

import com.lehecai.core.util.CoreDateUtils;

/**
 * @author qatang
 *
 */
public class DateRangePropHandleResult extends AbstractRangePropHandleResult {

	public DateRangePropHandleResult(Date begin, Date end) {
		super(begin == null ? null : CoreDateUtils.formatDate(begin), end == null ? null : CoreDateUtils.formatDate(end));
	}
	
}
