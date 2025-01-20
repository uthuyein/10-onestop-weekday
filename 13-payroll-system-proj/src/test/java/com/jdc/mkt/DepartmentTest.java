package com.jdc.mkt;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.mkt.model.input.SearchDepartmentDto;
import com.jdc.mkt.model.services.DepartmentService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class DepartmentTest {
	
	@Autowired
	DepartmentService service;

	@ParameterizedTest
	@CsvSource({
		"s,1"
	})
	void search(String keyword,int res) {
		var list = service.search(new SearchDepartmentDto(keyword));
		System.out.println(list);
	}
}
