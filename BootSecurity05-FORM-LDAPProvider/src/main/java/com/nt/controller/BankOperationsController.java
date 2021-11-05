package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankOperationsController {
	
	  @GetMapping("/")
	  public  String   showHome() {
		    return "home";
	  }
	  
	  @GetMapping("/offers")
	  public  String  showOffers() {
		    return "offers";
	  }
	  
	  @GetMapping("/balance")
	  public  String  checkBalnace() {
		     return "show_balance";
	  }
	  
	  @GetMapping("/loanApprove")
	  public  String approveLoan() {
		  return "loan";
	  }
	  
	  @GetMapping("/denied")
	  public  String accessDenied() {
		  return "access_denied";
	  }
	  
	


	  
	  

}
