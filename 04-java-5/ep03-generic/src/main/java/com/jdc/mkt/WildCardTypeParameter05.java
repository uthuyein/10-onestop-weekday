package com.jdc.mkt;

public class WildCardTypeParameter05 {

	public static void main(String[] args) {
		ContainerOne<?> c1 = new ContainerOne<>();
		//c1.setData();
		System.out.println(c1.getData());
	}
	static void useWildCard(ContainerOne<?> c) {
		//c.setData(new AA());
		System.out.println(c.getData());
	}
}

class AA{}
class ContainerOne<T>{
	T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
