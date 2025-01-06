package com.jdc.query.test;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class B_FindAllWithPredicateQueryTest extends JpaEmfFactory{

	@Order(1)
	@ParameterizedTest
	@CsvSource("s")
	void findWithNativeQueryTest(String name) {}
	
	@Order(2)
	@ParameterizedTest
	@CsvSource("s")
	void findWithJpqlQueryTest(String name) {}
	
	@Order(3)
	@ParameterizedTest
	@CsvSource("s")
	void findWithCriteriaQueryTest(String name) {}
}
