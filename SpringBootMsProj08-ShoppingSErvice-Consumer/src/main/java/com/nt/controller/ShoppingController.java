package com.nt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.BillingServiceRestConsumer;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {
	@Autowired
	private BillingServiceRestConsumer consumer;
	
	 @Value("${server.port}")
	 private  int  port;
	 @Value("${eureka.instance.instance-id}")
	 private String  instanceId; 
	
	@GetMapping("/info")
	public  String   displayShoppingDetails() {
		return  "Pongal Shopping for Family ....using Ms "+instanceId+" running on port::"+port+"-----"+consumer.getBillingInfo();
		
	}
	

}
