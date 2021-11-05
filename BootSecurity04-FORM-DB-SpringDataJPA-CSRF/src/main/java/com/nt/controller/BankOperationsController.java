package com.nt.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class BankOperationsController {
	
	  @GetMapping("/")
	  public  String   showHome() {
		    return "home";
	  }
	  
	  @GetMapping("/offers")
	  public  String  showOffers() {
		    return "offers";
	  }
	  
	  @PostMapping("/balance")
	  public  String  checkBalnace(Map<String,Object > map) {
		  map.put("balance_amt",new Random().nextInt(1000000));
		     return "show_balance";
	  }
	  
	  @GetMapping("/loanApprove")
	  public  String approveLoan(Map<String,Object> map) {
		  map.put("amount",new Random().nextInt(1000000));
		  return "loan";
	  }
	  
	  @GetMapping("/denied")
	  public  String accessDenied(Map<String,Object> map) {
		  map.put("username", SecurityContextHolder.getContext().getAuthentication().getName());
		  return "access_denied";
	  }
	  
	


	  
	  

}
