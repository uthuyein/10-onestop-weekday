package com.jdc.mkt.exceptions;

public class ExceptionDemo {

	public static void main(String[] args) {
		callA();
	}
	
	@SuppressWarnings("unused")
	static void callC() {
		try {
			int i = 0 ;
			int x = 10/ i ;
			System.out.println("Hello");
		}catch(ArithmeticException e) {
			System.out.println("Error");
		}
	}
	static void callB() {
		callC();
	}
	static void callA() {
		callB();
	}
}
