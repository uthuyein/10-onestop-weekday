package com.jdc.mkt.model.entity.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jdc.mkt.model.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>,JpaSpecificationExecutor<Employee>{

	
	List<Employee> findByNameLikeIgnoreCase(String s);

}
