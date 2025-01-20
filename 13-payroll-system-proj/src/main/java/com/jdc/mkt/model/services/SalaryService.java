package com.jdc.mkt.model.services;

import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.model.entity.Salary;
import com.jdc.mkt.model.input.SearchSalaryDto;
import com.jdc.mkt.model.output.SelectSalaryDto;
import com.jdc.mkt.model.repo.SalaryRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SalaryService {

	private final SalaryRepo repo;
	
	public List<SelectSalaryDto> searchBy(SearchSalaryDto search){
		return repo.search(searchFun(search));
	}

	private Function<CriteriaBuilder,CriteriaQuery<SelectSalaryDto>> searchFun(SearchSalaryDto search) {
		return cb -> {
			var cq = cb.createQuery(SelectSalaryDto.class);
			var root = cq.from(Salary.class);
			cq.where(search.search(cb, cq, root));
			return cq;
		};
	}
}
