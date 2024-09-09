package com.jdc.mkt.nestedClass;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.nestedClasses.Animal;
import com.jdc.mkt.nestedClasses.Animal.Cat;
import com.jdc.mkt.nestedClasses.Animal.Lion;

public class NestedTest {
	
	@Test
	void testNonStaticNestedClass() {
		Animal an = new Animal();
		Lion l = an.new Lion();
		l.doSomething();
	}
	@Test
	@SuppressWarnings("unused")
	void testStaticNestedClass() {
		Cat c = new Animal.Cat();
		Animal.Cat.show();
	}
}
