package com.jdc.mkt.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "salary_tbl")
public class Salary {

	@Id
	private Integer id;

	private Double basicPay;
	private Double allowances;
	
	private Double netSalary;
	
	@OneToMany(mappedBy = "salary")
	private List<Deduction>  deductions;
	
	@OneToMany(mappedBy = "salary")
	private List<Bonus> bonuses;
	
	@Enumerated(EnumType.STRING)
	private Position position;
	
	public enum Position{
		Casual,Permanent,Senior,Manager
	}
}
