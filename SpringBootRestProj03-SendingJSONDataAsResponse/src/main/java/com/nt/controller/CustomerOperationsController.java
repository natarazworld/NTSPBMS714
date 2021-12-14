package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Customer;

@RestController
public class CustomerOperationsController {
	
	/*@GetMapping("/report")
	public ResponseEntity<Customer>  showData(){
		  Customer cust=new Customer(1001,"raja",54566.66f);
		  HttpStatus status=HttpStatus.OK;
		  return  new ResponseEntity<Customer>(cust,status);
	}*/
	
	@GetMapping("/report1")
	public ResponseEntity<Customer>  showData1(){
		//body
		  Customer cust=new Customer(1001,"raja",54566.66f,
				                                                       new String[] {"read","green","blue"},
				                                                       List.of("10th","10+2","B.Tech"),
				                                                       Set.of(544535345L,7576575L,6465654L),
				                                                       Map.of("aadhar", 35345435L, "panNo", 354353534L),
				                                                       new Company("SAMSUNG","hyd","Eletronics",4000));
				//status                                                       
		  HttpStatus status=HttpStatus.OK;
		  return  new ResponseEntity<Customer>(cust,status);
	}

}
