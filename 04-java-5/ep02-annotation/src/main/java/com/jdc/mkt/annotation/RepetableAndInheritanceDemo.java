package com.jdc.mkt.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class RepetableAndInheritanceDemo {
	
//	@Messages({
//		@Word("Test Message One"),
//		@Word("Test Message Two")
//	})
	@Word("Test Message One")
	@Word("Test Message Two")
	private String message;
	
	public static void main(String[] args) {
		getAnnoValue();
	}
	
	static void getAnnoValue() {
		Inherit h = Circle.class.getAnnotation(Inherit.class);
		if(null != h) {
			System.out.println("There have @Inherit annotation ");
		}else {
			System.out.println("There have not @Inherit annotation ");
		}
	}
}


@Inherit("Interface Two")
class Draw{}
class Circle extends Draw{}

// Test @Inherited

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Inherit{
	String value();
	
	int name = 10 ;
	class Hello{}
	
}

//Test @Repeatable

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE})
@interface Messages{
	Word[] value();
}

@Repeatable(Messages.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE})
@interface Word{
	String value();
}
