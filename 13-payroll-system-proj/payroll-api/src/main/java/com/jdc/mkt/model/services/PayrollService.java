package com.jdc.mkt.model.services;

import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.model.entity.Payroll;
import com.jdc.mkt.model.entity.PayrollPk;
import com.jdc.mkt.model.entity.Payroll_;
import com.jdc.mkt.model.input.SearchPayrollDto;
import com.jdc.mkt.model.output.SelectPayrollDto;
import com.jdc.mkt.model.repo.PayrollRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PayrollService {

	private final PayrollRepo repo;
	
	public Payroll save(Payroll payroll) {
		return repo.save(payroll);
	}
	
	public Payroll update(Payroll payroll) {
		var pay = repo.findById(payroll.getId()).orElseThrow(() -> new RuntimeException("There is no payroll for that id"));
		pay.setEmployee(null != payroll.getEmployee() ? payroll.getEmployee() : pay.getEmployee());
		pay.setLeave(null != payroll.getLeave() ? payroll.getLeave() : pay.getLeave());
		pay.setSalary(null != payroll.getSalary() ? payroll.getSalary() : pay.getSalary());
		pay.setTotalAmount(null != payroll.getTotalAmount() ? payroll.getTotalAmount() : pay.getTotalAmount());
		return repo.save(pay);
	}
	
	public void delete(PayrollPk id) {
		repo.deleteById(id);
	}
		
	public List<SelectPayrollDto> search(SearchPayrollDto search){
		return repo.search(searchFun(search));
	}

	private Function<CriteriaBuilder,CriteriaQuery<SelectPayrollDto>> searchFun(SearchPayrollDto search) {		
		return cb -> {
			var cq = cb.createQuery(SelectPayrollDto.class);
			var root = cq.from(Payroll.class);
			var join = root.join(Payroll_.employee);
			
			SelectPayrollDto.select(cb, cq, root, join);
			
			cq.where(search.search(cb, cq, root, join));
			
			return cq;
		};
	}
}
