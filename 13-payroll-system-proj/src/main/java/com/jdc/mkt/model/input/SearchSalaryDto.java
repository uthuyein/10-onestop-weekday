package com.jdc.mkt.model.input;

import java.util.ArrayList;

import com.jdc.mkt.model.entity.Salary;
import com.jdc.mkt.model.output.SelectSalaryDto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public record SearchSalaryDto(
		String employee,
		Double amount
		) {

	public Predicate[] search(CriteriaBuilder cb,CriteriaQuery<SelectSalaryDto> cq,Root<Salary> root) {
		var params = new ArrayList<Predicate>();
		
		
		
		
		return params.toArray(s -> new Predicate[s]);
	}
}
