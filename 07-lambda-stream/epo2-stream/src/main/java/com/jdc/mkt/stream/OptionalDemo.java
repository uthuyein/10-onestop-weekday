package com.jdc.mkt.stream;

import java.util.Optional;

public class OptionalDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Throwable  {
		//Check value
		System.out.println(getValue(null).isPresent());
		System.out.println(getValue(null).isEmpty());
		
		//Retrieve value
		System.out.println("Result :"+getValue(5).get());
		System.out.println("Result :"+getValue(10).orElse(1));	
		//getValue(null).orElseThrow(() -> new NullPointerException() );
		
		//Use value
		getValue(5).ifPresent(a -> System.out.println(a));
		getValue(null).ifPresentOrElse(
				a -> System.out.println(a),
				() -> System.out.println("No Value"));
	}
	
	@SuppressWarnings("rawtypes")
	static Optional getValue(Integer v) {
		return Optional.ofNullable(v);
	}
}
