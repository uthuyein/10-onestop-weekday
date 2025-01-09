package com.jdc.mkt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.mkt.services.EmployeeService;

@SpringBootTest
class EmployeeTest {

	@Autowired
	private EmployeeService service;
	
	@Test
	void methodTest() {
		var list = service.findByEmpNameWithMethod("s");
		System.out.println(list);
	}

	@Test
	void exampleTest() {
		var list = service.findByEmpNameWithExample("s");
		System.out.println(list);
	}

	@Test
	void specificationTest() {
		var list = service.findByEmpNameWithSpecification("s");
		System.out.println(list);
	}

}
