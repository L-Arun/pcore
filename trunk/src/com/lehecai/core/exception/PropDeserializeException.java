package com.lehecai.core.exception;

public class PropDeserializeException extends Exception {

	private static final long serialVersionUID = -5610693283574836916L;

	public PropDeserializeException(String message) {
		super(message);
	}
	
	public PropDeserializeException() {
		this("属性反序列化出错");
	}
}
