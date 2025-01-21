package com.jdc.mkt.model.input;

import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.jdc.mkt.model.entity.Department;
import com.jdc.mkt.model.entity.Department_;
import com.jdc.mkt.model.entity.Employee_;
import com.jdc.mkt.model.output.SelectDepartmentDto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public record SearchDepartmentDto(
		String keyword
		) {

	public Predicate[] search(CriteriaBuilder cb,CriteriaQuery<SelectDepartmentDto> cq,Root<Department> root) {
		var params = new ArrayList<Predicate>();
		
		var join = root.join(Department_.employees);
		
		if(StringUtils.hasLength(keyword)) {
			   params.add(  cb.or(
					 cb.equal(root.get(Department_.name), keyword),
					cb.like(cb.lower(join.get(Employee_.name)), keyword.toLowerCase().concat("%"))			
					));
		}
		
		return params.toArray(size -> new Predicate[size]);
	}
}
