package com.jdc.mkt.encapsulation.other;

public class Animal {

	 String name;
	 int age;
	
	public Animal(){
		this("No Name",0);
	}
	
	Animal(String name,int age){
		this.name = name;
		this.age = checkAge(age);
	}
	
	private int checkAge(int age) {
		if(age > 0) {
			return age;
		}else {
			return 1;
		}
	}
	
	public void setName(String name) {
		this.name = "bb";
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
}
