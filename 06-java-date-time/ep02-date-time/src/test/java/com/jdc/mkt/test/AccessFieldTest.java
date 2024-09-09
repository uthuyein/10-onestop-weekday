package com.jdc.mkt.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class AccessFieldTest {
	
	@Test
	void adjustDateTimeTest() {
		var ldt = LocalDateTime.now();
		
		//using with temporaladjustor
		var ldt1 = ldt.with(LocalDate.of(2011, 01, 11));
		System.out.println(ldt1);
		
		// using with temporal amount
		var ldt2 = ldt.plus(Period.ofDays(7));
		System.out.println(ldt2);
		
		var ldt3 = ldt.minus(Period.ofMonths(4));
		System.out.println(ldt3);
		
		//using with temporal unit
		var ldt4 = ldt.plus(4, ChronoUnit.MONTHS);
		System.out.println(ldt4);
		
		
	}

	@Test
	@Disabled
	void getAndFluentTest() {
		var ldt = LocalDateTime.now();
		
		//using temporalfield
		var year = ldt.get(ChronoField.YEAR);
		var month = ldt.get(ChronoField.MONTH_OF_YEAR);
		var day = ldt.get(ChronoField.DAY_OF_YEAR);
		var weekDay = ldt.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
		System.out.println(year+"\t"+month+"\t"+day+"\t"+weekDay);
		
		//using fluent method	
		var year1 = ldt.getYear();
		var month1 = ldt.getMonth();
		var day1 = ldt.getDayOfMonth();
		System.out.println(year1+"\t"+month1+"\t"+day1);
	}
}
