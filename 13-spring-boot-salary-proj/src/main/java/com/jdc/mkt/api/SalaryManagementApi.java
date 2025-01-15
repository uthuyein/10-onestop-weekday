package com.jdc.mkt.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.mkt.model.input.SearchSalaryDto;
import com.jdc.mkt.model.output.SelectSalaryDto;
import com.jdc.mkt.model.services.SalaryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/salaries")
public class SalaryManagementApi {
	
	private final SalaryService service;
	
	@GetMapping
	public ResponseEntity<List<SelectSalaryDto>> searchBy(
			@RequestParam(required = false)String employee,
			@RequestParam(required = false)Double amount
			){
		
		var search = new SearchSalaryDto(employee, amount);		
		return new ResponseEntity<List<SelectSalaryDto>>(service.searchBy(search),HttpStatus.OK);
	}
}
