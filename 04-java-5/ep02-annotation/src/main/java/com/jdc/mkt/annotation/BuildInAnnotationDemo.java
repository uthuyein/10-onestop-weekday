package com.jdc.mkt.annotation;

import java.io.Serializable;

public class BuildInAnnotationDemo {
	public static void main(String[] args) {
		Tester r = new Tester();
		r.prevent();
	}
}

@SuppressWarnings({"serial"})
class Tester implements Testing, Serializable{

	@SuppressWarnings("unused")
	private String name;
	
	@Override
	public void run() {}
	
	@Deprecated
	void prevent() {}
	
	<T> T[] getData(@SuppressWarnings("unchecked") T...t) {
		return (T[]) t;
	}
}

@FunctionalInterface
interface Testing{
	void run();
}