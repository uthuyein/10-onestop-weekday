package com.jdc.mkt.collection;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		Set<Integer> hashSet = new HashSet<Integer>();
		Set<Integer> treeSet = new TreeSet<Integer>();
		Set<Integer> linkSet = new LinkedHashSet<Integer>();
		
		System.out.println(
				"Hash set setData :%s\t getData :%s "
				.formatted(setData(hashSet),getData(hashSet)));
		
		System.out.println(
				"Tree set setData :%s\t getData :%s "
				.formatted(setData(treeSet),getData(treeSet)));
		
		System.out.println(
				"Link set setData :%s\t getData :%s "
				.formatted(setData(linkSet),getData(linkSet)));
		
		
	}
	
	static Long setData(Set<Integer> set) {
		var before = LocalTime.now();
		for(int i = 1 ; i <= 1_000_000 ; i++) {
			set.add(i);
		}
		var after = LocalTime.now();
		return Duration.between(before, after).toMillis();
	}
	
	static Long getData(Set<Integer> set) {
		var res = 0 ;
		var before = LocalTime.now();
		
		for(int i = 0 ; i < set.size() ; i++) {
			res = i;
		}
		var after = LocalTime.now();
		return Duration.between(before, after).toMillis();
	}
}
