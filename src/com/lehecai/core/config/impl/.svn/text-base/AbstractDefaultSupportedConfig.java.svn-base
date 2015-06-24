/**
 * 
 */
package com.lehecai.core.config.impl;


/**
 * 支持默认属性的配置
 * @author sunshow
 *
 */
public abstract class AbstractDefaultSupportedConfig<T extends AbstractDefaultSupportedConfigItem> extends AbstractConfig {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 默认配置
	 */
	private T defaultConfigItem;

	protected String getDefaultKey() {
		return "default";
	}

	public T getDefaultConfigItem() {
		return defaultConfigItem;
	}

	public void setDefaultConfigItem(T defaultConfigItem) {
		this.defaultConfigItem = defaultConfigItem;
	}
	
}
