/**
 * 
 */
package com.lehecai.core.test.api;

import com.lehecai.core.api.ApiConfig;
import com.lehecai.core.api.ApiRequestService;
import com.lehecai.core.lottery.LotteryType;
import com.lehecai.core.message.EventType;
import com.lehecai.core.message.phase.PhaseMessage;
import com.lehecai.core.service.impl.message.ApiMessageServiceImpl;

/**
 * @author gb
 *
 */
public class ApiMessagePublisherTest {

public static void main(String args[]) throws Exception {
		
		ApiConfig config = new ApiConfig();
		config.setBaseUrl("http://queue.kemeng.dev.lehecai.com");
		
		ApiRequestService apiRequestService = new ApiRequestService();
		apiRequestService.setApiConfig(config);
		
		ApiMessageServiceImpl messageService = new ApiMessageServiceImpl();
		messageService.setApiRequestService(apiRequestService);
		
		PhaseMessage message = new PhaseMessage();
		message.setEventType(EventType.LOTTERY_PHASE_PREDRAW_FINISH);
		message.setPhaseNo("11111");
		message.setLotteryType(LotteryType.SSQ);
		messageService.publish(EventType.LOTTERY_PHASE_PREDRAW_FINISH, message.toString());
		
	}
}
