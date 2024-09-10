package com.jdc.mkt.functionalStyle;

public class CalculatorDemo {

	public static void main(String[] args) {
		Calculator c = new Calculator();
		
		Operate add = c :: plus;
		Operate minus = c :: minus;
		Operate multi = c :: multiple;
		Operate divd = c :: divided;
		Operate modulo = c :: modulo;
		
		System.out.println(c.operation(4, 5, add));
		System.out.println(c.operation(5, 5, minus));
		System.out.println(c.operation(4, 5, multi));
		System.out.println(c.operation(6, 3, divd));
		System.out.println(c.operation(5, 2, modulo));
		
		System.out.println("\n");
		CalculatorTwo c2 = new CalculatorTwo();
		Operate add1 = c2.getOperation("add");
		Operate minus1 = c2.getOperation("minus");
		Operate multi1 = c2.getOperation("multi");
				
		System.out.println(add1.calculate(5, 4));
		System.out.println(minus1.calculate(5, 4));
		System.out.println(multi1.calculate(5, 4));
		
	}
}
