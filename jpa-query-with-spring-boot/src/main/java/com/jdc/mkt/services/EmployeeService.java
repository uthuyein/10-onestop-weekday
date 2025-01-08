package com.jdc.mkt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.model.entity.Employee;
import com.jdc.mkt.model.entity.repo.EmployeeRepo;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EmployeeService {
	
	private final EmployeeRepo repo;
	
	public List<Employee> findByEmpNameWithMethod(String s) {
		return repo.findByNameLikeIgnoreCase(s);
	}
	
}
