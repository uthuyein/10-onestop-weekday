package com.jdc.mkt.model.output;

import java.time.LocalDate;

import com.jdc.mkt.model.entity.Employee_;
import com.jdc.mkt.model.entity.Leave;
import com.jdc.mkt.model.entity.Leave.LeaveType;
import com.jdc.mkt.model.entity.LeavePk_;
import com.jdc.mkt.model.entity.Leave_;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public record SelectLeaveDto(
		int employeeId,
		String employee,
		LeaveType leaveType,
		String reason,
		LocalDate frmDate,
		LocalDate toDate
		) {

	public static void select(CriteriaQuery<SelectLeaveDto> cq,Root<Leave> root) {
		
		cq.multiselect(
				root.get(Leave_.employee).get(Employee_.id),
				root.get(Leave_.employee).get(Employee_.name),
				root.get(Leave_.leaveType),
				root.get(Leave_.reason),
				root.get(Leave_.id).get(LeavePk_.frmDate),
				root.get(Leave_.id).get(LeavePk_.toDate)
				);
	}
}
