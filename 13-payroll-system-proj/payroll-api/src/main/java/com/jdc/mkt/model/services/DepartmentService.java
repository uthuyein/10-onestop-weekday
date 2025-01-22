package com.jdc.mkt.model.services;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.model.entity.Department;
import com.jdc.mkt.model.input.SearchDepartmentDto;
import com.jdc.mkt.model.output.SelectDepartmentDto;
import com.jdc.mkt.model.repo.DepartmentRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Service
@Transactional(readOnly = true)
public class DepartmentService {

	@Autowired
	private DepartmentRepo repo;
	
	@Transactional
	public Department save(Department department) {
		department.addEmployee(department.getEmployees());	
		return repo.save(department);
	}
	
	@Transactional	
	public Department update(int id, Department department) {
		var dep = repo.findById(id).orElseThrow(() -> new RuntimeException("No Department ID Found"));
		dep.setName(department.getName());
		dep.setActive(department.isActive());
		
		var emps = dep.getEmployees();
		dep.addEmployee(emps);
		
		return repo.save(dep);
	}
	
	@Transactional
	public void delete(int id) {
		var dep = repo.findById(id).orElseThrow(() -> new RuntimeException("No Department ID Found"));
		repo.delete(dep);
	}
	
	public List<SelectDepartmentDto> search(SearchDepartmentDto search){
		return repo.search(searchFun(search));
	}

	private Function<CriteriaBuilder,CriteriaQuery<SelectDepartmentDto>> searchFun(SearchDepartmentDto search) {
		return cb -> {
			var cq = cb.createQuery(SelectDepartmentDto.class);
			var root = cq.from(Department.class);
			
			SelectDepartmentDto.select(cb, cq, root);
			cq.where(search.search(cb, cq, root));
			
			return cq;
		};
	}
}
