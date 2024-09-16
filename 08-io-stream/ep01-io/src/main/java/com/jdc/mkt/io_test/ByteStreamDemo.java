package com.jdc.mkt.io_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo {

	static File file;
	
	public static void main(String[] args) throws IOException {
		createFile();
		outputStream();
		inputStream();
	}
	static void createFile() throws IOException {
		var dir = new File("./test");
		dir.mkdir();
		file = new File(dir,"test.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
	}
	static void inputStream() {
		try(FileInputStream in = new FileInputStream(file)){
			for(Byte b : in.readAllBytes()) {
				char c = (char)b.intValue();
				System.out.print(c);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void outputStream() {
		try(FileOutputStream out = new FileOutputStream(file)){
			var str = "Hello";
			out.write(str.getBytes());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
