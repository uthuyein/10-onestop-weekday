package com.jdc.mkt.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class CustomAnnoWithParamUseValueDemo {

	@Message("This is annotation message !")
	private static String message;
	
	public static void main(String[] args) {
		addValue(null);
		System.out.println(message);
	}
	
	static void addValue(String value) {
		if(null == value) {
			message =  getFieldValue();
		}else {
			message = value;
		}
	}
	
	static String getFieldValue() {
		try {
			Field f = CustomAnnoWithParamUseValueDemo.class
					 .getDeclaredField("message");
			Message mes = f.getAnnotation(Message.class);
			if(null != mes) {
				return mes.value();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Message{
	String value() default "No Message";
}
