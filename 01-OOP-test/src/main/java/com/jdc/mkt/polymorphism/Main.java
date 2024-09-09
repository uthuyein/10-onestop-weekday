package com.jdc.mkt.polymorphism;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
		Andrew  a = new Andrew();
		William wil = new William();
		
		Worker w = a;
		Worker w2 = wil;
		
		Human h = a;
		Employee e = a;
		Object o = a;		
	}
}

class William extends Worker implements Human,Employee{

	@Override
	public int getSalary() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void doWork() {
		// TODO Auto-generated method stub
		
	}}
class Andrew extends Worker implements Human,Employee{

	@Override
	public int getSalary() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void doWork() {
		// TODO Auto-generated method stub
		
	}}
interface Human{
	void sleep();
	void eat();
}
interface Employee{
	int getSalary();
}
abstract class Worker{
	abstract void doWork();
}

