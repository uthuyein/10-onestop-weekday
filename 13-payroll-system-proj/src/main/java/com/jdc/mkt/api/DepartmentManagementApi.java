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

import com.jdc.mkt.model.entity.Department;
import com.jdc.mkt.model.input.SearchDepartmentDto;
import com.jdc.mkt.model.output.SelectDepartmentDto;
import com.jdc.mkt.model.services.DepartmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentManagementApi {

	private final DepartmentService service;
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam int id) {
        service.delete(id);
        return new ResponseEntity<String>("Delete Successfully", HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable int id , @RequestBody Department department) {
		var dep = service.update(id,department);
		return new ResponseEntity<String>("Update Successfully with the name of " + dep.getName(), HttpStatus.CREATED);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Department department) {
		var dep = service.save(department);
		return new ResponseEntity<String>("Save Successfully with the name of "+dep.getName(), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<SelectDepartmentDto>> searchBy(
			@RequestParam(required = false) String department) {
		
			var dto = new SearchDepartmentDto(department);
		
		System.out.println("Departments :::::"+dto.keyword());
		return new ResponseEntity<List<SelectDepartmentDto>>(service.search(dto), HttpStatus.OK);
	}
}
