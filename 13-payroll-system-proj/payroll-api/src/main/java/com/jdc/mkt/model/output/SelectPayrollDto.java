package com.jdc.mkt.model.output;

import com.jdc.mkt.model.entity.Department_;
import com.jdc.mkt.model.entity.Employee;
import com.jdc.mkt.model.entity.Employee_;
import com.jdc.mkt.model.entity.Leave_;
import com.jdc.mkt.model.entity.Payroll;
import com.jdc.mkt.model.entity.Payroll_;
import com.jdc.mkt.model.entity.Salary_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

public record SelectPayrollDto(
		int salaryId,
		int leaveId,
		int employeeId,
		String department,
		String employee,
		Double total	
		) {

	public static void select(CriteriaBuilder cb, CriteriaQuery<SelectPayrollDto> cq,Root<Payroll> root, Join<Payroll, Employee> empJoin) {
		
		cq.select(
				cb.construct(
						SelectPayrollDto.class,
						root.get(Payroll_.salary).get(Salary_.id),
						root.get(Payroll_.leave).get(Leave_.id),
						empJoin.get(Employee_.id),
						empJoin.get(Employee_.department).get(Department_.name),					
						empJoin.get(Employee_.name),
						root.get(Payroll_.totalAmount)
						)
				);
	}
}
