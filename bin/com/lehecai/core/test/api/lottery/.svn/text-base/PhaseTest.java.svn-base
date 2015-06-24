package com.lehecai.core.test.api.lottery;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.api.ApiConfig;
import com.lehecai.core.api.ApiConstant;
import com.lehecai.core.api.ApiRequest;
import com.lehecai.core.api.ApiRequestService;
import com.lehecai.core.api.ApiResponse;
import com.lehecai.core.api.lottery.Phase;
import com.lehecai.core.exception.ApiRemoteCallFailedException;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.PhaseType;

/**
 * 彩期测试
 * @author leiming
 *
 */
public class PhaseTest {
	private static final Logger logger = LoggerFactory.getLogger(PhaseTest.class.getName());
	public static void main(String[] args) throws ApiRemoteCallFailedException {
		// 初始化config
		ApiConfig config = new ApiConfig();
		config.setBaseUrl("http://a.dev.lehecai.cn");
		
		// 生成请求任务
		ApiRequest request = new ApiRequest();
		request.setUrl(ApiConstant.API_URL_PHASE_QUERY);
		request.setParameter(Phase.QUERY_PHASETYPE, String.valueOf(PhaseType.getItem(LotteryType.SFC).getValue()));//指定查询任选9场的所有彩期数据
		request.setPage(1);
		request.setPagesize(ApiConstant.API_REQUEST_PAGESIZE_DEFAULT);
		logger.info("Request Query String: {}", request.toQueryString());
		
		ApiRequestService service = new ApiRequestService();
		service.setApiConfig(config);
		
		
		ApiResponse response = service.request(request, ApiConstant.API_REQUEST_TIME_OUT_DEFAULT);
		logger.info("response code = {}, message = {}", response.getCode(), response.getMessage());
		List<Phase> list = Phase.convertFromJSONArray(response.getData());
		logger.info("查询共"+(list==null?"null":String.valueOf(list.size()))+"条数据");
		for (Iterator<Phase> iterator = list.iterator(); iterator.hasNext();) {
			Phase log = iterator.next();
			logger.info("phastType={}, phase={}", log.getPhaseType().getName(), log.getPhase());
		}
		
		//初始化彩期 创建指定彩期
		logger.info("初始化彩期开始");
		ApiRequest initRequest = new ApiRequest();
		initRequest.setUrl(ApiConstant.API_URL_PHASE_INIT_UPDATE);
		initRequest.setParameterForUpdate(Phase.SET_PHASETYPE, String.valueOf(PhaseType.getItem(LotteryType.SFC).getValue()));//指定初始化任选9场
		initRequest.setParameterForUpdate(Phase.SET_PHASE, "10088");//初始化期数20101001111
		logger.info("Request Query String: {}", initRequest.toQueryString());
		ApiResponse initResponse = service.request(initRequest, ApiConstant.API_REQUEST_TIME_OUT_DEFAULT);
		logger.info("response code = {}, message = {}", initResponse.getCode(), initResponse.getMessage());
		logger.info("初始化彩期结束");
		
		//验证
		logger.info("初始化彩期结果验证");
		ApiRequest checkRequest = new ApiRequest();
		checkRequest.setUrl(ApiConstant.API_URL_PHASE_QUERY);
		checkRequest.setParameter(Phase.QUERY_PHASETYPE, String.valueOf(PhaseType.getItem(LotteryType.SFC).getValue()));//指定查询任选9场的所有彩期数据
		checkRequest.setParameter(Phase.SET_PHASE, "10088");//指定查询任选9场的所有彩期数据
		checkRequest.setPage(1);
		checkRequest.setPagesize(ApiConstant.API_REQUEST_PAGESIZE_DEFAULT);
		ApiResponse checkResponse = service.request(checkRequest, ApiConstant.API_REQUEST_TIME_OUT_DEFAULT);
		logger.info("request code = {}, message = {}", checkResponse.getCode(), checkResponse.getMessage());
		logger.info("初始化彩期结果验证end...");
		
		//创建彩期
		logger.info("创建彩期开始");
		ApiRequest createRequest = new ApiRequest();
		createRequest.setUrl(ApiConstant.API_URL_PHASE_CREATE);
		createRequest.setParameterForUpdate(Phase.SET_PHASETYPE, String.valueOf(PhaseType.getItem(LotteryType.SD11X5).getValue()));//指定初始化任选9场
		createRequest.setParameterForUpdate(Phase.SET_CREATE_NUM, "10");//创建10期
		logger.info("Request Query String: {}", createRequest.toQueryString());
		ApiResponse createResponse = service.request(createRequest, ApiConstant.API_REQUEST_TIME_OUT_DEFAULT);
		logger.info("Response code = {}, message = {}", createResponse.getCode(), createResponse.getMessage());
		logger.info("创建彩期结束");
		
		//查询
		response = service.request(request, ApiConstant.API_REQUEST_TIME_OUT_DEFAULT);
		logger.info("request code = {}, message = {}", response.getCode(), response.getMessage());
		list = Phase.convertFromJSONArray(response.getData());
		logger.info("查询共"+(list==null?"null":String.valueOf(list.size()))+"条数据");
		for (Iterator<Phase> iterator = list.iterator(); iterator.hasNext();) {
			Phase log = iterator.next();
			logger.info("phastType={}, phase={}", log.getPhaseType().getName(), log.getPhase());
		}
		
		//修改彩期
		logger.info("修改彩期开始");
		ApiRequest updateRequest = new ApiRequest();
		updateRequest.setUrl(ApiConstant.API_URL_PHASE_UPDATE);
		updateRequest.setParameter(Phase.SET_PHASETYPE, String.valueOf(PhaseType.getItem(LotteryType.SFC).getValue()));//指定初始化任选9场
		updateRequest.setParameter(Phase.SET_PHASE, "10088");//修改10088期
		updateRequest.setParameterForUpdate(Phase.SET_RESULT_DETAIL, "aa");
		logger.info("Request Query String: {}", updateRequest.toQueryString());
		ApiResponse updateResponse = service.request(updateRequest);
		logger.info("Response code = {}, message = {}", updateResponse.getCode(), updateResponse.getMessage());
		logger.info("修改彩期结束");
		
		logger.info("修改彩期结果验证");
		checkRequest = new ApiRequest();
		checkRequest.setUrl(ApiConstant.API_URL_PHASE_QUERY);
		checkRequest.setParameter(Phase.QUERY_PHASETYPE, String.valueOf(PhaseType.getItem(LotteryType.SFC).getValue()));//指定查询任选9场的所有彩期数据
		checkRequest.setParameter(Phase.SET_PHASE, "10088");//指定查询任选9场的所有彩期数据
		checkRequest.setPage(1);
		checkRequest.setPagesize(ApiConstant.API_REQUEST_PAGESIZE_DEFAULT);
		checkResponse = service.request(checkRequest, ApiConstant.API_REQUEST_TIME_OUT_DEFAULT);
		logger.info("request code = {}, message = {}", checkResponse.getCode(), checkResponse.getMessage());
		logger.info("修改彩期结果验证end...");
		
	}
}
