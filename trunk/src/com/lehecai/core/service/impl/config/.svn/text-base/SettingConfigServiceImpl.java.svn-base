/**
 * 
 */
package com.lehecai.core.service.impl.config;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.lehecai.core.exception.ApiRemoteCallFailedException;
import com.lehecai.core.service.setting.SettingService;

/**
 * @author qatang
 *
 */
public class SettingConfigServiceImpl extends AbstractConfigServiceImpl {

	private SettingService settingService;

	@Override
	protected Map<String, String> getItemSettings(String group,
			List<String> itemList) {
		Map<String, String> configMap = null;
		try {
			configMap = settingService.mget(group, itemList);
		} catch (ApiRemoteCallFailedException e) {
			logger.error("通过setting service批量读取配置出错", e);
			logger.error("group={}, items={}", group, StringUtils.join(itemList, ","));
		}
		return configMap;
	}

	@Override
	protected String getItemSettings(String group, String item) {
		String value = null;
		try {
			value = settingService.get(group, item);
		} catch (ApiRemoteCallFailedException e) {
			logger.error("通过setting service读取配置出错", e);
			logger.error("group={}, item={}", group, item);
		}
		return value;
	}

	@Override
	protected boolean updateItemSettings(String group, String item, String value) {
		boolean result = false;
		try {
			settingService.add(group, item);
		} catch (ApiRemoteCallFailedException e) {
			logger.error(e.getMessage(), e);
		}
		try {
			result = settingService.update(group, item, value);
		} catch (ApiRemoteCallFailedException e) {
			logger.error("通过setting service更新配置出错", e);
			logger.error("group={}, item={}, value={}", new Object[]{group, item, value});
		}
		return result;
	}

	public SettingService getSettingService() {
		return settingService;
	}

	public void setSettingService(SettingService settingService) {
		this.settingService = settingService;
	}
}
