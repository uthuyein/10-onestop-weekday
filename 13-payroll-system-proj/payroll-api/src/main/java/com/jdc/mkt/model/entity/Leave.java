package com.jdc.mkt.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "leave_tbl")
public class Leave {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private LocalDate fromDt;
	private LocalDate toDt;
	private String reason;
	
	@ManyToOne
	private Employee employee;
	
	@Enumerated(EnumType.STRING)
	private LeaveType leaveType;
	
	public enum LeaveType{
		Annual,Paid,Medical
	}
}
