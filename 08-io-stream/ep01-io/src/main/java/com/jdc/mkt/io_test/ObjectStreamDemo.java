package com.jdc.mkt.io_test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.jdc.mkt.dto.Author;
import com.jdc.mkt.dto.Book;

public class ObjectStreamDemo {

	public static void main(String[] args) {
		var book = new Book();
		book.setId(1);
		book.setName("Solid Principles");
		book.setPrice(3000);
		book.setAuthor(new Author(1, "GOF"));
		writeObject(book);
		readObject();
	}
	
	static void readObject() {
		try(ObjectInputStream oin = 
				new ObjectInputStream(new FileInputStream("./test/book.obj"))){
			
			Book book =  (Book) oin.readObject();
			
			System.out.println("Id : "+book.getId());
			System.out.println("Name : "+book.getName());
			System.out.println("Price : "+book.getPrice());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void writeObject(Book book) {
		try(ObjectOutputStream oos = 
				new ObjectOutputStream(new FileOutputStream("./test/book.obj"))){
			
			oos.writeObject(book);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
