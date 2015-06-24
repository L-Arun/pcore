/**
 * 
 */
package com.lehecai.core.queue.mail;

import net.sf.json.JSONObject;

import com.lehecai.core.queue.AbstractQueueTask;
import com.lehecai.core.queue.IQueueTask;
import com.lehecai.core.queue.QueueConstant;

/**
 * @author Sunshow
 *
 */
public class MailQueueTask extends AbstractQueueTask implements IQueueTask {

	private String mailto;
	private String subject;
	
	/* 纯文本正文内容 */
	private String text;
	
	/* HTML正文内容，此内容存在时忽略纯文本内容优先发送HTML内容 */
	private String htmlText;
	
	@Override
	public String toJSONString() {
		JSONObject json = new JSONObject();
		json.put("mailto", this.getMailto());
		json.put("subject", this.getSubject());
		json.put("content", this.getContent());
		return json.toString();
	}

	public String getContent() {
		if (this.getHtmlText() != null) {
			return this.getHtmlText();
		}
		return this.getText();
	}

	public String getMailto() {
		return mailto;
	}

	public void setMailto(String mailto) {
		this.mailto = mailto;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getHtmlText() {
		return htmlText;
	}

	public void setHtmlText(String htmlText) {
		this.htmlText = htmlText;
	}

	@Override
	public String getTaskType() {
		if (super.getTaskType() == null) {
			return QueueConstant.TASK_MAIL_DEFAULT;
		}
		return super.getTaskType();
	}
}
