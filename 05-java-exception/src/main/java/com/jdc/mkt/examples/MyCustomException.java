package com.jdc.mkt.examples;
public class MyCustomException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public MyCustomException(String message) {
		super(message);
	}
}
