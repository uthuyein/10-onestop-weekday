package com.jdc.mkt.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<List<SelectSalaryDto>> searchBy(@RequestBody(required = false) SearchSalaryDto search) {

		if (null == search) {
			search = new SearchSalaryDto(null, null, null, null);
		}
		System.out.println("Salaries ::::::");
		return new ResponseEntity<List<SelectSalaryDto>>(service.searchBy(search), HttpStatus.OK);
	}
}
