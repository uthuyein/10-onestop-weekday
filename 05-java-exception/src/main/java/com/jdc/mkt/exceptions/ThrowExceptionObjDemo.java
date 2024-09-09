package com.jdc.mkt.exceptions;

public class ThrowExceptionObjDemo {

	public static void main(String[] args) {
		try {
		changeExceptionObj();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	static void changeExceptionObj() {
		try {
			createExcetionObj();
		}catch (Exception e) {
			throw new RuntimeException("change checked to unchecked exception");
		}
	}
	
	static void createExcetionObj() throws Exception{
		throw new Exception();
	}
}
