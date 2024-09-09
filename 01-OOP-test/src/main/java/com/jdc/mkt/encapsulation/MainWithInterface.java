package com.jdc.mkt.encapsulation;

public class MainWithInterface {

	public static void main(String[] args) {
		Human human = new Student();
		human.setName("Aung Aung");
		human.setAge(30);
		System.out.println("Name :"+human.getName()+"\tAge :"+human.getAge());
		
		Student st = (Student) human;
		st.name = "Wanna";
		System.out.println(st.name);
	}
}

class Teacher implements Human{

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAge(int age) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return 0;
	}}

class Student implements Human{
	public String name;
	public int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
interface Human{
	void setName(String name);
	void setAge(int age);
	String getName();
	int getAge();
	
	
}










