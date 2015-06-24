/**
 * 
 */
package com.lehecai.core.service.message;

import com.lehecai.core.message.EventType;


/**
 * @author gb
 * 消息消费客户端，通过Spring注入方式传入目的地地址key
 */
public interface MessageService {

	/**
	 * 以非阻塞的方式获取数据
	 * @return 消息体或者null
	 * @throws Exception
	 */
	public String[] consume(String key, int count) throws Exception;
	public String consume(String key) throws Exception;
	
	public void publish(EventType eventType, String message) throws Exception;
}
