package com.jdc.mkt.lambda.methodref;

public class MethodReferenceDemo {

	public static void main(String[] args) {
		//use lambda
		MyInterOne one1 = a -> System.out.println("Result : "+a);
		MyInterTwo two1 = (a,b) -> a+b;
		one1.showResult(two1.add(5, 10));
		System.out.println();
		
		//instance method reference
		Data d = new Data();
		MyInterTwo two2 = d :: instanceAdd;
		int res1 = two2.add(3, 2);
		System.out.println("Result :"+res1);
		System.out.println();
		
		//static method reference
		MyInterTwo two3 = Data :: staticAdd;
		int res2 = two3.add(4, 5);
		System.out.println("Result :"+res2);
		System.out.println();
		
		// constructor reference
		MyInterOne one2 = Data :: new;
		one2.showResult(50);
		
	}
}
interface MyInterOne{
	void showResult(int res);
}
interface MyInterTwo{
	int add(int a,int b);
}
