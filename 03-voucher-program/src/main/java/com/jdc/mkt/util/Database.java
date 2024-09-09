package com.jdc.mkt.util;

import com.jdc.mkt.entity.Product;

public class Database {
	private Product[] products;
	private static Database instance;
	
	private Database() {
		products = new Product[0];
	}
	
	public static Database getDatabase() {
		if(null == instance) {
			instance = new Database();
		}
		return instance;
	}
	
	public void addProduct(Product product) {
		//change to unlimitted product array and add product to array
	}
	public Product[] getProducts() {
		return products;
	}
}
