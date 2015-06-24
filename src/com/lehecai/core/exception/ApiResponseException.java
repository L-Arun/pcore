package com.lehecai.core.exception;

public class ApiResponseException extends Exception {

	private static final long serialVersionUID = 3908119853777181264L;

	private int code;
	
	private String message;
	
	public ApiResponseException(int code, String message) {
		super("API响应出错，message=" + message + ", code=" + code);
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
