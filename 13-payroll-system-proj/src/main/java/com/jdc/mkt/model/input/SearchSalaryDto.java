package com.jdc.mkt.model.input;

import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.jdc.mkt.model.entity.Salary;
import com.jdc.mkt.model.entity.Salary.Position;
import com.jdc.mkt.model.entity.Salary_;
import com.jdc.mkt.model.output.SelectSalaryDto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public record SearchSalaryDto(Double allowances, Double basicPay, Double netSalary, Position position) {

	public Predicate[] search(CriteriaBuilder cb, CriteriaQuery<SelectSalaryDto> cq, Root<Salary> root) {
		var params = new ArrayList<Predicate>();

		if (null != allowances && allowances > 0) {
			params.add(
					cb.equal(root.get(Salary_.allowances), allowances)
					);
		}
		if (null != basicPay && basicPay > 0) {
			params.add(
					cb.ge(root.get(Salary_.basicPay), basicPay)
					);
		}
		if (null != netSalary && netSalary > 0) {
			params.add(
					cb.greaterThanOrEqualTo(root.get(Salary_.netSalary), netSalary)
					);
		}
		
		if(null != position) {
			params.add(
					cb.equal(root.get(Salary_.position), position)
					);
		}

		return params.toArray(s -> new Predicate[s]);
	}
}
