/**
 * 
 */
package com.lehecai.core.service.impl.setting;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.api.ApiConstant;
import com.lehecai.core.api.ApiRequest;
import com.lehecai.core.api.ApiRequestService;
import com.lehecai.core.api.ApiResponse;
import com.lehecai.core.api.SimpleApiBatchQueryItem;
import com.lehecai.core.api.SimpleApiRequestBatchQuery;
import com.lehecai.core.api.setting.Setting;
import com.lehecai.core.exception.ApiRemoteCallFailedException;
import com.lehecai.core.service.setting.SettingService;

/**
 * @author Sunshow
 *
 */
public class ApiSettingServiceImpl implements SettingService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private ApiRequestService apiRequestService;

	@Override
	public String get(String group, String item) throws ApiRemoteCallFailedException {
		ApiRequest request = new ApiRequest();
		request.setUrl(ApiConstant.API_URL_SETTINGS_QUERY);
		request.setParameter(Setting.QUERY_GROUP, group);
		request.setParameter(Setting.QUERY_ITEM, item);

		ApiResponse response = apiRequestService.request(request, ApiConstant.API_REQUEST_TIME_OUT_DEFAULT);
		if (response.getCode() != ApiConstant.RC_SUCCESS) {
			logger.error("API获取参数请求出错, rc={}, message={}", response.getCode(), response.getMessage());
			return null;
		}
		
		if (response.getData() == null || response.getData().isEmpty()) {
			logger.warn("API获取配置集为空, message={}", response.getMessage());
			return null;
		}
		
		return response.getData().getString(0);
	}

	/**
	 * 获取批量彩票配置
	 * @param group
	 * @param itemList
	 * @return
	 */
	@Override
	public Map<String,String> mget(String group, List<String> itemList) throws ApiRemoteCallFailedException {
		SimpleApiRequestBatchQuery request = new SimpleApiRequestBatchQuery();
		request.setUrl(ApiConstant.API_URL_SETTINGS_MULTI_QUERY);
		for (String item : itemList) {
			SimpleApiBatchQueryItem queryItem = new SimpleApiBatchQueryItem();
			queryItem.setParameter(Setting.QUERY_GROUP, group);					//设置group
			queryItem.setParameter(Setting.QUERY_ITEM, item);					//设置item
			
			request.add(queryItem);
		}

		ApiResponse response = apiRequestService.request(request, ApiConstant.API_REQUEST_TIME_OUT_DEFAULT);
		if (response.getCode() != ApiConstant.RC_SUCCESS) {
			logger.error("调用API获取批量配置请求失败, rc={}, message={}", response.getCode(), response.getMessage());
			return null;
		}
		if (response.getData() == null || response.getData().isEmpty()) {
			logger.warn("API获取批量配置数据为空, message={}", response.getMessage());
			return null;
		}
		
		Map<String,String> map = new HashMap<String,String>();
		Iterator<String> iter = itemList.iterator();
		JSONArray array = response.getData();		//返回的顺序和请求的彩票类型顺序一致
		int i = 0;
		while(iter.hasNext()) {
			String item = iter.next();
			logger.info(item + "，" + array.getString(i));
			map.put(item, array.getString(i)); //以彩票类型编码为键，以Json字符串作为值
			i ++;
		}
		return map;
	}
	
	@Override
	public boolean add(String group, String item) throws ApiRemoteCallFailedException {
		ApiRequest request = new ApiRequest();
		request.setUrl(ApiConstant.API_URL_SETTINGS_ADD);
		request.setParameterForUpdate(Setting.SET_GROUP, group);
		request.setParameterForUpdate(Setting.SET_ITEM, item);
		
		ApiResponse response = apiRequestService.request(request, ApiConstant.API_REQUEST_TIME_OUT_DEFAULT);
		if (response.getCode() != ApiConstant.RC_SUCCESS) {
			logger.error("API保存参数请求出错, rc={}, message={}", response.getCode(), response.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public String sync() throws ApiRemoteCallFailedException {
		ApiRequest request = new ApiRequest();
		request.setUrl(ApiConstant.API_URL_SETTINGS_SYNC);
		
		ApiResponse response = apiRequestService.request(request, ApiConstant.API_REQUEST_TIME_OUT_LONG);
		if (response == null) {
			logger.error("API同步参数请求失败,ApiResponse为空");
			throw new ApiRemoteCallFailedException("API同步参数请求失败,ApiResponse为空");
		}
		if (response.getCode() != ApiConstant.RC_SUCCESS) {
			logger.error("API同步参数请求出错, rc={}, message={}", response.getCode(), response.getMessage());
			return null;
		}
		if (response.getData() == null || response.getData().isEmpty()) {
			logger.warn("API同步参数请求信息数据为空, message={}", response.getMessage());
			return null;
		}
		return response.getData().getString(0);
	}

	@Override
	public boolean update(String group, String item, String value) throws ApiRemoteCallFailedException {
		ApiRequest request = new ApiRequest();
		request.setUrl(ApiConstant.API_URL_SETTINGS_UPDATE);
		request.setParameterForUpdate(Setting.SET_VALUE, value);
		
		request.setParameter(Setting.QUERY_GROUP, group);
		request.setParameter(Setting.QUERY_ITEM, item);
		
		logger.info("request string:{}", request.toQueryString());
		ApiResponse response = apiRequestService.request(request, ApiConstant.API_REQUEST_TIME_OUT_DEFAULT);
		if (response.getCode() != ApiConstant.RC_SUCCESS) {
			logger.error("API更新参数请求出错, rc={}, message={}", response.getCode(), response.getMessage());
			return false;
		}
		return true;
	}

	public void setApiRequestService(ApiRequestService apiRequestService) {
		this.apiRequestService = apiRequestService;
	}

}
