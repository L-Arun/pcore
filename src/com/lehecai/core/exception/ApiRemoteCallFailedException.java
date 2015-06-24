package com.lehecai.core.exception;

public class ApiRemoteCallFailedException extends Exception {

	private static final long serialVersionUID = 1743721427833017386L;

	public ApiRemoteCallFailedException(String message) {
		super(message);
	}
	
	public ApiRemoteCallFailedException() {
		this("API请求失败");
	}
}
