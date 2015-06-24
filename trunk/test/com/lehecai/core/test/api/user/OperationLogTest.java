/**
 * 
 */
package com.lehecai.core.test.api.user;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.api.ApiConfig;
import com.lehecai.core.api.ApiConstant;
import com.lehecai.core.api.ApiRequest;
import com.lehecai.core.api.ApiRequestService;
import com.lehecai.core.api.ApiResponse;
import com.lehecai.core.api.user.CreditLog;
import com.lehecai.core.api.user.OperationLog;
import com.lehecai.core.exception.ApiRemoteCallFailedException;

/**
 * @author Sunshow
 *
 */
public class OperationLogTest {

	private static final Logger logger = LoggerFactory.getLogger(OperationLogTest.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws ApiRemoteCallFailedException {
		// 初始化config
		ApiConfig config = new ApiConfig();
		config.setBaseUrl("http://172.16.1.136/myl/trunk/control/admin");
		
		// 生成请求任务
		ApiRequest request = new ApiRequest();
		request.setUrl(ApiConstant.API_URL_OPERATION_LOG_QUERY);
		request.addOrder(CreditLog.ORDER_TIMELINE, ApiConstant.API_REQUEST_ORDER_DESC);
		request.setPage(1);
		request.setPagesize(ApiConstant.API_REQUEST_PAGESIZE_DEFAULT);
		logger.info("Request Query String: {}", request.toQueryString());
		
		ApiRequestService service = new ApiRequestService();
		service.setApiConfig(config);
		
		ApiResponse response = service.request(request, ApiConstant.API_REQUEST_TIME_OUT_DEFAULT);
		logger.info("request code = {}, message = {}", response.getCode(), response.getMessage());
		List<OperationLog> list = OperationLog.convertFromJSONArray(response.getData());
		for (Iterator<OperationLog> iterator = list.iterator(); iterator.hasNext();) {
			OperationLog log = iterator.next();
			logger.info("Log id={}, username={}", log.getId(), log.getUsername());
			logger.info("类型={}", log.getOperationType().getName());
		}
	}

}
