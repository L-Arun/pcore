/**
 * 
 */
package com.lehecai.core.test.queue;

import com.lehecai.core.queue.QueueConstant;
import com.lehecai.core.queue.QueueTaskService;
import com.lehecai.core.queue.mail.MailQueueConfig;
import com.lehecai.core.queue.mail.MailQueueTask;

/**
 * @author Sunshow
 *
 */
public class MailQueueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/* 初始化队列设置 */
		MailQueueConfig config = new MailQueueConfig();
		config.setEndpoint("http://localhost:8080/LeheQ/LeheQ");
		config.setQueue("mailqueue");
		
		/* 初始化一个队列任务 */
		MailQueueTask task = new MailQueueTask();
		task.setSubject("邮件队列测试");
		task.setMailto("sunshow@gmail.com");
		task.setTaskType(QueueConstant.TASK_MAIL_DEFAULT);
		task.setHtmlText("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body><h1>新书快递通知</h1>你的新书快递申请已推送新书，请到<a href=''>空间</a>中查看<br></body></html>");
		
		QueueTaskService service = new QueueTaskService();
		service.setQueueConfig(config);
		
		int rc = service.postToQueue(task);
		System.out.println(rc);
	}

}
