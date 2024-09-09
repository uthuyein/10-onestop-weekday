package com.jdc.mkt.exceptions;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ThrowExceptionDemo {

	static Scanner sc;
	public static void main(String[] args) {
		handleException();
	}
	
	static void handleException() {
		try {
				uncheckException();
				checkedException();
				checkedExceptionWithSuper();
				
			}catch (IOException e) {
				System.out.println(e.getMessage());
			}catch (NullPointerException e) {
				System.out.println(e.getMessage());
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
	
	// can't throws child exception 
	static void checkedExceptionWithSuper() throws Exception{
		customException();
	}
	
	static void checkedException() throws IOException{
		File f = new File("");
		f.createNewFile();
	}
	
	// can throws parent exception
	@SuppressWarnings("unused")
	static void uncheckException() throws RuntimeException{
		String name = sc.next();
	}
	
	static void customException() throws Exception {
		throw new Exception("test");
	}
}
