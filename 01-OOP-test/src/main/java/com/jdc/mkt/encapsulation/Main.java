package com.jdc.mkt.encapsulation;

import com.jdc.mkt.encapsulation.other.Animal;

public class Main {

	public static void main(String[] args) {
		Animal animal = new Animal();
		//animal.setName("Rambo");
		animal.setAge(3);
		
		System.out.println(animal.getName());
	}
}
