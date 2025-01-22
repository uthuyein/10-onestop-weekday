package com.jdc.mkt.model.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.model.entity.Deduction;
import com.jdc.mkt.model.repo.DeductionRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DeductionService {
	
	private final DeductionRepo repo;
	
	@Transactional
	public Deduction save(Deduction d) {
		return repo.save(d);
	}
	
	@Transactional
	public void delete(int id) {
		var ded = repo.findById(id).orElseThrow(() -> new RuntimeException("No Deduction ID Found"));
		repo.delete(ded);
	}

	@Transactional
	public void update(int id, Deduction d) {
		var ded = repo.findById(id).orElseThrow(() -> new RuntimeException("No Deduction ID Found"));
		
		ded.setInsurance(null != d.getInsurance()? d.getInsurance():ded.getInsurance());
		ded.setTax(null != d.getTax()? d.getTax():ded.getTax());
		ded.setLoanRepayment(null != d.getLoanRepayment()? d.getLoanRepayment():ded.getLoanRepayment());
		ded.setOtherDeductions(null != d.getOtherDeductions()? d.getOtherDeductions():ded.getOtherDeductions());
		
		repo.save(ded);
	}

}
