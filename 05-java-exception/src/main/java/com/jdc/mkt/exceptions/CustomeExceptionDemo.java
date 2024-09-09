package com.jdc.mkt.exceptions;

public class CustomeExceptionDemo {

	public static void main(String[] args) {
		
	}
	
	static void useCustom(){
			//createMyCustom();
			createMyCustomRuntime();
	}
	
	static void createMyCustom() throws MyCustomException{
		throw new MyCustomException();
	}
	
	static void createMyCustomRuntime() {
		throw new MyCustomRuntimeException();
	}
}

class MyCustomException extends Exception{
	private static final long serialVersionUID = 1L;
	
	
}

class MyCustomRuntimeException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	
}
