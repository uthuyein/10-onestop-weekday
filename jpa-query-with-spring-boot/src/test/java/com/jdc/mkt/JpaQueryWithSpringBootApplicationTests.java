package com.jdc.mkt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.mkt.services.DepartmentService;
import com.jdc.mkt.services.EmployeeService;

@SpringBootTest
class JpaQueryWithSpringBootApplicationTests {

	@Autowired
	private EmployeeService service;
	@Autowired
	private DepartmentService depService;
	
	//@Test
	void methodTest() {
		var list = service.findByEmpNameWithSpecification("s");
		System.out.println(list);
	}
	
	
	@Test
	void departmentTest() {
		var list = depService.findByEmpNameLikeWithSpec("s");
		System.out.println(list);
	}


}
