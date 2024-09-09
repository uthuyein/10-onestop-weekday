package com.jdc.mkt.exceptions;

import java.util.Scanner;

public class TryCatchExceptionDemo {

	static  int[] arrays = new  int[1];
	public static void main(String[] args) {
		useArrayWithTryCatchFinally();
	}
	
	static void useArrayWithTryCatchFinally() {
		try {
			arrays[0] = 20 ;
			
		}catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}finally {
			System.out.println("finally");
		}
		System.out.println("End of method");
	}
	
	
	@SuppressWarnings("unused")
	static void useArrayWithTryWitchResource() {
		try(Scanner sc = new Scanner(System.in)) {
			
			System.out.println("Type name ?");
			String name = sc.next();
			
			arrays[0] = 20 ;
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	static void useArrayWithTryCatch() {
		try {
			arrays[0] = 20 ;
			
		}catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//use same as useArrayWithTryMultiCatch method and also can be use both same type of child and super .
	static void useArrayWithTryCatchOther() {
		try {
			arrays[0] = 20 ;
			
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// use same level of child exception and different type of exception can use try multi catch
	//can't use both same type of super and child exception in same catch parameter.
	static void useArrayWithTryMultiCatch() {
		try {
			arrays[0] = 20 ;
			
		}catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
}
