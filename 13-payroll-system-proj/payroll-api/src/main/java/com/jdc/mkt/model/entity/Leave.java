package com.jdc.mkt.model.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "leave_tbl")
public class Leave {

	@EmbeddedId
	private LeavePk id;
	
	private String reason;
	
	@ManyToOne
	@MapsId("employeeId")
	private Employee employee;
	
	@Enumerated(EnumType.STRING)
	private LeaveType leaveType;
	
	public enum LeaveType{
		Annual,Paid,Medical
	}
}
