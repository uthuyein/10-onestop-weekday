package com.jdc.mkt.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "salary_tbl")
public class Salary {

	@Id
	private Integer id;
	private Double amount;
	
	private Double bonus;
	
	@Enumerated(EnumType.STRING)
	private Position position;
	
	public enum Position{
		Casual,Permanent,Senior,Manager
	}
	
}
