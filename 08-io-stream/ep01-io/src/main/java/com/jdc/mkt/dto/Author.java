package com.jdc.mkt.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Author implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
}
