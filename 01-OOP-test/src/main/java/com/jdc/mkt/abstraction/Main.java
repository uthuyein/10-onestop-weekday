package com.jdc.mkt.abstraction;

import java.util.Scanner;

public class Main {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.println("""
				Please select One !
					1.Square
					2.Rectangle
					3.Circle
				""");
		Shape s = getShape(sc.nextInt());
		s.draw();
	}

	static Shape getShape(int num) {
		switch (num) {
		case 1:
			return new Square();
		case 2:
			return new Rectangle();
		case 3:
			return new Circle();
		default:
			return null;

		}
	}
}

abstract class Shape {
	abstract void draw();
}

class Square extends Shape {

	@Override
	void draw() {
		System.out.println("Drawing square !");
	}
}

class Rectangle extends Shape {

	@Override
	void draw() {
		System.out.println("Drawing rectangle !");
	}
}

class Circle extends Shape {

	@Override
	void draw() {
		System.out.println("Drawing circle !");
	}
}
