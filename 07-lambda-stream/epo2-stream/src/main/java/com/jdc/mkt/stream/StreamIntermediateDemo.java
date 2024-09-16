package com.jdc.mkt.stream;

import java.util.List;
import java.util.stream.Stream;

public class StreamIntermediateDemo {
	static List<String> list = List.of("5","7","2","4","3","6","4","7","1","4");
	static List<String> list1 = List.of("5","7","2");
	
	public static void main(String[] args) {
		//useInter();
		//useFlatMap();
		useParallelStream();
	}
	
	static void useParallelStream() {
		list.parallelStream()
		.distinct()
		.map(a -> Integer.parseInt(a))
		.sorted()
		.forEach(System.out::println);
	}
	
	static void useFlatMap() {
		List<Integer> list2 = Stream.of(list,list1)
							.flatMap(l -> l.stream())
							.map(s -> Integer.parseInt(s)) // change t
							.peek(i -> System.out.println(i) )
							.toList();
		System.out.println(list2);
	}
	
	static void useInter() {
		list.stream()
			.map(s -> Integer.parseInt(s)) //change string to int
			.sorted() // orderd
			.distinct() // get one which is same element
			.filter(n -> n >= 3) // get element which is greater than or equal 3
			.limit(3) // got only 3 element
			.skip(2) // skip the first 2 element
			.forEach(System.out::println);
	}
}
