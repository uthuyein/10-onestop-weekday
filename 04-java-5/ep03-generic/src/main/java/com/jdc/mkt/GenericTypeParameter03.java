package com.jdc.mkt;

public class GenericTypeParameter03 {

	public static void main(String[] args) {
		Container<String> c1 = new Container<>();
		c1.setData("Hello");
		Container<String> c2 = getValue(c1);
		c2.setData("Hi");
		System.out.println(c2.getData());
		
		
	}
	
	static<V> Container<V> getValue(Container<V> container) {
		//container.setData();		
		System.out.println(container.getData());
		return container;
	}
 }

class Container<T> {
	T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
