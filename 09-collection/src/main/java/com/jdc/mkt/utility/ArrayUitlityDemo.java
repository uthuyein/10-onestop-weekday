package com.jdc.mkt.utility;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayUitlityDemo {

	public static void main(String[] args) {
		String[] array = {"William","John","Susan","Andrew","Petrick"};
		//search(array);
		//sorting(array);
		otherMethod(array);
		
	}
	
	static void otherMethod(String[] array) {
//		Arrays.fill(array, "Jackson");
//		Arrays.stream(array).forEach(System.out::println);
		
		//must be same size and element
//		String[] arr = {"William","John","Susan","Andrew","Petrick"};
//		System.out.println(Arrays.equals(array, arr));
		
		 array = Arrays.copyOf(array, array.length+1);
		 array[array.length-1] = "Boston";
		 Arrays.stream(array).forEach(System.out::println);
			
	}
	
	static void search(String[] array) {
		Arrays.sort(array);
		Arrays.stream(array).forEach(System.out::println);
		System.out.println(Arrays.binarySearch(array, "Susan"));
		System.out.println();
	}
	
	static void sorting(String[] array) {
		Arrays.sort(array);
		Arrays.stream(array).forEach(System.out::println);
		System.out.println();
		
		Arrays.sort(array,Comparator.reverseOrder());
		Arrays.stream(array).forEach(System.out::println);
		System.out.println();
		
		Arrays.sort(array, 0, 2);
		Arrays.stream(array).forEach(System.out::println);
		System.out.println();
	}
}
