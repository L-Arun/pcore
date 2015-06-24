/**
 * 
 */
package com.lehecai.core.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sunshow
 *
 */
public abstract class BaseApiRequest implements IApiRequest {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private String url;

	/* (non-Javadoc)
	 * @see com.lehecai.core.api.IApiRequest#getUrl()
	 */
	@Override
	public String getUrl() {
		return url;
	}

	/* (non-Javadoc)
	 * @see com.lehecai.core.api.IApiRequest#toQueryString()
	 */
	@Override
	abstract public String toQueryString();

	public void setUrl(String url) {
		this.url = url;
	}

}
