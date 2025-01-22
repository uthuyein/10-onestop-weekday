package com.jdc.mkt.model.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.model.entity.Bonus;
import com.jdc.mkt.model.repo.BonusRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BonusService {

	private final BonusRepo repo;

	@Transactional
	public Bonus save(Bonus bonus) {
		return repo.save(bonus);
	}

	@Transactional
	public Bonus update(int id, Bonus bonus) {
		Bonus b = repo.findById(id).get();
		b.setAmount(null != bonus.getAmount()? bonus.getAmount():b.getAmount());
		b.setDateAward(null != bonus.getDateAward()? bonus.getDateAward():b.getDateAward());
		b.setName(null != bonus.getName()? bonus.getName():b.getName());

		return repo.save(bonus);
	}

	public void delete(int id) {
		repo.deleteById(id);
	}

}
