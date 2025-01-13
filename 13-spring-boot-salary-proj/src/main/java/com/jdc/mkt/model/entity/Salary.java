package com.jdc.mkt.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Salary {

	@Id
	private Integer id;
	private Double amount;
	
	@ManyToOne
	private Employee employee;
	
	private LocalDate fromDate;
	private LocalDate toDate;
	
	@Enumerated(EnumType.STRING)
	private LeaveType leaveType;
	
	public enum LeaveType {
		Annual,Medical,Paid
	}
}
