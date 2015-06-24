package com.lehecai.core.test.lottery.lotteryconfig;

import net.spy.memcached.compat.log.Logger;
import net.spy.memcached.compat.log.LoggerFactory;

import com.lehecai.core.api.ApiConfig;
import com.lehecai.core.api.ApiRequestService;
import com.lehecai.core.api.lottery.LotteryConfig;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.lottery.lotteryconfig.LotteryConfigCacheBuilder;
import com.lehecai.core.service.impl.setting.ApiSettingServiceImpl;

public class LotteryConfigTest {
	private static final Logger logger = LoggerFactory.getLogger(LotteryConfigTest.class);
	public static void main(String[] args){
		LotteryConfigCacheBuilder builder = new LotteryConfigCacheBuilder();
		
		ApiSettingServiceImpl settingService = new ApiSettingServiceImpl();
		ApiRequestService apiRequestService = new ApiRequestService();
		ApiConfig apiConfig = new ApiConfig();
		String baseUrl = "http://a.dev.lehecai.cn";
		apiConfig.setBaseUrl(baseUrl);
		apiRequestService.setApiConfig(apiConfig);
		settingService.setApiRequestService(apiRequestService);
		
		builder.setSettingService(settingService);
		LotteryConfig lotteryConfig = builder.build(LotteryType.DLT);
		lotteryConfig.toString();
		logger.info("测试结束");
		
	}
}
