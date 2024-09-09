package com.jdc.mkt.inter;

public class MainWithDiamondProblem {

	public static void main(String[] args) {
		D d = new D();
		d.doSomething();
	}	
}

interface A{
	default void doSomething() {
		System.out.println("do something from a ");
	}
}
interface B extends A{
	@Override
	default void doSomething() {
		System.out.println("do something from B ");
	}
}
interface C extends A{
	@Override
	default void doSomething() {
		System.out.println("do something from C ");
	}
}
abstract class F implements A{}

class D implements B,C{

	@Override
	public void doSomething() {
		B.super.doSomething();
	}
	
}

