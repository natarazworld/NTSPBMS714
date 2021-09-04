package com.nt.model;

import lombok.Data;

@Data
public class Employee {
	private  Integer eno;
	private  String ename;
	private  String eadd="hyd";
	private  float esalary=9000.0f;
	
	public Employee() {
		System.out.println("Employee:: 0-param constructor");
	}

}
