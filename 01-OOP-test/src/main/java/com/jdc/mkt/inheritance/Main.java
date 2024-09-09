package com.jdc.mkt.inheritance;

//Is a relation
public class Main {
	public static void main(String[] args) {
		A b = new B(3);
		b.value = 30;
		b.doSomething();
		b.getMessage(null);
		
		C c = new C();
		c.value = 2;
		c.doSomething();
		
	}
}
class X{}
class Y extends X{}
class Z extends Y{}

class A{
	int value;
	
	A(int a){
		super();
		this.value = 0;
	}
	
//	A(){
//		this(30);
//	}
	
	void testOverLoad(String name) {}
	void testOverLoad(int age) {}
	
	void doSomething() {
		System.out.println("Do something from A");
	}
	 Y getMessage(Y y) {
		return  new Z();
	}
}
class B extends A{
	
	B(int i){
		super(i);
	}
	
	void show() {
		value = 30;
		doSomething();
	}
	// return type must be same or their child when create override method
	// access modifier must be same or their parent when create override method
	@Override
	protected Z getMessage(Y y) {
		return  new Z();
	}
}
class C extends B{
	C(){
		super(33);
	}
	@Override
	void doSomething() {
		System.out.println("Do something from C");
	}
}
