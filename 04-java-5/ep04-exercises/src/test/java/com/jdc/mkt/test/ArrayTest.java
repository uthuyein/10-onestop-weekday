package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.array.DataArray;

public class ArrayTest {

	@Test
	void test() {
		DataArray data = new DataArray();
		data.setData("Andew","William","John","Maria");
		for(String s :data.getData()) {
			System.out.println(s);
		}
		data.remove(2);
		System.out.println();
		for(String s :data.getData()) {
			System.out.println(s);
		}
		System.out.println();
		data.sort();
		for(String s :data.getData()) {
			System.out.println("Sorting : "+s);
		}
	}
}
