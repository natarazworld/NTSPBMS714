package com.nt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.BillingServiceRestConsumer;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {
	@Autowired
	private BillingServiceRestConsumer consumer;
	
	@GetMapping("/info")
	public  String   displayShoppingDetails() {
		return  "Pongal Shopping for Family ...."+consumer.getBillingInfo();
		
	}
	

}
