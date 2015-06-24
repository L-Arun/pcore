package com.lehecai.core.exception;

public class RequestParameterException extends Exception {

	private static final long serialVersionUID = 1962041782096240178L;

	public RequestParameterException(String message) {
		super(message);
	}
	
	public RequestParameterException() {
		this("请求参数不正确");
	}
}
