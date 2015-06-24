/**
 * 
 */
package com.lehecai.core.api.bean.range.impl.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.api.bean.range.IRangePropHandleResult;

/**
 * @author qatang
 *
 */
public abstract class AbstractRangePropHandleResult implements IRangePropHandleResult {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private String begin;
	private String end;
	
	protected AbstractRangePropHandleResult(String begin, String end) {
		this.begin = begin;
		this.end = end;
	}
	
	@Override
	public String getBegin() {
		return begin;
	}
	
	@Override
	public String getEnd() {
		return end;
	}
}
