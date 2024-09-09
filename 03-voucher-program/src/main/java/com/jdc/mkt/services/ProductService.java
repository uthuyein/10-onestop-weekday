package com.jdc.mkt.services;

import java.util.Scanner;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.util.Database;

@SuppressWarnings("unused")
public class ProductService {
	
	private Scanner sc;
	private Database db;
	public ProductService() {
		sc = new Scanner(System.in);
		db = Database.getDatabase();
	}
	
	public void addProduct() {
		String ask = "";
		do {
			//type product name
			//type price
			// type qty
			//type category
			Category c = new Category();
			Product p = new Product();
			db.addProduct(p);
			//type ask product 
			
		}while("y".equals(ask));
	}
	
	public void showProduct() {
		/*
		 * Fruit	Orange	1500	2	3000
		 * Fruit	Apple	1000	3	3000
		 * Drink	Cola	1000	1	1000
		 * 
		 * Total						7000
		 * */
		System.out.println(db.getProducts());
	}
}
