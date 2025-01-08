package com.jdc.mkt.model.entity.repo;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.mkt.model.entity.Employee;

public interface EmployeeRepo extends JpaRepositoryImplementation<Employee, Integer>{

	
	List<Employee> findByNameLikeIgnoreCase(String s);

}
