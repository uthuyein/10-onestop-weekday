package com.jdc.mkt.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ColllectionUtilityDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(List.of("William","John","Susan","Andrew","Petrick"));
		test(list);
	}
	
	static void test(List<String> list) {
//		Collections.shuffle(list);
//		list.stream().forEach(System.out::println);
		
		var list1 = new ArrayList<String>(List.of("aa","ss","ff"));
		System.out.println("Joint :"+Collections.disjoint(list, list1));
	}
}
