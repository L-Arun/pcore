/**
 * 
 */
package com.lehecai.core.api;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.exception.ApiRemoteCallFailedException;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreHttpUtils;
import com.lehecai.core.util.CoreStringUtils;
import com.lehecai.core.warning.IWarningTool;
import com.lehecai.core.warning.WarningType;

/**
 * @author Sunshow
 *
 */
public class ApiRequestService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private IWarningTool warningTool;
	
	private int warningFailedCount = 10;
	
	private volatile int failedCount = 0; 
	
	private ApiConfig apiConfig;

	public ApiResponse request(ApiConfig apiConfig, IApiRequest apiRequest, int timeout_msec) throws ApiRemoteCallFailedException {
		if (apiRequest == null) {
			return null;
		}
		
		logger.info("api call url: {}{}", apiConfig.getBaseUrl(), apiRequest.getUrl());
		try {
			logger.info("request query string: {}", CoreStringUtils.unicodeToString(URLDecoder.decode(apiRequest.toQueryString(), CharsetConstant.CHARSET_UTF8)));
		} catch (UnsupportedEncodingException e2) {
			logger.error(e2.getMessage(),e2);
		}
		ApiResponse response = new ApiResponse();
		try {
			// 拼接默认参数
			StringBuffer queryString = new StringBuffer();
			if (apiConfig.getParameters() != null) {
				queryString.append(CoreHttpUtils.getQueryString(apiConfig.getParameters(), CharsetConstant.CHARSET_UTF8));
			}
			if (queryString.length() > 0) {
				queryString.append("&");
			}
			queryString.append(apiRequest.toQueryString());
			
			String responseStr = null;
			//HttpURLConnection 方式的Http请求
			List<String> result = CoreHttpUtils.postUrl(apiConfig.getBaseUrl() + apiRequest.getUrl(), queryString.toString(), CharsetConstant.CHARSET_UTF8, timeout_msec);
			if (result == null || result.isEmpty()) {
				this.increaseFailedCount();
				logger.error("响应结果为空，非法");
				throw new ApiRemoteCallFailedException("API响应结果为空");
			}
			
			responseStr = result.get(0);
			/*
			// 采用 connectionManager 方式 做http请求  暂时不用
			responseStr = CoreHttpUtils.urlPostMethod(apiConfig.getBaseUrl() + apiRequest.getUrl(), queryString.toString(), CharsetConstant.CHARSET_UTF8, timeout_msec);
			if (responseStr == null || responseStr.isEmpty()) {
				this.increaseFailedCount();
				logger.error("响应结果为空，非法");
				throw new ApiRemoteCallFailedException("API响应结果为空");
			}
			*/
			// 转换unicode到可识别的中文
			responseStr = CoreStringUtils.unicodeToString(responseStr);
			logger.info("Response string: {}", responseStr);

			JSONObject json = null;
			try {
				json = JSONObject.fromObject(responseStr);
			} catch (Exception e) {
				this.increaseFailedCount();
				logger.error("API调用返回结果格式不正确", e);
				logger.error("responseStr: {}", responseStr);
				throw new ApiRemoteCallFailedException("API响应结果Json转换出错");
			}
			
			if (json == null) {
				return response;
			}
			try {
				response.setCode(json.getInt(ApiConstant.API_RESPONSE_CODE_NAME));
			} catch (Exception e) {
				this.increaseFailedCount();
				logger.error("API调用返回码不正确", e);
				logger.error("responseStr: {}", responseStr);
				response.setCode(ApiConstant.RC_FAILURE);
				response.setMessage("未取到合法的返回值");
				return response;
			}
			
			try {
				response.setTotal(json.getInt(ApiConstant.API_RESPONSE_TOTAL_NAME));
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			
			response.setMessage(json.getString(ApiConstant.API_RESPONSE_MESSAGE_NAME));
			if (response.getMessage() != null) {
				logger.info("返回消息，message={}", response.getMessage());
			}
			if (json.containsKey(ApiConstant.API_RESPONSE_DATA_NAME)) {
				try {
					response.setData(json.getJSONArray(ApiConstant.API_RESPONSE_DATA_NAME));
				} catch (Exception e) {
					this.increaseFailedCount();
					logger.error("不正确的返回数据");
					logger.error(e.getMessage(), e);
					throw new ApiRemoteCallFailedException("API响应结果数据不正确");
				}
			}
			try {
				if (json.containsKey(ApiConstant.API_RESPONSE_DEBUGTIME_NAME)) {
					response.setDebugTime(json.getDouble(ApiConstant.API_RESPONSE_DEBUGTIME_NAME));
				}
			} catch (Exception e) {
				logger.error("调试时间不正确");
				logger.error(e.getMessage(), e);
			}
			
			if (response.getCode() != ApiConstant.RC_SUCCESS) {
				logger.error("API请求失败，code={}", response.getCode());
				logger.error("request url is: {}{}, parameter is: {}", new Object[] {apiConfig.getBaseUrl(), apiRequest.getUrl(), CoreStringUtils.unicodeToString(URLDecoder.decode(apiRequest.toQueryString(), CharsetConstant.CHARSET_UTF8))});
				logger.error("response content is: {}", responseStr);
			}
			
			this.resetFailedCount();
		} catch (Exception e) {
			this.increaseFailedCount();
			try {
				logger.error("AP请求失败, request url is: {}{}, parameter is: {}", new Object[] {apiConfig.getBaseUrl(), apiRequest.getUrl(), CoreStringUtils.unicodeToString(URLDecoder.decode(apiRequest.toQueryString(), CharsetConstant.CHARSET_UTF8))});
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
			}
			logger.error(e.getMessage(), e);
			throw new ApiRemoteCallFailedException("API请求失败");
		}
		
		return response;
	}
	
	public ApiResponse request(IApiRequest apiRequest, int timeout_msec) throws ApiRemoteCallFailedException {
		return this.request(this.apiConfig, apiRequest, timeout_msec);
	}
	
	public ApiResponse request(IApiRequest apiRequest) throws ApiRemoteCallFailedException {
		int timeout = ApiConstant.API_REQUEST_TIME_OUT_DEFAULT;
		
		try {
			String systemTimeoutProperty = System.getProperty(ApiConstant.API_REQUEST_TIME_OUT_PROPERTY_NAME);
			if (systemTimeoutProperty != null) {
				int timeoutProperty = Integer.parseInt(systemTimeoutProperty);
				if (timeoutProperty > 0) {
					timeout = timeoutProperty;
				}
			}
		} catch (Exception e) {
			logger.error("读取系统配置出错: {}", ApiConstant.API_REQUEST_TIME_OUT_PROPERTY_NAME);
			logger.error(e.getMessage(), e);
		}
		
		return request(apiRequest, timeout);
	}
	
	/**
	 * 增加失败计数
	 */
	protected void increaseFailedCount() {
		int failedCountLocal = 0;
		synchronized (this) {
			this.failedCount ++;
			failedCountLocal = this.failedCount;
		}
		logger.error("API调用失败计数：{}", failedCountLocal);
		if (this.warningFailedCount > 0 && this.warningTool != null && failedCountLocal == this.warningFailedCount) {
			// 发送报警短信
			try {
				this.warningTool.sendSMS(WarningType.API_CALL_FAILED, "API请求失败达到" + failedCountLocal + "次");
			} catch (Exception e) {
				logger.error("发送短信失败", e);
			}
		}
	}
	
	/**
	 * 重设失败计数
	 */
	protected void resetFailedCount() {
		synchronized (this) {
			this.failedCount = 0;
		}
	}
	
	public void setApiConfig(ApiConfig apiConfig) {
		this.apiConfig = apiConfig;
	}

	public int getFailedCount() {
		return failedCount;
	}

	public IWarningTool getWarningTool() {
		return warningTool;
	}

	public void setWarningTool(IWarningTool warningTool) {
		this.warningTool = warningTool;
	}

	public int getWarningFailedCount() {
		return warningFailedCount;
	}

	public void setWarningFailedCount(int warningFailedCount) {
		this.warningFailedCount = warningFailedCount;
	}
	
}
