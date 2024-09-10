package com.jdc.mkt.languageChange;

public class TextBlockDemo {

	//java 15
	public static void main(String[] args) {
		String message = """
				Hello
				Java
				    Developer !
				""";
		System.out.println(message);
		System.out.println("Hello %s".formatted("Andrew"));
	}
}
