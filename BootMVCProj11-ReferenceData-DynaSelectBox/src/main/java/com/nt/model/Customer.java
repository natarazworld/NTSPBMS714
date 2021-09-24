package com.nt.model;

import lombok.Data;

@Data
public class Customer {
	private Integer cno; 
	private String cname;
	private  String country="";
	private String languages[]=new String[] {"Hindi","English"};
	private String hb[]=new String[] {"Swimming","Workout"};
	private String state;
	

}
