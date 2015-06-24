/**
 * 
 */
package com.lehecai.core.queue;

import net.sf.json.JSONObject;

/**
 * @author Sunshow
 *
 */
public class AbstractQueueTask {
	
	/* 队列任务执行完后的回调地址 */
	private String callback;
	
	/* 任务提供的数据类型，默认json */
	private String dataType;
	
	/* 任务类型 */
	private String taskType;
	
	private String ext;
	
	public String toJSONString() {
		JSONObject json = JSONObject.fromObject(this);
		json.remove("dataType");
		json.remove("callback");
		json.remove("taskType");
		json.remove("ext");
		return json.toString();
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	public String getDataType() {
		if (dataType == null || dataType.isEmpty()) {
			return QueueConstant.DATA_TYPE_DEFAULT;
		}
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

}
