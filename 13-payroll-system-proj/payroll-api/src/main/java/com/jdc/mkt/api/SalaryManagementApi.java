package com.jdc.mkt.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.mkt.model.entity.Salary;
import com.jdc.mkt.model.input.SearchSalaryDto;
import com.jdc.mkt.model.output.SelectSalaryDto;
import com.jdc.mkt.model.services.SalaryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/salaries")
public class SalaryManagementApi {

	private final SalaryService service;
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Salary> updateSalary(@PathVariable int id,@RequestBody Salary salary) {		
		return new ResponseEntity<Salary>(service.updateSalary(id, salary), HttpStatus.CREATED);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Salary> save(@RequestBody Salary salary) {
		return new ResponseEntity<Salary>(service.save(salary), HttpStatus.CREATED);
    }
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam int id) {
		service.delete(id);
		return new ResponseEntity<String>("Delete Successfully", HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<SelectSalaryDto>> searchBy(@RequestBody(required = false) SearchSalaryDto search) {

		if (null == search) {
			search = new SearchSalaryDto(null, null, null, null);
		}
		return new ResponseEntity<List<SelectSalaryDto>>(service.searchBy(search), HttpStatus.OK);
	}
}
