package com.nt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cust")
public class CustomerOperationsController {
	
	@Value("${dbuser}")
	private  String  user;
	@Value("${dbpwd}")
	private String pass;
	
	
	@GetMapping("/display")
	public  String   displayData() {
		  return  "(Customer)Data Collected throgh Config Server ::"+user+"----"+pass;
	}
	
	

}
