package com.jdc.mkt.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StreamCreationDemo {

	public static void main(String[] args) {
//		beforeUsingStream();
//		fromArrayAndCollection();
//		fromRange();
		fromGenerateAndIterate();
	}
	static void fromGenerateAndIterate() {
		int res = IntStream.iterate(1, a -> ++a).limit(5).sum();
		System.out.println(res);
		
		int res1 = IntStream.generate(() -> 1).limit(5).sum();
		System.out.println(res1);
		System.out.println();
		Random r = new Random();
		IntStream.generate(()-> r.nextInt(5)+1).limit(1).forEach(System.out::println);
		
	}
	static void fromRange() {
		System.out.println("Sum of IntStream with range result is "+ IntStream.range(1, 11).sum());
		System.out.println("Sum of LongStream with rangeClosed result is "+ LongStream.rangeClosed(1, 11).sum());
		
		System.out.println("Sum of DoubleSteam with of result is "+ DoubleStream.of(1.1, 11.22,22,3).sum());
	}
	
	static void fromArrayAndCollection() {
		int[]array = {1,2,3,4,5};
		int res = Arrays.stream(array).sum();
		System.out.println("From Array stream : "+res);
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		var res1 = list.stream().mapToInt(a -> a).sum();
		System.out.println("From Collection stream :"+res1);
	}
	
	static void beforeUsingStream() {
		int[]array = {1,2,3,4,5};
		int a = 0,sum = 0;
		
		while(a < array.length) {
			sum += array[a];
			a++;
		}
		System.out.println("Result :"+sum);
	}
}
