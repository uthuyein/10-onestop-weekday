package com.jdc.mkt.lambda.methodref;

public class Data {

	Data(){
		super();
	}
	Data(int dat){
		System.out.println("Using with constructor :"+dat);
	}
	
	static int staticAdd(int a,int b) {
		System.out.println("Using with static method !");
		return a + b;
	}
	
	int instanceAdd(int a,int b) {
		System.out.println("Using with instance method !");
		return a + b;
	}
}
