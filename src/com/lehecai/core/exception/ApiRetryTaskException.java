package com.lehecai.core.exception;

public class ApiRetryTaskException extends Exception {

	private static final long serialVersionUID = 1L;

	public ApiRetryTaskException(String message) {
		super(message);
	}
	
	public ApiRetryTaskException() {
		this("重试任务执行失败");
	}
}
