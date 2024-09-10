package com.jdc.mkt.lambda;

public class LambdaDemo {

	public static void main(String[] args) {
		beforeLambda();
		afterLambda();
	}
	
	static void beforeLambda() {
		Runner r = new Runner() {			
			@Override
			public void run() {
				System.out.println("Running with anonymous");
			}
		};
		r.run();
	}
	
	static void afterLambda() {
		Runner r = () -> System.out.println("Running with lambda");
		r.run();
	}
}

interface Runner{
	void run();
}
