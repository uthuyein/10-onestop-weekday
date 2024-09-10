package com.jdc.mkt.functionalStyle;

public class CalculatorTwo {

	
	Operate getOperation(String ope) {
		switch(ope) {
			case"add":
				return (x,y) -> x+y;
			case"minus":
				return (x,y) -> x-y;
			case"multi":
				return (x,y) -> x*y;
			case"div":
				return (x,y) -> {
					if(y == 0) {
						throw new ArithmeticException("Can't divided by Zero !");
					}
					return	x/y;
					};
			case"mod":
				return (x,y) -> x%y;
				default:
					throw new RuntimeException("Something wrong");
		}
		
	}
	
}

