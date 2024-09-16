package com.jdc.mkt.dto;

import java.io.Serializable;

import lombok.Data;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor
//@EqualsAndHashCode
@Data
public class Book implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private  String name;
	private String description;
	private transient double price;
	private Author author;
}
