/**
 * 
 */
package com.lehecai.core.api.bean.range.impl.prop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.api.bean.range.IRangeProp;

/**
 * @author qatang
 *
 */
public abstract class AbstractRangeProp implements IRangeProp {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private String name;
	
	protected AbstractRangeProp() {
		
	}
	
	protected AbstractRangeProp(String name) {
		this.setName(name);
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
