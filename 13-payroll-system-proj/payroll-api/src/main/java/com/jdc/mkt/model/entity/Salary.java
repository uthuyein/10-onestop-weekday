package com.jdc.mkt.model.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "salary_tbl")
public class Salary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Double basicPay;
	private Double allowances;
	
	private Double netSalary;
	
	@OneToMany(
			mappedBy = "salary",
			cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE},
			orphanRemoval = true)
	private List<Deduction>  deductions = new ArrayList<Deduction>();
	
	@OneToMany(
			mappedBy = "salary",
			cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE},
			orphanRemoval = true)
	private List<Bonus> bonuses = new ArrayList<Bonus>();
	
	@Enumerated(EnumType.STRING)
	private Position position;
	
	public enum Position{
		Casual,Permanent,Senior,Manager
	}
	
	public void addBonus(List<Bonus> bonusList) {
		for (Bonus bonus : bonusList) {
			bonus.setSalary(this);		
		}
		bonuses.addAll(bonusList);
	}

	public void addDeduction(List<Deduction> deductionList) {
		for (Deduction deduction : deductionList) {
			deduction.setSalary(this);
		}
		deductions.addAll(deductionList);
	}
	
	@Override
	public String toString() {
        return position.name();
    }
}
