package com.jdc.query.model.entity;

import java.util.List;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "department_tbl")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id")
	private int id;
	@Column(name="depName", nullable = false , length = 45)
	private String name;
	@ColumnDefault("1")
	@Column(name ="depActive")
	private boolean active;
	
	@OneToMany(mappedBy = "department",
			cascade = CascadeType.PERSIST,
			orphanRemoval = true)
	private List<Employee> employees;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
}










