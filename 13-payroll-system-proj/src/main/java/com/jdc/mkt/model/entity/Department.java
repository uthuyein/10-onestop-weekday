package com.jdc.mkt.model.entity;

import java.util.ArrayList;
import java.util.List;

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
	private int id;
	
	@Column(nullable = false , length = 45)
	private String name;
	
	@Column(columnDefinition = "tinyint default 1")
	private boolean active;
	
	@OneToMany(mappedBy = "department",
			cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE},
			orphanRemoval = true)
	private List<Employee> employees = new ArrayList<Employee>();
	
	@Override
	public String toString() {
		return name;
	}
	
	public void addEmployee(List<Employee>  empList) {
		for(Employee employee : empList) {
            employee.setDepartment(this);
        }
		employees.addAll(empList);
		
	}
}










