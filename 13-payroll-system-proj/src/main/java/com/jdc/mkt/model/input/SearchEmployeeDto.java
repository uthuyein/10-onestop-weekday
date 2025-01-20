package com.jdc.mkt.model.input;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.jdc.mkt.model.entity.Department_;
import com.jdc.mkt.model.entity.Employee;
import com.jdc.mkt.model.entity.Employee_;
import com.jdc.mkt.model.output.SelectEmployeeDto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public record SearchEmployeeDto(		
		String employee,
		String department,
		Boolean active,
		LocalDate from,
		LocalDate to		
		) {

	public Predicate[] search(CriteriaBuilder cb,CriteriaQuery<SelectEmployeeDto> cq,Root<Employee> root) {
		var params = new ArrayList<Predicate>();
		
		if(StringUtils.hasLength(employee)) {
			params.add(
					cb.like(cb.lower(
							root.get(Employee_.name)), 
							employee.toLowerCase().concat("%"))
					);
		}
		
		if(StringUtils.hasLength(department)) {
			params.add(
					cb.equal(cb.lower(
							root.get(Employee_.department).get(Department_.name)), 
							department.toLowerCase())
					);
		}
		
		if(null != active && active) {
			params.add(
					cb.equal(root.get(Employee_.active), active)
					);
		}
		
		if(null != from && null != to) {
			params.add(
					cb.between(root.get(Employee_.dob), from, to)
					);
		}
		return params.toArray(size -> new Predicate[size]);
	}
	
	
	
	
	
	
	
	
	
	
}
