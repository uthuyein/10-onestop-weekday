package com.jdc.mkt.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class LeavePk implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "employee_id")
	private int employeeId;
	
	private LocalDate frmDate;
	private LocalDate toDate;

}
