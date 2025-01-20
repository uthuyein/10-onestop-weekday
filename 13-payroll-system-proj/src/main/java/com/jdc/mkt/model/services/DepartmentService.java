package com.jdc.mkt.model.services;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.mkt.model.entity.Department;
import com.jdc.mkt.model.input.SearchDepartmentDto;
import com.jdc.mkt.model.output.SelectDepartmentDto;
import com.jdc.mkt.model.repo.DepartmentRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepo repo;
	
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
