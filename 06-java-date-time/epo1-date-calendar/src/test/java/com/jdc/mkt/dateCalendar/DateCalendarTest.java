package com.jdc.mkt.dateCalendar;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DateCalendarTest {
	
	@ParameterizedTest
	@CsvSource("HH:mm:SS,15:44:30")
	void useFormatterTime(String pattern,String params) throws ParseException {
		var format = new SimpleDateFormat(pattern);
		Date d = format.parse(params);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		assertEquals(15,c.get(Calendar.HOUR_OF_DAY));
		assertEquals(3, c.get(Calendar.HOUR));
	}
	
	@SuppressWarnings("deprecation")
	@ParameterizedTest
	@Disabled
	@CsvSource("dd-MM-yyyy,12-02-2013")
	void useFormatterDate(String pattern,String params) throws ParseException {	
		var format = new SimpleDateFormat();
		format.applyPattern(pattern);
		Date d = format.parse(params);
		assertEquals(Calendar.FEBRUARY, d.getMonth());
		assertEquals(12, d.getDate());
	}
	
	@ParameterizedTest
	@Disabled
	@CsvSource("2,13")
	void addDate(int year,int month) {
		var cl = Calendar.getInstance();
		cl.setTime(new Date());
		cl.add(Calendar.YEAR, year);
		cl.add(Calendar.MONTH, month);
		
		assertEquals(2027, cl.get(Calendar.YEAR));
		assertEquals(Calendar.OCTOBER, cl.get(Calendar.MONTH));
		
		cl.roll(Calendar.MONTH, month);
		
		assertEquals(2027, cl.get(Calendar.YEAR));
		assertEquals(Calendar.NOVEMBER, cl.get(Calendar.MONTH));
		
		
	}
	
	@Test
	@Disabled
	void leniencyTest() {
		var cl = Calendar.getInstance();
		cl.setLenient(false);
		cl.set(Calendar.MONTH, 13);
		assertThrows(IllegalArgumentException.class,() -> cl.get(Calendar.MONTH) );
	}

	@Test
	@Disabled
	void createCalendarWithGetAndSet() {
		var cl1 = Calendar.getInstance();
		
//		From setter
		cl1.set(Calendar.YEAR, 2024);
		cl1.set(Calendar.MONTH, 8);
		cl1.set(Calendar.DATE, 3);
		System.out.println(cl1.getTime());
		
//		From setTime
//		cl1.setTime(new Date());
		
		assertAll(() ->{
			assertEquals(2024, cl1.get(1));
			assertEquals(8, cl1.get(2));
			assertEquals(3, cl1.get(5));
		});
	}
	
	@Test
	@Disabled
	void createDate() throws ParseException {
		Date d = new Date();
		System.out.println(d);
		
		Calendar cl = Calendar.getInstance();
		Date d1 = cl.getTime();
		System.out.println(d1);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d2 = df.parse("2024-09-11");
		System.out.println(d2);
	}
}
