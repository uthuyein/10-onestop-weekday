package com.jdc.mkt.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// can't create method with args when use method anno
public class CustomAnnoWithMethodParamDemo {
	private static Days[] days;
	
	public static void main(String[] args) {
		//setDays(Days.FRI,Days.MON);
		useDay();
	}
	
	static void setDays(Days...days) {
		CustomAnnoWithMethodParamDemo.days = days;
	}
	
	@DayAno({Days.SAT,Days.SUN})
	static void useDay() {
		
	    if(null == days) {
			days = getDays();
		}
		
		for(Days d : days) {
			System.out.println(d);
		}
		
	}

	static Days[] getDays() {
		try {
			Method m = CustomAnnoWithMethodParamDemo.class
					.getDeclaredMethod("useDay");	
			DayAno anno = m.getDeclaredAnnotation(DayAno.class);
			
			if(null != anno) {
				return anno.value();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
enum Days{
	MON,TUE,WED,THUR,FRI,SAT,SUN
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface DayAno{
	Days[] value() default {Days.MON};
}






