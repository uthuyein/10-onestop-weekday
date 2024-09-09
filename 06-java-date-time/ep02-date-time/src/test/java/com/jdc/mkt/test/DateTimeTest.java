package com.jdc.mkt.test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class DateTimeTest {
	
	@Test
	@Order(4)
	void createHumanToMechine() {
		//From Human To Mechine (Instant)
		LocalDateTime ldt = LocalDateTime.now();
		Instant i1 = ldt.toInstant(ZoneOffset.ofHoursMinutes(+06,30));	
		System.out.println(i1);
		
		Instant i2 = ldt.atZone(ZoneId.of("Asia/Yangon")).toInstant();
		System.out.println(i2);
		
		Instant i3 = ldt.atOffset(ZoneOffset.ofHoursMinutes(+06,30)).toInstant();
		System.out.println(i3);
		
		//From Instant(Mechine) To Human
		ZonedDateTime zdt = i1.atZone(ZoneId.of("America/Chicago"));
		System.out.println(zdt);
		OffsetDateTime odt = i1.atOffset(ZoneOffset.ofHours(-6));
		System.out.println(odt);
		
		System.out.println();
	}
	
	@Test
	@Disabled
	@Order(3)
	void createHumanTimeTest() {
		LocalDateTime ldt = LocalDateTime.now();
		
		ZonedDateTime zdt = ldt.atZone(ZoneId.of("Asia/Yangon"));
		System.out.println(zdt);
		
		OffsetDateTime odt = ldt.atOffset(ZoneOffset.ofHoursMinutes(+06, 30));
		System.out.println(odt);
	}

	@Test
	@Disabled
	@Order(2)
	void createDateTimeWithOfTest() {
		LocalDate d1 = LocalDate.of(2024, 01, 22);
		System.out.println(d1);
		LocalTime t1 = LocalTime.of(13, 02);
		System.out.println(t1);
		LocalDateTime dt = LocalDateTime.of(d1, t1);
		System.out.println(dt);
	}
	
	@Test
	@Disabled
	@Order(1)
	void createDateTimeWithNowTest() {
		//From Human
		LocalDate d1 = LocalDate.now();
		System.out.println(d1);
		LocalTime t1 = LocalTime.now();
		System.out.println(t1);
		LocalDateTime dt1 = LocalDateTime.now();
		System.out.println(dt1);
			
	}
	
	
}


