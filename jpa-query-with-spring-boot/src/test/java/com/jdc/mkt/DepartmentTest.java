package com.jdc.mkt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jdc.mkt.services.DepartmentService;

public class DepartmentTest {

	@Autowired
	private DepartmentService depService;

	@Test
	void departmentTest() {
		var list = depService.findByEmpNameLikeWithSpec("s");
		System.out.println(list);
	}
}
