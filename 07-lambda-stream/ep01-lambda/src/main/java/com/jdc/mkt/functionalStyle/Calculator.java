package com.jdc.mkt.functionalStyle;

public class Calculator {

	int plus(int a,int b) {
		return a+b;
	}
	int minus(int a,int b) {
		return a-b;
	}
	int multiple(int a,int b) {
		return a*b;
	}
	int divided(int a,int b) {
		return a/b;
	}
	int modulo(int a,int b) {
		return a%b;
	}
	
	//method as argument
	int operation(int a, int b ,Operate ope) {
		return ope.calculate(a, b);
	}
}

@FunctionalInterface
interface Operate{
	int calculate(int a, int b);
}
