package com.jdc.mkt.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class DefaultInterfaceDemo {

	public DefaultInterfaceDemo() {
		
	}
	public DefaultInterfaceDemo(int a) {
		System.out.println("Using constructor with method reference : "+a);
	}
	
	
	public static void main(String[] args) {
		Consumer<String> c1 = a -> System.out.println("Use lambda :"+a);
		c1.accept("Test");
		
		Consumer<Integer> c2 = DefaultInterfaceDemo::new;
		c2.accept(50);
		
		//Exercise i: Try with lambda for function and predicate
		Function<Integer, Double> f = DefaultInterfaceDemo::getValue;
		System.out.println(f.apply(50));
		
		Predicate<String> p = DefaultInterfaceDemo::checker;
		System.out.println(p.test(null));
		
		//Exercise ii:Try with lambda and instance method reference for supplier 
		
	}
	
	static Boolean checker(String str) {
		return str != null && !str.isEmpty() ;
	}
	
	static Double getValue(int i) {
		return Double.valueOf(i);
	}
}
