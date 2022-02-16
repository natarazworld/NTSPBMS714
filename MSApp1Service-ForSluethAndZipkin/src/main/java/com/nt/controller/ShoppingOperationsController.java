package com.nt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ShoppingOperationsController {
	@Autowired
	private  RestTemplate  template;
	Logger logger=LoggerFactory.getLogger(ShoppingOperationsController.class);
	
	@GetMapping("/shopping")
	public String Shopping() {
		logger.info("Welcome to shopping Module");
		//communicate with  BillingSErvice
		String  resp=template.getForObject("http://localhost:9092/billing", String.class);
		logger.info("Back to  shopping module::"+resp);
		return  "shopping is done"+resp;
	}

}
