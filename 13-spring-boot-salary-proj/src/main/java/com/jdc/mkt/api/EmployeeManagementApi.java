package com.jdc.mkt.api;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.mkt.model.entity.Employee;
import com.jdc.mkt.model.input.SearchEmployeeDto;
import com.jdc.mkt.model.output.SelectEmployeeDto;
import com.jdc.mkt.model.services.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeManagementApi {

	private final EmployeeService service;
	
	@GetMapping
	ResponseEntity< List<SelectEmployeeDto>> search(
			@RequestParam(required = false)String employee,
			@RequestParam(required = false)String department,
			@RequestParam(required = false)boolean active,
			@RequestParam(required = false)LocalDate from,
			@RequestParam(required = false)LocalDate to
			){
		var search = new SearchEmployeeDto(employee, department, active, from, to);
		return new ResponseEntity<List<SelectEmployeeDto>> (service.search(search),HttpStatus.OK) ;
	}
	
	@PostMapping
	ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(service.saveEmployee(employee),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody Employee employee){
		return new ResponseEntity<Employee>(service.updateEmployee(id, employee),HttpStatus.CREATED);
	}
	
	@DeleteMapping
	ResponseEntity<String> deleteEmployee(@RequestParam int id){
		service.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted",HttpStatus.OK);
	}
}
