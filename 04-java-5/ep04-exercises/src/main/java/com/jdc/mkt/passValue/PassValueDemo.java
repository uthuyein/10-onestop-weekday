package com.jdc.mkt.passValue;

public class PassValueDemo {

	public static void main(String[] args) {
		
		PassValue v1 = new PassValue();
		v1.value = 10 ;
		setValue(v1.value);
		System.out.println("Value : "+v1.value);
		
		PassValue v2 = new PassValue();
		v2.value = 10 ;	
		reference(v2);
		System.out.println("Value : "+v2.value);
		
	}
	static void setValue(int value) {
		value = 20 ;
	}
	static void reference(PassValue obj) {
		obj.value = 20 ;
	}
}

class PassValue{
	int value;
}
