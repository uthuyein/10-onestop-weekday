package com.jdc.query.model.entity.dto;

import java.time.LocalDate;

public record SelectEmployee(
		String employee,
		LocalDate dob,
		String department
		) {

	
}
