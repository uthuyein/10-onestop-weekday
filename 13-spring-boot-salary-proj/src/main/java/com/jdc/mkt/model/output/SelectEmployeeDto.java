package com.jdc.mkt.model.output;

import java.time.LocalDate;

import org.hibernate.query.Order;

import com.jdc.mkt.model.entity.Department_;
import com.jdc.mkt.model.entity.Employee;
import com.jdc.mkt.model.entity.Employee_;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public record SelectEmployeeDto(
		int id,
		String employee,
		LocalDate dob,
		String department
		
		) {

	public static void select(CriteriaQuery<SelectEmployeeDto> cq,Root<Employee> root) {
		cq.multiselect(
				root.get(Employee_.id),
				root.get(Employee_.name),
				root.get(Employee_.dob),
				root.get(Employee_.department).get(Department_.name)
				);
		
	}
}







