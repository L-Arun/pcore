/**
 * 
 */
package com.lehecai.core.warning.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.queue.QueueConstant;
import com.lehecai.core.queue.QueueTaskService;
import com.lehecai.core.queue.mail.MailQueueTask;
import com.lehecai.core.queue.sms.SmsQueueTask;
import com.lehecai.core.warning.IWarningTool;
import com.lehecai.core.warning.WarningType;

/**
 * @author Sunshow
 *
 */
public class LeheQWarningToolImpl implements IWarningTool {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private boolean disableWarning = false;
	
	private List<String> smsContacts;
	private List<String> mailContacts;
	
	private QueueTaskService smsQueueTaskService;
	private QueueTaskService mailQueueTaskService;

	@Override
	public void sendSMS(WarningType warningType, String message) {
		if (smsContacts == null) {
			logger.error("短信联系人未设置");
			return;
		}
		this.sendSMS(warningType, message, StringUtils.join(smsContacts, ","));
	}

	@Override
	public void sendMail(WarningType warningType, String message) {
		if (mailContacts == null) {
			logger.error("邮件联系人未设置");
			return;
		}
		this.sendMail(warningType, message, StringUtils.join(mailContacts, ","));
	}

	@Override
	public void sendMail(WarningType warningType, String message, String contactStr) {
		if (disableWarning) {
			return;
		}
		
		if (contactStr == null) {
			this.sendMail(warningType, message);
			return;
		}
		
		logger.error("警告类型：{}，信息内容：{}", warningType.getName(), message);
		this.sendMail("警告：" + warningType.getName(), message, contactStr);
	}

	@Override
	public void sendSMS(WarningType warningType, String message, String contactStr) {
		if (disableWarning) {
			return;
		}
		
		if (contactStr == null) {
			this.sendSMS(warningType, message);
			return;
		}
		
		logger.error("警告类型：{}，信息内容：{}", warningType.getName(), message);
		this.sendSMS(warningType.getName() + ":" + message + "[乐和彩]", contactStr);
	}

	@Override
	public void sendMail(String subject, String message, String contactStr) {
		if (disableWarning) {
			return;
		}
		
		if (contactStr == null) {
			logger.error("邮件联系人未设置");
			return;
		}
		
		String[] contactArray = contactStr.split(",");
		if (contactArray.length == 0) {
			logger.error("邮件联系人未设置");
			return;
		}
		
		MailQueueTask task = new MailQueueTask();
		task.setSubject(subject);
		task.setMailto(contactStr);
		task.setTaskType(QueueConstant.TASK_MAIL_DEFAULT);
		task.setText(message);
		
		try {
			int rc = mailQueueTaskService.postToQueue(task);
			if (rc == QueueConstant.RC_SUCCESS) {
				logger.info("发送警告成功");
			} else {
				logger.error("发送警告失败, rc={}", rc);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	@Override
	public void sendSMS(String message, String contactStr) {
		if (disableWarning) {
			return;
		}
		
		if (contactStr == null) {
			logger.error("短信联系人未设置");
			return;
		}
		
		String[] contactArray = contactStr.split(",");
		if (contactArray.length == 0) {
			logger.error("短信联系人未设置");
			return;
		}
		
		SmsQueueTask task = new SmsQueueTask();
		task.setTaskType(QueueConstant.TASK_SMS_DEFAULT);
		for (String contact : contactArray) {
			task.addReceiver(contact);
		}
		task.setContent(message);

		try {
			int rc = smsQueueTaskService.postToQueue(task);
			if (rc == QueueConstant.RC_SUCCESS) {
				logger.info("发送警告成功");
			} else {
				logger.error("发送警告失败, rc={}", rc);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public List<String> getSmsContacts() {
		return smsContacts;
	}

	public void setSmsContacts(List<String> smsContacts) {
		this.smsContacts = smsContacts;
	}

	public List<String> getMailContacts() {
		return mailContacts;
	}

	public void setMailContacts(List<String> mailContacts) {
		this.mailContacts = mailContacts;
	}

	public QueueTaskService getSmsQueueTaskService() {
		return smsQueueTaskService;
	}

	public void setSmsQueueTaskService(QueueTaskService smsQueueTaskService) {
		this.smsQueueTaskService = smsQueueTaskService;
	}

	public QueueTaskService getMailQueueTaskService() {
		return mailQueueTaskService;
	}

	public void setMailQueueTaskService(QueueTaskService mailQueueTaskService) {
		this.mailQueueTaskService = mailQueueTaskService;
	}

	public void setDisableWarning(boolean disableWarning) {
		this.disableWarning = disableWarning;
	}

}
