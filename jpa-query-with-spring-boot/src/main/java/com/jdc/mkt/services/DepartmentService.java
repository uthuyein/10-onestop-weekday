package com.jdc.mkt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.jdc.mkt.model.entity.Department;
import com.jdc.mkt.model.entity.Department_;
import com.jdc.mkt.model.entity.Employee_;
import com.jdc.mkt.model.entity.repo.DepartmentRepo;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepo repo;
	
	public List<Department> findByEmpNameLikeWithSpec(String s){
		Specification<Department> spec = (root,cq,cb) -> {
			
			var join = root.join(Department_.employees);
			var predicate = cb.like(
					cb.lower(
					join.get(Employee_.name)),
					s.toLowerCase().concat(s));
			
					return predicate;
		};
		return repo.findAll(spec);
	}
}
