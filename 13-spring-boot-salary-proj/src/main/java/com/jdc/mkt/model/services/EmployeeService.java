package com.jdc.mkt.model.services;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.mkt.model.entity.Employee;
import com.jdc.mkt.model.input.SearchEmployeeDto;
import com.jdc.mkt.model.output.SelectEmployeeDto;
import com.jdc.mkt.model.repo.EmployeeRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo repo;

	int saveEmployee(Employee e) {
		return 0;
	}
	
	int updateEmployee(Employee e) {
		return 0;
	}
	
	public List<SelectEmployeeDto> search(SearchEmployeeDto search){
		return repo.search(searchFun(search));
	}

	private Function<CriteriaBuilder,CriteriaQuery<SelectEmployeeDto>> searchFun(SearchEmployeeDto search) {
		Function<CriteriaBuilder,CriteriaQuery<SelectEmployeeDto>> fun = cb -> {
			var cq = cb.createQuery(SelectEmployeeDto.class);
			var root = cq.from(Employee.class);
			
			SelectEmployeeDto.select(cq, root);
			
			cq.where(search.search(cb, cq, root));
			
			return cq;
		};
		return fun;
	}
}
