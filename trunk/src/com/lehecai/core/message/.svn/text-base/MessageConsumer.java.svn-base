/**
 * 
 */
package com.lehecai.core.message;

import com.lehecai.core.exception.message.MessageConsumeException;
import com.lehecai.core.service.message.MessageService;

/**
 * @author gb
 * 以API为底层服务的消息消费者
 */
public class MessageConsumer {

	private MessageService messageService;
	
	private String messageKey;
	
	private int count = 1; //批量获取消息
	
	public String[] receiveNoWait() throws MessageConsumeException {
		try {
			return this.getMessageService().consume(this.getMessageKey(), this.getCount());
		} catch (Exception e) {
			throw new MessageConsumeException(e.getMessage());
		}
	}
	
	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
}
