package com.jdc.mkt.test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TemporalAmountTest {
	
	@Test
	void useFromTest() {
		Duration du = Duration.from(Duration.ofMinutes(5));
		System.out.println(du.toMinutes());
		System.out.println(du.getUnits());
		
		Period p = Period.from(Period.ofDays(320));
		System.out.println(p.getMonths());
		System.out.println(p.getUnits());
	}
	
	@Test
	@Disabled
	void useBetweenTest() {
		Duration du = Duration.between(LocalTime.of(5, 45), LocalTime.of(6, 44));
		System.out.println(du.toMinutes());
		
		Period p = Period.between(LocalDate.of(2024, 9, 9), LocalDate.of(2025, 5, 21));
		System.out.println(p.toTotalMonths());
	}

	@Test
	@Disabled
	void usePeriodTest() {
		var ldt = LocalDateTime.now();
		System.out.println(ldt.plus(Duration.ofHours(5)));
		System.out.println(ldt.plus(Period.ofMonths(3)));
		
		//can't use Duration in localDate
		var ld = LocalDate.now();
		System.out.println(ld.minus(Period.ofDays(30)));
		
		//can't use Period on localTime
		var lt = LocalTime.now();
		System.out.println(lt.plus(Duration.ofDays(2)));
		
	}
}
