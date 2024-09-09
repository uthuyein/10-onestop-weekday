package com.jdc.mkt.abstraction;

public class MainTwo {

	public static void main(String[] args) {
		Color c = new Color() {
			@Override
			void print() {
				System.out.println("By anonymous class");
			}
			
		};
		c.print();
	}
}

class GreenColor extends Color{

	public GreenColor() {
		System.out.println("Green color constructor !");
	}
	@Override
	void print() {
		System.out.println("Print witch green color !");
	}}

@SuppressWarnings("unused")
abstract class Color{
	private String name;
	static int day ;
	
	static {
		System.out.println("static block");
	}
	{
		System.out.println("instance block");
	}
	
	Color(){
		System.out.println("Using Constructor");
	}
	
	abstract void print();	
	
	static void useColor() {}
	
	void showColor() {}
	
}
