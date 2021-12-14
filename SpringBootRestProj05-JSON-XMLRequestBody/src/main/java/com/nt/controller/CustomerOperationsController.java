package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Customer;

@RestController
public class CustomerOperationsController {
	
	//@PostMapping("/register")
	@GetMapping("/register")
	public  String  registerCustomer(@RequestBody  Customer cust) {
		   return cust.toString();
	}

}
