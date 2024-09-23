package com.jdc.mkt.collection;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Computer implements Comparable<Computer> {

	private Integer id;
	private String name;
	
	@Override
	public int compareTo(Computer c) {
		//return this.name.compareTo(c.name);
		return this.id > c.id == true ? -1: 1;
	}
}
