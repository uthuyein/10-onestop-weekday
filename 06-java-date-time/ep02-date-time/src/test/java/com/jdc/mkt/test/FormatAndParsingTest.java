package com.jdc.mkt.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class FormatAndParsingTest {
	
	@Test
	void formatterWithCustomTest() {
		var fDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		var date = LocalDate.parse("22-11-2011", fDate);
		System.out.println(date);
		
		var fTime = DateTimeFormatter.ofPattern("hh:mm:ss a");
		var time = LocalTime.parse("01:20:23 PM",fTime);
		System.out.println(time);
		
		var fZdt = DateTimeFormatter.ofPattern("dd-MM-yyyy 'at' hh:mm:ss a 'zoneId =' z");
		var zdt = ZonedDateTime.parse("22-11-2011 at 01:20:23 PM zoneId = Asia/Yangon",fZdt);
		System.out.println(zdt);
	}
	
	@Test
	@Disabled
	void formatterWithLocalizeTest() {
		
		var zdt = ZonedDateTime.now();
		String str = zdt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL));
		System.out.println(str);
		
		var ldt1 = ZonedDateTime.parse("Monday, September 9, 2024, 3:16:39 PM Myanmar Time", DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)) ;
		System.out.println(ldt1);
		
		var ld = LocalDate.parse("Sunday, January 30, 2022", DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
		System.out.println(ld);
		
		String str1 =  ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
		System.out.println(str1);
	}

	@Test
	@Disabled
	void formatterWithISOTest() {
		var format1 = DateTimeFormatter.ISO_LOCAL_DATE;
		var ld = LocalDate.parse("2012-12-23", format1);
		System.out.println(ld);
		
		var format2 = DateTimeFormatter.ISO_DATE_TIME;
		var ldt = LocalDateTime.parse("2011-12-03T10:15:30+01:00", format2);
		System.out.println(ldt);
	}
	
	
}
