package com.jdc.mkt.services;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.model.entity.Employee;
import com.jdc.mkt.model.entity.Employee_;
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
	
	public List<Employee> findByEmpNameWithExample(String s){
		var probe = new Employee();
		probe.setName(s);
		var matcher = ExampleMatcher.matching()
					.withIgnoreCase(true)
					.withStringMatcher(StringMatcher.STARTING);
		var example = Example.of(probe,matcher);
		
		return repo.findAll(example);
	}
		
	public List<Employee> findByEmpNameWithSpecification(String s){
		Specification<Employee> spec = (root,cq,cb) -> cb.like(
				cb.lower(
						root.get(
						Employee_.name)), s.toLowerCase().concat("%"));
		
		return repo.findAll(spec);
	}
	
}
