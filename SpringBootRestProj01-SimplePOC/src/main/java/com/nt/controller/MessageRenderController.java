package com.nt.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@RestController   // (@Controller + ( @ResponseBody  on all the handler methods))
@Controller 
@RequestMapping("/message")   //Global path (purely optional)
public class MessageRenderController {
	
	
	
	@GetMapping("/generate")
	//@ResponseBody
	public  ResponseEntity<String>   generateMessage(){
		   //get Sys date and time
		   LocalDateTime ldt= LocalDateTime.now();
		    //get current hour of the day  (response body)
		   int hour=ldt.getHour();
		   String body=null;
		   if(hour<12)
			    body="Good Morning";
		   else if(hour<16)
			   body="Good AfterNoon";
		   else if(hour<20)
			   body="Good Evening";
		   else 
			   body="Good Night";
		   // response status
		  HttpStatus  status=HttpStatus.OK;
		  //create ResponseEntity object
		  ResponseEntity<String> entity=new ResponseEntity<String>(body, status);
		  return entity;
	}//method

}//class
