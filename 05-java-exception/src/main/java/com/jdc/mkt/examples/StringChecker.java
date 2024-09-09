package com.jdc.mkt.examples;

import java.util.regex.Pattern;

public class StringChecker {
	
	static void checkPassword(String pass) {
		if(!Pattern.matches("\\S+\\d+", pass)) {
			throw new MyCustomException("Invalid password.Must have aleast one character and number !");
		}
	}
	
	static void checkUserName(String user) {
		if(user.length() < 5) {
			throw new MyCustomException("User name character count must be at least 5 ! ");
		}
		if(!Pattern.matches("\\S++", user)) {
			throw new MyCustomException("User name can't use white space !");
		}
		
	}
	
}
