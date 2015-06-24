/**
 * 
 */
package com.lehecai.core.service.impl.message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.util.JSONUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.api.ApiConstant;
import com.lehecai.core.api.ApiRequest;
import com.lehecai.core.api.ApiRequestService;
import com.lehecai.core.api.ApiResponse;
import com.lehecai.core.api.MessageApiUrlConstant;
import com.lehecai.core.exception.ApiRemoteCallFailedException;
import com.lehecai.core.message.EventType;
import com.lehecai.core.service.message.MessageService;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreHttpUtils;

/**
 * @author gb
 * 以API为底层服务的消息实现
 */
public class ApiMessageServiceImpl implements MessageService {
	
	protected static final String KEY_NAME = "key";
	
	protected static final String COUNT_NAME = "count";
	
	protected static final String TASK_ID_NAME = "task_id";
	
	protected static final String TASK_DATA_NAME = "data";
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	private ApiRequestService apiRequestService;

	@Override
	public String[] consume(String key, int count) throws Exception {

		Map<String, String> params = new HashMap<String, String>();
		params.put(KEY_NAME, key);
		params.put(COUNT_NAME, String.valueOf(count));
		
		ApiRequest request = new ApiRequest();
		request.setUrl(CoreHttpUtils.getQueryUrl(MessageApiUrlConstant.MESSAGE_POP, params, CharsetConstant.CHARSET_UTF8));

		logger.info("Request Query String: {}", request.toQueryString());
		
		ApiResponse response = apiRequestService.request(request);
		
		if (response == null) {
			logger.error("获取消息异常");
			throw new ApiRemoteCallFailedException("获取消息异常");
		}
		if (response.getCode() != ApiConstant.RC_SUCCESS) {
			logger.error("获取消息失败, rc={}, message={}", response.getCode(), response.getMessage());
			throw new ApiRemoteCallFailedException("获取消息失败");
		}
		if (response.getData() == null || response.getData().isEmpty()) {
			logger.warn("获取消息为空, message={}", response.getMessage());
			return null;
		}

		List<String> resultList = new ArrayList<String>();
		
		int size = response.getData().size();
		for (int i = 0; i < size; i++) {
			Object object = response.getData().get(i);
			if (object == null || JSONUtils.isBoolean(object) || JSONUtils.isNull(object)) {
				continue;
			}
			resultList.add(object.toString());
		}
		
		if (resultList.isEmpty()) {
			return null;
		}

		return resultList.toArray(new String[resultList.size()]);
	}

	@Override
	public String consume(String key) throws Exception {
		int count = 1;
		String[] result = this.consume(key, count);

		if (result != null && result.length == count) {
			return result[0];
		}
		return null;
	}

	@Override
	public void publish(EventType eventType, String message) throws Exception {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put(TASK_ID_NAME, String.valueOf(eventType.getValue()));
		params.put(TASK_DATA_NAME, message);
		
		ApiRequest request = new ApiRequest();
		request.setUrl(CoreHttpUtils.getQueryUrl(MessageApiUrlConstant.ADD_TASK, params, CharsetConstant.CHARSET_UTF8));
		
		logger.info("Request Query String: {}", request.toQueryString());
		
		ApiResponse response = apiRequestService.request(request);
		
		if (response == null) {
			logger.error("发送消息{}异常", message);
			throw new ApiRemoteCallFailedException("发送消息异常");
		}
		if (response.getCode() != ApiConstant.RC_SUCCESS) {
			logger.error("发送消息{}失败", message);
			logger.error("发送消息失败, rc={}, message={}", response.getCode(), response.getMessage());
			throw new ApiRemoteCallFailedException("发送消息失败");
		}	
	}

	public ApiRequestService getApiRequestService() {
		return apiRequestService;
	}

	public void setApiRequestService(ApiRequestService apiRequestService) {
		this.apiRequestService = apiRequestService;
	}

}
