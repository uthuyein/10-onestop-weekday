package com.jdc.mkt.inter;

public class Main {

	public static void main(String[] args) {
		Animal lion = new Animal() {

			@Override
			public void eat() {
				System.out.println("Eat something");
			}

			@Override
			public void sleep() {
				System.out.println("Sleep on somewhere");
			}};
		lion.eat();
		lion.sleep();
		System.out.println(Animal.name);
		
	}
}
//after java 8
// varivable must be public static final or effiective final(public static final).
// private method,default method,static method can create 
// can't hv constructor
@SuppressWarnings("unused")
interface Animal{
	 String name = "No name";
 
	 void eat();
	 void sleep();
	 private void doSome() {}
	 default void show() {}
	 static void hide() {}
}

interface Canine{
	void chasing();
}

class Lion implements Animal,Canine{

	@Override
	public void eat() {
		System.out.println("Eat meals");
	}

	@Override
	public void sleep() {
		System.out.println("sleep on ground !");
	}

	@Override
	public void chasing() {
		// TODO Auto-generated method stub
		
	}}


