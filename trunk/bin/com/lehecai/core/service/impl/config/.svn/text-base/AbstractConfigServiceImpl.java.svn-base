/**
 * 
 */
package com.lehecai.core.service.impl.config;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.config.ConfigParserMapping;
import com.lehecai.core.config.IConfig;
import com.lehecai.core.config.IConfigItem;
import com.lehecai.core.config.IConfigParser;
import com.lehecai.core.service.config.ConfigService;

/**
 * @author qatang
 *
 */
public abstract class AbstractConfigServiceImpl implements ConfigService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	/**
	 * 获取单一配置项
	 * @param group
	 * @param item
	 * @return
	 */
	abstract protected String getItemSettings(String group, String item);

	/**
	 * 批量获取配置项
	 * @param group
	 * @param itemList
	 * @return
	 */
	abstract protected Map<String, String> getItemSettings(String group, List<String> itemList);

	/**
	 * 更新单条配置
	 * @param group
	 * @param item
	 * @param value
	 * @return
	 */
	abstract protected boolean updateItemSettings(String group, String item, String value);
	
	protected IConfigParser getConfigParser(String group) {
		return ConfigParserMapping.getByGroup(group);
	}
	
	@Override
	public boolean delConfigByItem(IConfig iconfig, String item) throws Exception {
		return false;
	}
	
	@Override
	public IConfigItem getConfigItem(String group, String item) throws Exception {
		IConfigParser parser = this.getConfigParser(group);
		if (parser == null) {
			return null;
		}
		
		// 获取单条配置
		String value = this.getItemSettings(group, item);
		
		return parser.parseItem(value);
	}

	@Override
	public <T extends IConfigItem> T getConfigItem(String group, String item,
			Class<T> clazz) throws Exception {
		IConfigItem configItem = this.getConfigItem(group, item);
		if (configItem == null) {
			return null;
		}

		return clazz.cast(configItem);
	}

	@Override
	public IConfig getConfig(String group) throws Exception {
		logger.info("获取配置信息");
		if (group == null || group.equals("")) {
			logger.info("未得到配置组信息");
			return null;
		}
		IConfigParser parser = this.getConfigParser(group);
		if (parser == null) {
			logger.info("未找到[]对应解析器", group);
			return null;
		}
		List<String> itemList = parser.getItemList();
		if (itemList == null || itemList.size() == 0) {
			logger.info("未得到配置item信息");
			return null;
		}
		return this.getConfigWithItems(group, itemList);
	}

	@Override
	public <T extends IConfig> T getConfig(String group, Class<T> clazz)
			throws Exception {
		IConfig config = this.getConfig(group);
		if (config == null) {
			return null;
		}
		return clazz.cast(config);
	}

	@Override
	public <T extends IConfig> T getConfigWithItems(String group,
			List<String> itemList, Class<T> clazz) throws Exception {
		IConfig config = this.getConfigWithItems(group, itemList);
		if (config == null) {
			return null;
		}
		return clazz.cast(config);
	}

	@Override
	public IConfig getConfigWithItems(String group, List<String> itemList)
			throws Exception {
		logger.info("获取配置信息");
		if (group == null || group.equals("")) {
			logger.info("未得到配置组信息");
			return null;
		}
		if (itemList == null || itemList.isEmpty()) {
			logger.info("未指定任何配置项信息");
			return null;
		}
		IConfigParser parser = this.getConfigParser(group);
		if (parser == null) {
			logger.info("未找到[]对应解析器", group);
			return null;
		}
		Map<String, String> configMap = this.getItemSettings(group, itemList);
		if (configMap == null) {
			logger.info("未从api获取到配置信息");
			return null;
		}
		return parser.convertFromJSON(configMap);
	}


	@Override
	public boolean updateConfig(IConfig iconfig) throws Exception {
		logger.info("更新配置信息");
		String group = iconfig.getGroup();
		if (group == null || group.equals("")) {
			logger.info("未得到配置组信息");
			return false;
		}
		IConfigParser parser = this.getConfigParser(group);
		if (parser == null) {
			logger.info("未找到[{}]对应解析器", group);
			return false;
		}
		String config = parser.getConfig(iconfig);
		if (config == null || config.equals("")) {
			logger.info("配置对象转换为json串时，返回空值");
			return false;
		}
		
		JSONObject obj = JSONObject.fromObject(config);
		for (Iterator<?> iterator = obj.keySet().iterator(); iterator.hasNext();) {
			String item = (String) iterator.next();
			String value = obj.getString(item);
			logger.info("更新配置信息之前先调用添加操作，如果有则自动跳过，如果没有则添加");
			if (!this.updateItemSettings(group, item, value)) {
				logger.error("更新配置信息失败: group={}, item={}", new Object[]{group, item});
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean updateConfigByItem(IConfig iconfig, String item) throws Exception {
		logger.info("更新单个配置信息");
		String group = iconfig.getGroup();
		if (group == null || group.equals("")) {
			logger.info("未得到配置组信息");
			return false;
		}
		IConfigParser parser = this.getConfigParser(group);
		if (parser == null) {
			logger.info("未找到[{}]对应解析器", group);
			return false;
		}
		String config = parser.getConfigByItem(iconfig, item);
		if (config == null || config.equals("")) {
			logger.info("配置对象转换为json串时，返回空值");
			return false;
		}
		if (!this.updateItemSettings(group, item, config)) {
			logger.error("更新配置信息失败: group={}, item={}", new Object[]{group, item});
			return false;
		}
		return true;
	}

	@Override
	public boolean updateConfigItem(IConfigItem configItem, String group, String item) throws Exception {
		IConfigParser parser = this.getConfigParser(group);
		if (parser == null) {
			logger.info("未找到[{}]对应解析器", group);
			return false;
		}
		return this.updateItemSettings(group, item, parser.formatConfigItem(configItem));
	}
}
