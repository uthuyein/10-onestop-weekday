package com.jdc.mkt.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "deduction_tbl")
public class Deduction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Double  tax;
	private Double insurance;
	private Double loanRepayment;
	private Double otherDeductions;
	
	@ManyToOne
	private Salary salary;
}
