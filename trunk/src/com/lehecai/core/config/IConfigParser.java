/**
 * 
 */
package com.lehecai.core.config;

import java.util.List;
import java.util.Map;

/**
 * 基础配置信息对象解析接口
 * @author qatang
 *
 */
public interface IConfigParser {
	/**
	 * 得到item列表
	 * @return String
	 */
	public List<String> getItemList();

	public String getGlobalItemKey();
	
	public String getDefaultItemKey();

	public boolean hasDefaultItem();

	public boolean hasGlobalItem();
	
	/**
	 * 得到全部配置信息
	 * @return String
	 */
	public String getConfig(IConfig iconfig);
	/**
	 * 得到单一配置信息
	 * @param item
	 * @return String
	 */
	public String getConfigByItem(IConfig iconfig, String item);
	
	/**
	 * 格式化单条配置信息
	 * @param configItem
	 * @return
	 */
	public String formatConfigItem(IConfigItem configItem);
	
	/**
	 * @param jsonMap
	 * @return
	 */
	public IConfig convertFromJSON(Map<String, String> jsonMap);

	/**
	 * 解析单条配置
	 * @param value
	 * @return
	 */
	public IConfigItem parseItem(String value);
}
