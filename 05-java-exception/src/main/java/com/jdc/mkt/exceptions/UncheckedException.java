package com.jdc.mkt.exceptions;

public class UncheckedException {
	static Hello h;
	public static void main(String[] args) {
		//useArithmetic();
		//useNullPointer();
		recursive();
	}
	
	static void recursive() {
		try {
			recursive();
		
		}catch (StackOverflowError e) {
			System.out.println("StackOverflowError error");
		}
	}
	
	@SuppressWarnings("unused")
	static void useArithmetic() {
		try {
			int res = 10/0 ;
			
		}catch (ArithmeticException e) {
			System.out.println("Error ArithmeticException ");
		}
	}
	static void useNullPointer() {
		try {
			h.greeting();
		
		}catch (NullPointerException e) {
			System.out.println("Error NullPointerException");
		}
	}
	
	
}

class Hello{
	void greeting() {}
}
