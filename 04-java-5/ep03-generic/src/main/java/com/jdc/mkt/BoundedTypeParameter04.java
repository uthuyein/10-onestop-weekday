package com.jdc.mkt;

@SuppressWarnings("unused")
public class BoundedTypeParameter04 {

	public static void main(String[] args) {
		BoundedType<B> b = new BoundedType<>();
		BoundedType<C> c = new BoundedType<>();
		//can't use A 
		//BoundedType<A> A = new BoundedType<>();
		
	}
}

class A{}
class B extends A{}
class C extends B{}

class BoundedType<T extends B>{
	T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
