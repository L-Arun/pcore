/**
 * 
 */
package com.lehecai.core.queue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreHttpUtils;

/**
 * @author Sunshow
 *
 */
public class QueueTaskService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private IQueueConfig queueConfig;
	
	public int postToQueue(IQueueTask queueTask) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("q", queueConfig.getQueue());
		logger.info("要添加的队列：{}", queueConfig.getQueue());
		
		params.put("p", queueTask.getTaskType());
		logger.info("任务类型：{}", queueTask.getTaskType());
		
		logger.info("要发送的数据：{}", queueTask.toJSONString());
		params.put("data", queueTask.toJSONString());
		logger.info("编码后的数据：{}", params.get("data"));
		
		params.put("datatype", queueTask.getDataType());
		
		if (queueTask.getExt() != null && !queueTask.getExt().isEmpty()) {
			logger.info("Ext info is: {}", queueTask.getExt());
			params.put("ext", queueTask.getExt());
		}
		
		if (queueTask.getCallback() != null && !queueTask.getCallback().isEmpty()) {
			logger.info("Callback URL is: {}", queueTask.getCallback());
			params.put("callback", queueTask.getCallback());
		}
		
		try {
			List<String> result = CoreHttpUtils.postUrl(queueConfig.getEndpoint(), params, CharsetConstant.CHARSET_UTF8, QueueConstant.HTTP_TIME_OUT_DEFAULT);
			
			if (result == null || result.isEmpty()) {
				logger.error("队列服务响应不正确");
				return QueueConstant.RC_FAILURE;
			}
			
			String responseStr = result.get(0);
			logger.info("Response string: {}", responseStr);
			
			Map<String, String> map = CoreHttpUtils.parseQueryString(responseStr, CharsetConstant.CHARSET_UTF8);
			
			int rc = QueueConstant.RC_SUCCESS;
			try {
				rc = Integer.parseInt(map.get("rc"));
			} catch (NumberFormatException e) {
				logger.error("解析返回结果失败, rc = {}", map.get("rc"));
				return QueueConstant.RC_FAILURE;
			}
			
			String message = map.get("message");
			
			if (rc != QueueConstant.RC_SUCCESS) {
				logger.error("rc = {}, message = {}", rc, message);
				return rc;
			}
			
			logger.info("放入队列任务成功, message = {}", message);
		} catch (IOException e) {
			logger.error("放入队列任务失败，queue={},data={}", queueConfig.getQueue(), queueTask.toJSONString());
			logger.error(e.getMessage(), e);
			return QueueConstant.RC_FAILURE;
		}
		
		return QueueConstant.RC_SUCCESS;
	}

	public void setQueueConfig(IQueueConfig queueConfig) {
		this.queueConfig = queueConfig;
	}
}
