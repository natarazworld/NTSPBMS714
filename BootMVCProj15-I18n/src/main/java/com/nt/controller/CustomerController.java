package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nt.model.Customer;

@Controller
public class CustomerController {
	
	@GetMapping("/")
	public  String showHome() {
		return "home";
	}
	
	@GetMapping("/customer_register")
	public  String  showCustomerFormPage(@ModelAttribute("customer") Customer cust) {
		return "customer_registration";
	}

}
