package com.jdc.mkt.file;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class FileTest {

	// Relative path is not start with / slash
	// Absolute path is start with / slash
	
	@Test
	void directoryTest() throws IOException {
		var dir = new File("./test/testOne");
		dir.mkdirs();
		var file = new File(dir,"test.txt");
		file.createNewFile();
		file.setReadOnly();
		file.setWritable(false);
		
		file.setReadable(false);
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	@Disabled
	void methodTest() throws IOException {
		var file = new File("hello.txt");
		assertFalse(file.exists());
		
		file.createNewFile();
		assertTrue(file.exists());
		
		file.delete();
		assertFalse(file.exists());
		
		file.createNewFile();
		assertTrue(file.exists());
		
		file.deleteOnExit();
		assertTrue(file.exists());
		
		assertFalse(file.isAbsolute());
		assertFalse(file.isDirectory());
		assertTrue(file.isFile());
		assertFalse(file.isHidden());
		
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getParent());
		System.out.println(file.getName());
		System.out.println(file.toURI());
		System.out.println(file.toURL());
	}
	
	@Test
	@Disabled
	void createFileTest() throws IOException, URISyntaxException {
		
		//File f = new File("./hello.txt");
		//File f = new File("/Users/MKT/Desktop/fileTest/hello.txt");
		//File f = new File("/Users/MKT/Desktop/fileTest","hello.txt");
	
//		File dir = new File("/Users/MKT/Desktop/fileTest");
//		File f = new File(dir, "hello.txt");
		
		URI uri = new URI("file:///Users/MKT/Desktop/fileTest/hello.txt");
		File f = new File(uri);
		
		assertFalse(f.exists());
		f.createNewFile();
		assertTrue(f.exists());
	}
}
