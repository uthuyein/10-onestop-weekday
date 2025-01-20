package com.jdc.mkt.model.output;

import com.jdc.mkt.model.entity.Salary.Position;

public record SelectSalaryDto(
		String employee,
		Double amount,
		Double bonus,
		Position position
		) {

	
}
