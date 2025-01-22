package com.jdc.mkt.model.input;

import java.time.LocalDate;
import java.util.ArrayList;

import com.jdc.mkt.model.entity.Employee_;
import com.jdc.mkt.model.entity.Leave;
import com.jdc.mkt.model.entity.Leave.LeaveType;
import com.jdc.mkt.model.entity.LeavePk_;
import com.jdc.mkt.model.entity.Leave_;
import com.jdc.mkt.model.output.SelectLeaveDto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public record SearchLeaveDto(int employeeId, String employee, LeaveType leaveType, LocalDate frmDate,
		LocalDate toDate) {

	public Predicate[] search(CriteriaBuilder cb, CriteriaQuery<SelectLeaveDto> cq, Root<Leave> root) {
		var params = new ArrayList<Predicate>();

		if (employeeId > 0) {
			params.add(cb.equal(root.get(Leave_.employee).get(Employee_.id), employeeId));
		}

		if (null != employee && !employee.isEmpty()) {
			params.add(cb.equal(root.get(Leave_.employee).get(Employee_.name), employee));
		}

		if (null != leaveType) {
			params.add(cb.equal(root.get(Leave_.leaveType), leaveType));
		}
		if (null != frmDate && null != toDate) {
			params.add(
					cb.and(
					cb.greaterThanOrEqualTo(root.get(Leave_.id).get(LeavePk_.frmDate), frmDate),
					cb.lessThanOrEqualTo(root.get(Leave_.id).get(LeavePk_.toDate), toDate)));
		}

		return params.toArray(size -> new Predicate[params.size()]);
	}
}
