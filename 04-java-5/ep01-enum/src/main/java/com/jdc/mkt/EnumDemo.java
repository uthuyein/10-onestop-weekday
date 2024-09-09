package com.jdc.mkt;

public class EnumDemo {

	public static void main(String[] args) {
		Day d = Day.WED;

		System.out.println("Full name : " + d.getName());
		System.out.println("Number : " + d.getNumber());

		System.out.println(d.ordinal() + "\t" + d.name());

		System.out.println(Day.values());
		System.out.println(Day.valueOf("TUE"));

	}
}
