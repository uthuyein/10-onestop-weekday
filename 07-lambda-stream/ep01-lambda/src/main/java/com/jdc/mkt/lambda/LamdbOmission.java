package com.jdc.mkt.lambda;

public class LamdbOmission {

	public static void main(String[] args) {
		useWithAnonymous();
		useWithLambda();
	}
	static void useWithLambda() {
		NoReturn nr = (name, m) ->  System.out.println("Hello,"+name+"! "+m);		
		nr.show("William", "Nice to meet you.");
		
		WithReturn wr =  str ->  str;
		String message = wr.getMessage("Hello");
		System.out.println(message);
		
		NoArgs na = () -> {
			String mess = "Hello java developer !";
			System.out.println(mess);
		};
		na.greeting();
		
	}
	
	//test with effective final
	static void useWithAnonymous() {
		 String str = "final test";
	
		NoReturn nr1 = new NoReturn() {	
			@Override
			public void show(String name, String message) {
				System.out.println("Hello,"+name+"! "+str);
			}
		};
		
		nr1.show("Andrew", "Greats to see you.");
		NoReturn nr2 = new NoReturn() {	
			@Override
			public void show(String name, String message) {
				System.out.println("Hello,"+name+"! "+str);
			}
		};
		nr2.show("Andrew", "Greats to see you.");
		
		System.out.println(str);
	}	
}

@FunctionalInterface
interface NoArgs{
	
	void greeting();
	default void doSomething() {}
	@SuppressWarnings("unused")
	private void check() {}
	static void call() {}
}

interface NoReturn{
	void show(String name,String message);
}
interface WithReturn{
	String getMessage(String message);
}
