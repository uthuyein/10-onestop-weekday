package com.jdc.mkt.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class CustomAnnoWithParamDemo {
	@MyAnnoParam(name = "Aung Aung",age = 23,day = Day.MON)
	private String name;
	
	@MyAnnoValue({"test1","test2"})
	void useValue() {}
}
enum Day{
	MON,TUE;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnoValue{
	String[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MyAnnoParam{
	String name();
	int age();
	Day day();
}





