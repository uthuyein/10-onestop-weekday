package com.jdc.mkt.model.output;

import com.jdc.mkt.model.entity.Employee_;
import com.jdc.mkt.model.entity.Salary;
import com.jdc.mkt.model.entity.Salary_;
import com.jdc.mkt.model.entity.Salary.Position;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public record SelectSalaryDto(
		String employee,
		Double amount,
		Double bonus,
		Position position
		) {

	public static void select(CriteriaQuery<SelectSalaryDto> cq,Root<Salary> root) {
		cq.multiselect(
				root.get(Salary_.employee).get(Employee_.name),
				root.get(Salary_.amount),
				root.get(Salary_.bonus),
				root.get(Salary_.position)
				);
	}
}
