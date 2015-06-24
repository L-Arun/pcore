package com.lehecai.core.service.config;

import java.util.List;

import com.lehecai.core.config.IConfig;
import com.lehecai.core.config.IConfigItem;

public interface ConfigService {
	/**
	 * 得到配置对象
	 * @return IConfig
	 */
	public IConfig getConfig(String group) throws Exception;
	public <T extends IConfig> T getConfig(String group, Class<T> clazz) throws Exception;

	public IConfig getConfigWithItems(String group, List<String> itemList) throws Exception;
	public <T extends IConfig> T getConfigWithItems(String group, List<String> itemList, Class<T> clazz) throws Exception;
	
	/**
	 * 读取单条配置
	 * @param group
	 * @param item
	 * @return
	 * @throws Exception
	 */
	public IConfigItem getConfigItem(String group, String item) throws Exception;
	public <T extends IConfigItem> T getConfigItem(String group, String item, Class<T> clazz) throws Exception;

	/**
	 * 更新配置对象
	 * @return
	 */
	public boolean updateConfig(IConfig iconfig) throws Exception;
	/**
	 * 根据item更新单条配置
	 * @param item
	 * @return
	 */
	public boolean updateConfigByItem(IConfig iconfig, String item) throws Exception;
	
	/**
	 * 更新单条配置
	 * @param configItem
	 * @param group
	 * @param item
	 * @return
	 * @throws Exception
	 */
	public boolean updateConfigItem(IConfigItem configItem, String group, String item) throws Exception;


	/**
	 * 根据item删除单条配置
	 * @param item
	 * @return
	 */
	public boolean delConfigByItem(IConfig iconfig, String item) throws Exception;
}
