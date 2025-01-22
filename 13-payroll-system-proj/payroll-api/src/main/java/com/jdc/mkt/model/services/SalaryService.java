package com.jdc.mkt.model.services;

import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.model.entity.Bonus;
import com.jdc.mkt.model.entity.Deduction;
import com.jdc.mkt.model.entity.Salary;
import com.jdc.mkt.model.input.SearchSalaryDto;
import com.jdc.mkt.model.output.SelectSalaryDto;
import com.jdc.mkt.model.repo.SalaryRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SalaryService {

	private final SalaryRepo repo;
	private final BonusService bonusService;
	private final DeductionService deductionService;
	
	@Transactional
	public void delete(int id) {
		var sal = repo.findById(id).orElseThrow(() -> new RuntimeException("No Salary ID Found"));
		repo.delete(sal);
	}
	
	
	@Transactional
	public Salary updateSalary(int id,Salary salary) {	
		var sal = repo.findById(id).orElseThrow(() -> new RuntimeException("No Salary ID Found"));
					
		sal.setBasicPay(salary.getBasicPay());
		sal.setNetSalary(salary.getNetSalary());
		sal.setPosition(salary.getPosition());
		sal.setAllowances(salary.getAllowances());
		
		updateBonus(sal.getBonuses());
		updateDeduction(sal.getDeductions());
	
		return repo.save(sal);
	}
	
	private void updateDeduction(List<Deduction> deductions) {
		if(null != deductions) {
            for(Deduction d : deductions) {
            	deductionService.update(d.getId(), d);
            }
		}
	}


	public void updateBonus(List<Bonus> list) {
		if (null != list) {
			for (Bonus b : list) {
				bonusService.update(b.getId(), b);
			}						
		}	
	}
	
	
	
	@Transactional
	public Salary save(Salary salary) {
		var bonuses = salary.getBonuses();
		var deductions = salary.getDeductions();
		salary.addBonus(bonuses);
		salary.addDeduction(deductions);
		return repo.save(salary);
	}
	
	public List<SelectSalaryDto> searchBy(SearchSalaryDto search){
		return repo.search(searchFun(search));
	}

	private Function<CriteriaBuilder,CriteriaQuery<SelectSalaryDto>> searchFun(SearchSalaryDto search) {
		return cb -> {
			var cq = cb.createQuery(SelectSalaryDto.class);
			var root = cq.from(Salary.class);
			
			SelectSalaryDto.select(cb, cq, root);
			
			cq.where(search.search(cb, cq, root));
			return cq;
		};
	}
}
