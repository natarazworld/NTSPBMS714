package com.nt.model;

import lombok.Data;

@Data
public class Employee {
	private  int eno;
	private  String ename;
	private  String eadd="hyd";
	private  float salary;
	
	public Employee() {
		System.out.println("Employee:: 0-param constructor");
	}

}
