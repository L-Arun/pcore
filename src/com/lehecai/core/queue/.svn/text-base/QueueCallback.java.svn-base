/**
 * 
 */
package com.lehecai.core.queue;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lehecai.core.util.CharsetConstant;
import com.lehecai.core.util.CoreStringUtils;

/**
 * @author Sunshow
 *
 */
public class QueueCallback {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private int rc;			//队列执行结果
	private int retry;		//重试次数
	private String message;	//处理消息
	private String ext;		//请求时的扩展信息，原样返回
	
	public QueueCallback(String jsonStr) {
		if (jsonStr == null || jsonStr.isEmpty()) {
			rc = QueueConstant.RC_FAILURE;
			message = "回调信息为空";
			logger.error("{}", message);
			return;
		}
		
		try {
			jsonStr = CoreStringUtils.unicodeToString(URLDecoder.decode(jsonStr, CharsetConstant.CHARSET_UTF8));
			logger.info("解码后的回调信息: {}", jsonStr);
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
		}
		
		try {
			JSONObject jsonObj = JSONObject.fromObject(jsonStr);
			rc = jsonObj.getInt("rc");
			try {
				retry = jsonObj.getInt("retry");
				message = jsonObj.getString("message");
				if(jsonObj.containsKey("ext")){
					ext = jsonObj.getString("ext");
				}else{
					ext = "";
				}
				
			} catch (Exception e) {
				logger.warn(e.getMessage(), e);
			}
		} catch (Exception e) {
			rc = QueueConstant.RC_FAILURE;
			message = "回调信息不正确";
			logger.error("{}, {}", message, jsonStr);
			return;
		}
	}
	
	public int getRc() {
		return rc;
	}
	public void setRc(int rc) {
		this.rc = rc;
	}
	public int getRetry() {
		return retry;
	}
	public void setRetry(int retry) {
		this.retry = retry;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
}
