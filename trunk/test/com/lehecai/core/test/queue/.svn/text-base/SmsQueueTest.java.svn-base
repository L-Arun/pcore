/**
 * 
 */
package com.lehecai.core.test.queue;

import com.lehecai.core.queue.QueueConstant;
import com.lehecai.core.queue.QueueTaskService;
import com.lehecai.core.queue.sms.SmsQueueConfig;
import com.lehecai.core.queue.sms.SmsQueueTask;

/**
 * @author Sunshow
 *
 */
public class SmsQueueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/* 初始化队列设置 */
		SmsQueueConfig config = new SmsQueueConfig();
		config.setEndpoint("http://localhost:8080/LeheQ/LeheQ");
		config.setQueue("smsQueue");
		
		/* 初始化一个队列任务 */
		SmsQueueTask task = new SmsQueueTask();
		task.setTaskType(QueueConstant.TASK_SMS_DEFAULT);
		task.addReceiver("13810161425");
		task.addReceiver("13426446321");
		task.setContent("恭喜你！中了五百万啦！");
		
		QueueTaskService service = new QueueTaskService();
		service.setQueueConfig(config);
		
		int rc = service.postToQueue(task);
		System.out.println(rc);
	}

}
