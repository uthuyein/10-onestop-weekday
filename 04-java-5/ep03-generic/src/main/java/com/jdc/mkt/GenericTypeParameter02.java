package com.jdc.mkt;

public class GenericTypeParameter02 {

	public static void main(String[] args) {
		IntegerConvert conv = new IntegerConvert();
		Integer i = conv.getValue("50");
		System.out.println(i+50);
		
		createStaticGen(45);
	}
	
	static <V> void createStaticGen(V v) {	
		System.out.println(v);
	}
	
	<V> void createInstanceGen(V v) {
		System.out.println(v);
	}
}

abstract class Converter<T,R>{
	abstract R getValue(T t);
}

class IntegerConvert extends Converter<String,Integer>{

	@Override
	Integer getValue(String t) {
		return Integer.valueOf(t);
	}
	
}
class StringConvert extends Converter<Integer,String>{

	@Override
	String getValue(Integer t) {
		return t.toString();
	}
	
}
