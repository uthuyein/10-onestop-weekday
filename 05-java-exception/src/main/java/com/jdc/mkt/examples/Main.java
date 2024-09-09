package com.jdc.mkt.examples;

import static com.jdc.mkt.examples.StringChecker.checkPassword;
import static com.jdc.mkt.examples.StringChecker.checkUserName;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		getUser();
	}

	static void getUser() {
		try (var input = new BufferedReader( new InputStreamReader(System.in))){		
			System.out.println("Type user name !");
			String name = input.readLine();
			checkUserName(name);
			
			System.out.println("Type password !");
			String pass =  input.readLine();
			checkPassword(pass);
			
			var user = new User();
			user.setUser(name);
			user.setPassword(pass);
			
			System.out.println(user);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}


