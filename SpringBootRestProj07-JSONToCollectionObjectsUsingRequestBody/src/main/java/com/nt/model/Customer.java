package com.nt.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Customer {
	private  Integer cno;
	private String cname;
	private List<Company> companiesList;
	@JsonFormat(pattern="yyyy-MM-dd")
	private  LocalDate   dob;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime  purchaseDate;
	private  List<Map<String,Long>>  familyIds;
	

}
