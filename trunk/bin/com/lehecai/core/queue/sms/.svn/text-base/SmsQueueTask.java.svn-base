/**
 * 
 */
package com.lehecai.core.queue.sms;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.lehecai.core.queue.AbstractQueueTask;
import com.lehecai.core.queue.IQueueTask;
import com.lehecai.core.queue.QueueConstant;
import com.lehecai.core.util.CoreStringUtils;

/**
 * @author Sunshow
 *
 */
public class SmsQueueTask extends AbstractQueueTask implements IQueueTask {

	private String content;
	
	private List<String> receivers;
	
	@Override
	public String toJSONString() {
		JSONObject json = new JSONObject();
		json.put("smsto", this.getSmsto());
		json.put("content", this.getContent());
		return json.toString();
	}
	
	public void addReceiver(String receiver) {
		if (receivers == null) {
			receivers = new ArrayList<String>();
		}
		receivers.add(receiver);
	}

	public List<String> getReceivers() {
		return receivers;
	}

	public void setReceivers(List<String> receivers) {
		this.receivers = receivers;
	}

	public String getSmsto() {
		if (receivers == null) {
			return null;
		}
		return CoreStringUtils.join(receivers, ",");
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String getTaskType() {
		if (super.getTaskType() == null) {
			return QueueConstant.TASK_SMS_DEFAULT;
		}
		return super.getTaskType();
	}
}
