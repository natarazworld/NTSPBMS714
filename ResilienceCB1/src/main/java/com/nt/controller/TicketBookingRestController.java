package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
//@RequestMapping("/ticket")
public class TicketBookingRestController {
	
	
	@GetMapping("/book")
	@CircuitBreaker(name="cb1",  fallbackMethod = "dummyBookTicket")
	public  String   bookTicket() {
		System.out.println("TicketBookingRestController.bookTicket()");
		RestTemplate template=new RestTemplate();
		 String  msg=template.getForObject("http://localhost:9902/train/seat", String.class);
		  return msg+"--> from Ticking booking";
		    
	}
	
	public  String dummyBookTicket(Exception e) {
		System.out.println("TicketBookingRestController.dummyBookTicket()::"+e.toString());
		return "Place Try later -- Inconvience is regratted";
	}

}
