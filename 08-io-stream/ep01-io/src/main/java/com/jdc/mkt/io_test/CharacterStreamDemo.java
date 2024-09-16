package com.jdc.mkt.io_test;

import java.io.FileReader;
import java.io.FileWriter;

public class CharacterStreamDemo {

	public static void main(String[] args) {
		writeFile();
		readFile();
	}
	
	static void writeFile() {
		try(FileWriter fw = new FileWriter("./test/test.txt")){
			fw.write("Hello");
			fw.append(" Java");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void readFile() {
		try(FileReader fr = new FileReader("./test/test.txt")){
			
			while(fr.ready()) {
				System.out.print((char)fr.read());
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
