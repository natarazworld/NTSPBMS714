package com.nt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentOperationsController {
	Logger logger=LoggerFactory.getLogger(PaymentOperationsController.class);
	@GetMapping("/payment")
	public String doBilling() {
		logger.info("Welcome to payment Module");
		return  "payment is done";
	}

}
