/**
 * 
 */
package com.lehecai.core.service.setting;

import java.util.List;
import java.util.Map;

import com.lehecai.core.exception.ApiRemoteCallFailedException;


/**
 * @author Sunshow
 * 配置服务实现
 */
public interface SettingService {

	/**
	 * 获取配置
	 * @param group
	 * @param item
	 * @return
	 */
	public String get(String group, String item) throws ApiRemoteCallFailedException;
	
	/**
	 * 获取批量配置
	 * @param group
	 * @param itemList
	 * @return
	 */
	public Map<String, String> mget(String group, List<String> itemList) throws ApiRemoteCallFailedException;
	
	/**
	 * 增加新的配置项
	 * @param setting
	 * @return
	 */
	public boolean add(String group, String item) throws ApiRemoteCallFailedException;
	
	/**
	 * 更新配置
	 * 注:不带添加操作,如数据不存在请先添加数据项,再执行更新配置项操作
	 * @param group
	 * @param item
	 * @param value
	 * @return
	 */
	public boolean update(String group, String item, String value) throws ApiRemoteCallFailedException;
	
	/**
	 * 同步配置文件
	 * @param group
	 * @return
	 */
	public String sync() throws ApiRemoteCallFailedException;
}
