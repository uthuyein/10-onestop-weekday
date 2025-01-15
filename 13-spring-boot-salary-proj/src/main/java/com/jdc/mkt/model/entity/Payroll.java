package com.jdc.mkt.model.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "payroll_tbl")
public class Payroll {

	@EmbeddedId
	private PayrollPk id;
	
	@ManyToOne
	@MapsId("employeeId")
	private Employee employee;
	
	@ManyToOne
	@MapsId("salaryId")
	private Salary salary;
	
	@ManyToOne
	@MapsId("leaveId")
	private Leave leave;
	
	private Double totalAmount;
}
