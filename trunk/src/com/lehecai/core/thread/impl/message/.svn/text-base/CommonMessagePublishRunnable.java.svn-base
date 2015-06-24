/**
 * 
 */
package com.lehecai.core.thread.impl.message;

import com.lehecai.core.exception.message.MessagePublishException;
import com.lehecai.core.message.EventType;
import com.lehecai.core.service.message.MessageService;

/**
 * @author sunshow
 *
 */
public class CommonMessagePublishRunnable extends AbstractMessagePublishRunnable {
	
	private MessageService messageService;

	/* (non-Javadoc)
	 * @see com.lehecai.core.thread.impl.message.AbstractEventMessagePublisher#execute(com.lehecai.core.message.EventType, java.lang.String)
	 */
	@Override
	protected boolean execute(EventType eventType, String message)
			throws MessagePublishException {

		try {
			messageService.publish(eventType, message);
			return true;
		} catch (Exception e) {
			logger.error("调用消息发布服务出错", e);
			logger.error("eventType={}, message={}", eventType, message);
			return false;
		}
	}

	/**
	 * 默认一分钟
	 */
	@Override
	protected long getRetryFailedWaitTimeInMillis() {
		return 60000;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

}
