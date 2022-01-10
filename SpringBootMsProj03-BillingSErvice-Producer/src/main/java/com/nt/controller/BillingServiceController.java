package com.nt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing")
public class BillingServiceController {
	 @Value("${server.port}")
	 private  int  port;
	 @Value("${eureka.instance.instance-id}")
	 private String  instanceId; 
	
	@GetMapping("/info")
	public  String   getBillingInfo() {
		return "we accept   Card Payment , UPI Payment,  NetBaking Payment, COD---> port::"+port+"----InstanceId::"+instanceId;
		
	}

}
