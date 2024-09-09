package com.jdc.mkt.lsp;

public class Main {

	public static void main(String[] args) {
		Car c = new ElectricCar();
		c.drive();
		c.useEngine();
	}
}

class Car{
	void drive() {
		System.out.println("Driving");
	}
	void useEngine(){
		System.out.println("Use Engine");
	}
}
class EngineCar extends Car{
	void useEngine(){
		System.out.println("Use Engine");
	}
}
class ElectricCar extends Car{
	void useEngine(){	
		throw new RuntimeException("Electric car didn't use engine !");
	}
}
