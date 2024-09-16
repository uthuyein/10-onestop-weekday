package com.jdc.mkt.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamCollectDemo {
	static List<String> list = List.of("5","7","2","4","3","6","4","7","1","4");
	
	public static void main(String[] args) {
//		useArray();
//		useReduce();
//		useCollect();
		useTakeWhileAndDropWhile();
	}
	
	static void useTakeWhileAndDropWhile() {
		var l = list.stream()
				.map(i -> Integer.parseInt(i))
				.sorted()
				.takeWhile(a -> a < 6)
				.toList();
		System.out.println(l);
		
		var l1 = list.stream()
				.map(i -> Integer.parseInt(i))
				.sorted()
				.dropWhile(a -> a < 6)
				.collect(Collectors.toList());
		System.out.println(l1);
	}
	
	static void useCollect() {
		var list1 = list.stream()
					.map(x -> Integer.parseInt(x))
					.distinct()
					.sorted()
					.filter(y -> y%2 == 0)
					.collect(Collectors.toList());
		System.out.println(list1);
	}
	
	static void useReduce() {
	var res = list.stream()
			.map(a -> Integer.parseInt(a))
			.distinct()
			.reduce((a,b) -> a+b)
			.get();
	System.out.println(res);
	
	}
	
	static void useArray() {
		var array = list.stream()
					.sorted()
					.distinct()
					.toArray();
		System.out.println(array);
	}
}
