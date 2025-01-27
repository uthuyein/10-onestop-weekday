package com.jdc.mkt.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.mkt.model.entity.Payroll;
import com.jdc.mkt.model.entity.PayrollPk;
import com.jdc.mkt.model.input.SearchPayrollDto;
import com.jdc.mkt.model.output.SelectPayrollDto;
import com.jdc.mkt.model.services.PayrollService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payroll")
public class PayrollManagementApi {
	
	private final PayrollService service;
	
	@DeleteMapping
	void delete(@RequestBody PayrollPk id) {
		service.delete(id);
	}
	
	@PutMapping("/update")
	Payroll update(@RequestBody Payroll pay) {
		return service.update(pay);
	}
	
	@PostMapping("/save")
	Payroll save(@RequestBody Payroll pay) {
		return service.save(pay);
	}

	@GetMapping
	List<SelectPayrollDto> search(@RequestBody(required = false) SearchPayrollDto search){
		if(null == search){
			search = new SearchPayrollDto(0, 0, 0, null, null, null);
		}
		return service.search(search);
	}
}
