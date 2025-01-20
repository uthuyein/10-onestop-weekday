package com.jdc.mkt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.mkt.model.input.SearchEmployeeDto;
import com.jdc.mkt.model.services.EmployeeService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class EmployeeTest {
	
	@Autowired
	EmployeeService service;

	@Order(1)
	@ParameterizedTest
	@CsvSource({
		"s,,,,,3",
		",IT,,,,3",
		",,,2000-11-13,2001-09-21,3",
		"a,IT,,2000-11-13,2001-09-21,1"
	})
	void search(String employee,String department,Boolean active,LocalDate from,LocalDate to,int res) {
		var search = new SearchEmployeeDto(employee, department, active, from, to);
		var list = service.search(search);
		assertEquals(res, list.size());
	}

}
