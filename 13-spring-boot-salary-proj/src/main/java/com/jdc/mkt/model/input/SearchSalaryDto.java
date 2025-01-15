package com.jdc.mkt.model.input;

import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.jdc.mkt.model.entity.Employee_;
import com.jdc.mkt.model.entity.Salary;
import com.jdc.mkt.model.entity.Salary_;
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
		
		if(StringUtils.hasLength(employee)) {
			params.add(
					cb.equal(root.get(Salary_.employee).get(Employee_.name), employee)
					);
		}
		
		if(null != amount && amount > 0) {
			params.add(
					cb.greaterThanOrEqualTo(root.get(Salary_.amount), amount)
					);
		}
		
		return params.toArray(s -> new Predicate[s]);
	}
}
