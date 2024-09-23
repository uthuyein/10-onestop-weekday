package com.jdc.mkt.collection;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {

	public static void main(String[] args) {
		Deque<String> d1 = new ArrayDeque<String>();
		addData(d1);
		showData(d1);
	}
	
	static void addData(Deque<String> d) {
		d.add("ss");
		d.add("aa");
		d.add("bb");
		d.add("ss");
		d.addFirst("zz");
		d.addLast("kk");
		d.add("other");
	}
	
	static void showData(Deque<String> d) {
		for(String s:d) {
			System.out.println(s);
		}
	}
}
