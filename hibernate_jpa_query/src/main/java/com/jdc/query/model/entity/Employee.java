package com.jdc.query.model.entity;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "employee_tbl")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int id;
	
	@Column(name="empName", nullable = false,length = 45)	
	private String name;
	
	private LocalDate dob;
	
	@ColumnDefault("1")
	@Column(name ="empActive")
	private boolean active;
	
	@ManyToOne
	@JoinColumn(name = "dep_id")
	private Department department;
	
	@Override
	public String toString() {
		return name;
	}
	
}
