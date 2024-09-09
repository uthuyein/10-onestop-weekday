package com.jdc.mkt;

public class GenriceDemo01 {

	public static void main(String[] args) {
			
		// Without Generic
		Data d = new Data();
		d.setValue("50");
		String str  = (String) d.getValue();
		System.out.println("Value : "+str);
		
		// With Generic
		DataGen<String> g = new DataGen<>();
		g.setValue("Hello");
		String stGen = g.getValue();
		System.out.println("Value : "+stGen);
		
		DataGen<Integer> gInt = new DataGen<>();
		gInt.setValue(40);
		int intGen = gInt.getValue();
		System.out.println("Value : "+intGen);
	}
}

abstract class Action<T>{
	abstract void insert(T t);
}


//Using Generic
class DataGen<T>{
	private T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
}
//Before generic
class Data{
	private Object value;

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
}
