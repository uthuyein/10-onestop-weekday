package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.Day;

public class EnumTest {

	@Test
	void defaultMethodTest() {
		Day d = Day.MON;
		
		assertEquals(0, d.ordinal());
		assertTrue(d.ordinal() == 0);
		
		assertEquals("MON", d.name());
	
		assertEquals(Day.MON, Day.valueOf("MON"));
		assertEquals(7, Day.values().length);
		
		assertNotNull(d);
		
		d = null;
		assertNull(d);
	}
	
	@Test
	void constantTest() {
		Day[] array = Day.values();
		for(int i = 0 ; i < array.length ; i ++) {		
			assertEquals(i, array[i].ordinal());
		}
	}
	
	@Test
	void methodTest() {
		assertEquals("Monday", Day.MON.getName());
		assertEquals("Tuesday", Day.TUE.getName());
		assertEquals(3, Day.WED.getNumber());		
	}
}
