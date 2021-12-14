package com.nt.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	private Integer cno;
	private String cname;
	private  Float  billAmt;
	private String[] favColors;
	private List<String> studies;
	private Set<Long> phoeNumbers;
	private  Map<String,Object> idDetails;
	//HAS- A property
	private  Company company;

}
