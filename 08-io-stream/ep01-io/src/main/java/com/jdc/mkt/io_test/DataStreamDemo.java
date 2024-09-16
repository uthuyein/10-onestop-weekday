package com.jdc.mkt.io_test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.jdc.mkt.dto.Book;

public class DataStreamDemo {

	public static void main(String[] args) {
		var book = new Book();
		book.setId(1);
		book.setName("Design Pattern");
		writeData(book);
		readData();
	}
	
	static void readData() {
		try(DataInputStream dIn = 
				new DataInputStream(new FileInputStream("./test/book.dat"))){
			
			System.out.println("Id :"+dIn.readInt()+"\tName :"+dIn.readUTF());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void writeData(Book book) {
		try(DataOutputStream dout = 
				new DataOutputStream(new FileOutputStream("./test/book.dat"))){
			
				dout.writeInt(book.getId());
				dout.writeUTF(book.getName());
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
}
