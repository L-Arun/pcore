/**
 * 
 */
package com.lehecai.core.test.api;

import com.lehecai.core.api.ApiConfig;
import com.lehecai.core.api.ApiRequestService;
import com.lehecai.core.message.MessageConsumer;
import com.lehecai.core.service.impl.message.ApiMessageServiceImpl;

/**
 * @author gb
 *
 */
public class ApiMessageConsumerTest {

	public static void main(String args[]) throws Exception {
		
		ApiConfig config = new ApiConfig();
		config.setBaseUrl("http://queue.kemeng.dev.lehecai.com");
		
		ApiRequestService apiRequestService = new ApiRequestService();
		apiRequestService.setApiConfig(config);

		ApiMessageServiceImpl messageService = new ApiMessageServiceImpl();
		messageService.setApiRequestService(apiRequestService);

		MessageConsumer consumer = new MessageConsumer();
		consumer.setMessageService(messageService);
		consumer.setCount(1);
		consumer.setMessageKey("pstatistic");
		
		String[] messages = consumer.receiveNoWait();
		for (String msg : messages) {
			System.out.println(msg);
		}
		
	}
}
