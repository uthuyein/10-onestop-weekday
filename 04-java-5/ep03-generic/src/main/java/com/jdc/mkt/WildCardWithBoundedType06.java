package com.jdc.mkt;

public class WildCardWithBoundedType06 {

	public static void main(String[] args) {
		ContainerTwo<X> cx = new ContainerTwo<>();
		ContainerTwo<Y> cy = new ContainerTwo<>();
		ContainerTwo<Z> cz = new ContainerTwo<>();
		ContainerTwo<Object> cobj = new ContainerTwo<>();
		
		upperBounded(cz);
		upperBounded(cy);
		//upperBounded(cx);
		
		lowerBounded(cy);
		lowerBounded(cx);
		lowerBounded(cobj);
		//lowerBounded(cz);
	}
	
	static void upperBounded(ContainerTwo<? extends Y> c) {
		//c.setData(new Z());
		c.getData();
	}
	static void lowerBounded(ContainerTwo<? super Y> c) {
		c.setData(new Y());
		c.getData();
	}
}

class X{}
class Y extends X{}
class Z extends Y{}

class ContainerTwo<T>{
	T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}	
}
