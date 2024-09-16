package com.jdc.mkt.stream;

import java.util.List;

public class TerminalOperationDemo {
	static List<String> list = List.of("5","7","2","4","3","6","4","7","1","4");
	
	public static void main(String[] args) {
		//useIteration();
		useChecking();
	}
	
	static void useChecking() {
		var resAll = list.stream()
				.map(a -> Integer.parseInt(a))
				.allMatch(a -> a%2 == 0);
		System.out.println(resAll);
		
		var resAny = list.stream()
				.map(a -> Integer.parseInt(a))
				.anyMatch(a -> a%2 == 0);
		System.out.println(resAny);
		
		var resNone = list.stream()
				.map(a -> Integer.parseInt(a))
				.noneMatch(a -> a%2 == 0);
		System.out.println(resNone);
	}
	static void useIteration() {
		list.parallelStream()
			.distinct()
			.sorted()
			.forEachOrdered(System.out::print);
		System.out.println();
		list.stream()
			.distinct()
			.sorted()
			.forEach(System.out::print);
	}
}
