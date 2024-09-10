package com.jdc.mkt.languageChange;

interface Checker{
	Boolean check(String s);
}
//java 16
public class RecordClassDemo implements Checker{

	public static void main(String[] args) {
		Student s1 = new Student("Andrew", 20);
		System.out.println(s1.name()+"\t"+s1.age());
		
		Student s2 = new Student("Julian");
		System.out.println(s2.name()+"\t"+s2.age());
	}

	@Override
	public Boolean check(String s) {
		return null;
	}
}
record Student(String name,int age) {
	
	//explicit Canonical constructor
	public Student(String name,int age) {
		if(name ==  null) {
			throw new RuntimeException("Name must not be null");
		}
		if(age <= 0) {
			throw new RuntimeException("Age must greater than 0");
		}
		this.name = name;
		this.age = age;
	}
	
	//secondary constructor
	public Student(String name) {
		this(name,1);
	}
}
