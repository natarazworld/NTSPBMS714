package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Customer;
import com.nt.service.ICustomerMgmtService;

@Controller
public class CustomerController {
	@Autowired
	private  ICustomerMgmtService service;
	
	
	@GetMapping("/")
	public    String   showCustomerFormPage(@ModelAttribute("cust")Customer customer) {
		return "customer_register";
	}
	
	@PostMapping("/customer_register")
	public  String  registerCustomer(Map<String,Object> map,
			                                                      @ModelAttribute("cust") Customer cust) {
		//return  LVN
		return "show_result";
		
	}
	
	@PostMapping("/states")
	public String  showStatesByCountry(@RequestParam("country") String country,
			                                                                @ModelAttribute("cust") Customer cust,Map<String,Object> map) {
		//use service
		List<String> statesList=service.getStatesByCountry(country);
		//add to model Attribute
		map.put("statesInfo",statesList);
		//return LVN
		return "customer_register";
		
	}
	
	
	@ModelAttribute("countriesInfo")
	public  Set<String>  populateCountries(){
		return service.getAllCountries();
	}
	
	@ModelAttribute("languagesInfo")
	public  Set<String>  populateLanguages(){
		return service.getAllLanguages();
	}
	
	@ModelAttribute("hobbiesInfo")
	public  Set<String> populateHobbies(){
		return service.getAllHobbies();
	}

}
