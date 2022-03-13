package com.nt.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
@RequestMapping("/train")
public class TrainSeatsController {
	
	@GetMapping("/seat")
	@CircuitBreaker(name="cb1",fallbackMethod = "dummyBookTicket")
	public  String   getSeats() {
		System.out.println("TrainSeatsController.getSeats()");
		  try {
			  Thread.sleep(3000);
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  return "seat found and allocated";
		    
	}
	
	
}
