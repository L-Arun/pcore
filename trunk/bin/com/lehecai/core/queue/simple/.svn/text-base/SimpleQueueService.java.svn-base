package com.lehecai.core.queue.simple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.queue.IQueueConfig;
import com.lehecai.core.queue.QueueConstant;
import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreHttpUtils;

public class SimpleQueueService {
	
private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private IQueueConfig simpleQueueConfig;

	public IQueueConfig getSimpleQueueConfig() {
		return simpleQueueConfig;
	}

	public void setSimpleQueueConfig(IQueueConfig simpleQueueConfig) {
		this.simpleQueueConfig = simpleQueueConfig;
	}
	
	public boolean putString(String queueName, String str) throws Exception {
		return this.putString(queueName, str, QueueConstant.HTTP_TIME_OUT_DEFAULT);
	}

	public boolean putString(String queueName, String str, int timeout_msec) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put(QueueConstant.SIMPLEQ_PARAM_TYPE, QueueConstant.SIMPLEQ_TYPE_PUT);
		params.put(QueueConstant.SIMPLEQ_PARAM_QUEUE, queueName);
		params.put(QueueConstant.SIMPLEQ_PARAM_DATA, str);
		
		List<String> result = CoreHttpUtils.postUrl(simpleQueueConfig.getEndpoint(), params, CharsetConstant.CHARSET_UTF8, timeout_msec);
		
		if (result == null || result.isEmpty()) {
			logger.error("队列服务响应不正确");
			return false;
		}
		
		String responseStr = result.get(0);
		logger.info("Response string: {}", responseStr);
		
		Map<String, String> map = CoreHttpUtils.parseQueryString(responseStr, CharsetConstant.CHARSET_UTF8);
		
		int rc = QueueConstant.RC_SUCCESS;
		try {
			rc = Integer.parseInt(map.get("rc"));
		} catch (NumberFormatException e) {
			logger.error("解析返回结果失败, rc = {}", map.get("rc"));
			return false;
		}
		
		String message = map.get("message");
		
		if (rc != QueueConstant.RC_SUCCESS) {
			logger.error("rc = {}, message = {}", rc, message);
			return false;
		}
		
		logger.info("放入队列任务成功, message = {}", message);
		return true;
	}
	
	public String getString(String queueName) throws Exception {
		return this.getString(queueName, QueueConstant.HTTP_TIME_OUT_DEFAULT);
	}
	
	public String getString(String queueName, int timeout_msec) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put(QueueConstant.SIMPLEQ_PARAM_TYPE, QueueConstant.SIMPLEQ_TYPE_GET);
		params.put(QueueConstant.SIMPLEQ_PARAM_QUEUE, queueName);
		
		List<String> result = CoreHttpUtils.postUrl(simpleQueueConfig.getEndpoint(), params, CharsetConstant.CHARSET_UTF8, timeout_msec);
		
		if (result == null || result.isEmpty()) {
			logger.error("队列服务响应不正确");
			return null;
		}
		
		String responseStr = result.get(0);
		logger.info("Response string: {}", responseStr);
		
		Map<String, String> map = CoreHttpUtils.parseQueryString(responseStr, CharsetConstant.CHARSET_UTF8);
		
		int rc = QueueConstant.RC_SUCCESS;
		try {
			rc = Integer.parseInt(map.get("rc"));
		} catch (NumberFormatException e) {
			logger.error("解析返回结果失败, rc = {}", map.get("rc"));
			return null;
		}
		
		String message = map.get("message");
		
		if (rc != QueueConstant.RC_SUCCESS) {
			logger.warn("rc = {}, message = {}", rc, message);
			return null;
		}
		
		logger.info("取出队列任务成功, message = {}", message);
		return map.get(QueueConstant.SIMPLEQ_PARAM_DATA);
	}
}
