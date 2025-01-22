package com.jdc.mkt.model.output;

import com.jdc.mkt.model.entity.Bonus_;
import com.jdc.mkt.model.entity.Deduction_;
import com.jdc.mkt.model.entity.Salary;
import com.jdc.mkt.model.entity.Salary.Position;
import com.jdc.mkt.model.entity.Salary_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public record SelectSalaryDto(
		Double allowances,
		Double basicPay,
		Double netSalary,
		Position position,
		long countBonuses,
		long countDeductions
		) {

	public static void select(CriteriaBuilder cb,CriteriaQuery<SelectSalaryDto> cq,Root<Salary> root) {
		
		var bonuses = root.join(Salary_.bonuses);
		var deductions = root.join(Salary_.deductions);
		
		cq.multiselect(
                root.get(Salary_.allowances),
                root.get(Salary_.basicPay),
                root.get(Salary_.netSalary),
				root.get(Salary_.position),
				cb.count(bonuses.get(Bonus_.id)),
				cb.count(deductions.get(Deduction_.id))
                );
		
		cq.groupBy(
				root.get(Salary_.allowances),
                root.get(Salary_.basicPay),
                root.get(Salary_.netSalary),
				root.get(Salary_.position));
	}
}
