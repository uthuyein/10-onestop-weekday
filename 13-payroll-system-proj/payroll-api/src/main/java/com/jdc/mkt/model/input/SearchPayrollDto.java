package com.jdc.mkt.model.input;

import com.jdc.mkt.model.entity.Payroll;
import com.jdc.mkt.model.entity.Payroll_;
import com.jdc.mkt.model.entity.Salary_;

import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.jdc.mkt.model.entity.Department_;
import com.jdc.mkt.model.entity.Employee;
import com.jdc.mkt.model.entity.Employee_;
import com.jdc.mkt.model.entity.Leave.LeaveType;
import com.jdc.mkt.model.entity.Leave_;
import com.jdc.mkt.model.output.SelectPayrollDto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public record SearchPayrollDto(
		int salaryId,
		int leaveId,
		int employeeId,
		String department,
		String employee,
		LeaveType leaveType		
		) {

	public Predicate[] search(CriteriaBuilder cb, CriteriaQuery<SelectPayrollDto> cq,Root<Payroll> root, Join<Payroll, Employee> join) {
		var params = new ArrayList<Predicate>();
		
		if(0 > salaryId ) {
			params.add(
					cb.equal(root.get(Payroll_.salary).get(Salary_.id), salaryId)
					);
		}
		if(0 > leaveId) {
			params.add(
					cb.equal(root.get(Payroll_.leave).get(Leave_.id), leaveId)
					);
		}
		if(0 > employeeId) {
			params.add(
					cb.equal(join.get(Employee_.id), employeeId)
					);
		}
		
		if(StringUtils.hasLength(department)) {
			params.add(
					cb.equal(cb.lower( join.get(Employee_.department).get(Department_.name)), department.toLowerCase())
					);
		}
		if(StringUtils.hasLength(employee)) {
			params.add(
					cb.equal(
							cb.lower(join.get(Employee_.name)), employee.toLowerCase())
					);
		}
		if(null != leaveType) {
			params.add(
					cb.equal(root.get(Payroll_.leave).get(Leave_.leaveType), leaveType)
					);
		}
				
		return params.toArray(s -> new Predicate[s]);
	}
}
