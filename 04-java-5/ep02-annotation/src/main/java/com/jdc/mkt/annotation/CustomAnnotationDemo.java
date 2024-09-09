package com.jdc.mkt.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class CustomAnnotationDemo {}

@MyAnnoType
class TestOne{
	
	@MyAnnoField
	String name;
	@MyAnnoMethod
	void show() {}
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnoMethod{}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MyAnnoField{}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@interface MyAnnoType{}
