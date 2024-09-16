package com.jdc.mkt.stream;

import java.util.Comparator;
import java.util.List;

public class StreamGeResultDemo {
	static List<String> list = List.of("5","7","2","4","3","6","4","7","1","4");
	static List<Human> hh = List.of(new Human("Su Su",20),new Human("Wanna",30));
		
	public static void main(String[] args) {
		useFindMethod();		
	}
	
	static void useFindMethod() {
		var elementFirst =list.stream()
		.sorted(Comparator.reverseOrder())
		.findFirst().get();
		System.out.println(elementFirst);
		
		var elementAny =list.parallelStream()
				.sorted(Comparator.reverseOrder())
				.findAny().get();
				System.out.println(elementAny);
				
//		var human = hh.stream()
//				.sorted()
//				.findFirst().get();
//		System.out.println(human);
	}
}
class Human implements Comparable<Human>{
	String name;
	int age;
	
	public Human(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Human o) {
		return o.name.compareTo(name);
	}
}

