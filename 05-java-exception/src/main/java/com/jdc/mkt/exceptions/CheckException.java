package com.jdc.mkt.exceptions;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class CheckException {

	public static void main(String[] args) {
		useNoSuchMethod();
		useIo();
	}
	@SuppressWarnings("unused")
	static void useNoSuchMethod() {
		try {
			Method m = CheckException.class.getDeclaredMethod("useoSuchMethod");
			
		}catch (NoSuchMethodException  e) {
			System.out.println("Error NoSuchMethodException");
		}
	}
	static void useIo() {
		try {
			File f = new File("");
			f.createNewFile();
			
		}catch (IOException e) {
			System.out.println("Error IOException");
		}
	}
}
