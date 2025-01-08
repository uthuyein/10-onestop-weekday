package com.jdc.mkt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.mkt.services.EmployeeService;

@SpringBootTest
class JpaQueryWithSpringBootApplicationTests {

	@Autowired
	private EmployeeService service;
	
	@Test
	void methodTest() {
		var list = service.findByEmpNameWithMethod("s".concat("%"));
		System.out.println(list);
	}

}
