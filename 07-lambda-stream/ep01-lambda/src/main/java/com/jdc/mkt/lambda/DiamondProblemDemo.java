package com.jdc.mkt.lambda;

public class DiamondProblemDemo {

	public static void main(String[] args) {
		Child c = new Child();
		c.doSomething();
	}
}

class Child implements ParentA,ParentB{

	@Override
	public void doSomething() {
		ParentB.super.doSomething();
	}
	
}
interface ParentA{
	default void doSomething() {
		System.out.println("From parent A");
	}
}
interface ParentB{
	default void doSomething() {
		System.out.println("From parent B");
	}
}
