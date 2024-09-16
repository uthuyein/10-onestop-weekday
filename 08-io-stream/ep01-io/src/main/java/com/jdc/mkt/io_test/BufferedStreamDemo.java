package com.jdc.mkt.io_test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BufferedStreamDemo {

	public static void main(String[] args) {
		readFile();
	}
	
	static void readFile() {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			System.out.println("Type message !");
			String mess = br.readLine();
			writeFile(mess);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void writeFile(String message) {
		try(PrintWriter pw = new PrintWriter("./test/test.txt")){
			pw.write(message);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
