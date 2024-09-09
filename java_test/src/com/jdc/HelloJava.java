package com.jdc;

import java.util.Scanner;

public class HelloJava {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Type name !");
		String name = sc.next();
		System.out.println("Name : "+name);
		sc.close();
	}
}
