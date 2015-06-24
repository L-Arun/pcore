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
import com.lehecai.core.api.user.MemberConsumption;
import com.lehecai.core.exception.ApiRemoteCallFailedException;

/**
 * @author Sunshow
 *
 */
public class MemberConsumptionTest {

	private static final Logger logger = LoggerFactory.getLogger(MemberConsumptionTest.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws ApiRemoteCallFailedException {
		// 初始化config
		ApiConfig config = new ApiConfig();
		config.setBaseUrl("http://a.dev.lehecai.cn");
		
		// 生成请求任务
		ApiRequest request = new ApiRequest();
		request.setUrl(ApiConstant.API_URL_MEMBER_CONSUMPTION_QUERY);
		request.addOrder(MemberConsumption.ORDER_CONSUME_AMOUNT, ApiConstant.API_REQUEST_ORDER_DESC);
		request.setPage(1);
		request.setPagesize(ApiConstant.API_REQUEST_PAGESIZE_DEFAULT);
		logger.info("Request Query String: {}", request.toQueryString());
		
		ApiRequestService service = new ApiRequestService();
		service.setApiConfig(config);
		
		ApiResponse response = service.request(request, ApiConstant.API_REQUEST_TIME_OUT_DEFAULT);
		logger.info("request code = {}, message = {}", response.getCode(), response.getMessage());
		List<MemberConsumption> list = MemberConsumption.convertFromJSONArray(response.getData());
		for (Iterator<MemberConsumption> iterator = list.iterator(); iterator.hasNext();) {
			MemberConsumption log = iterator.next();
			logger.info("amount={}, username={}", log.getConsumeAmount(), log.getUsername());
		}
	}

}
