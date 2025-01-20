package com.jdc.mkt.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class PayrollPk implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "employee_id")
	private int employeeId;
	
	@Column(name = "salary_id")
	private int salaryId;
	
	@Column(name = "leave_id")
	private int leaveId;
}
