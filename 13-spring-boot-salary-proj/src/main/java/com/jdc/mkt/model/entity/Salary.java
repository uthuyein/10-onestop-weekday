package com.jdc.mkt.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "salary_tbl")
public class Salary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double amount;
	
	private Double bonus;
	
	@ManyToOne
	private Employee employee;
	
	@Enumerated(EnumType.STRING)
	private Position position;
	
	public enum Position{
		Casual,Permanent,Senior,Manager
	}
	
}
