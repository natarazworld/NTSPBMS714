//WishMessageGenerator.java (target class)
package com.nt.beans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	@Autowired  // Field injection
	private LocalDateTime date;
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator:: 0-param constructor");
	}
	
	//b.method
	public  String generateWishMessage(String user) {
		System.out.println("WishMessageGenerator.generateWishMessage(-)");
		//get current hour of the day
		int hour=date.getHour(); //gives 24 hrs format  (0 to 23)
		//generate wish Mesage
		 if(hour<12)
			 return "GOOD MORNING::"+user;
		 else if(hour<16)
			 return "GOOD AfterNoon::"+user;
		 else if(hour<20)
			 return "GOOD Evening::"+user;
		 else
			 return "GOOD Night::"+user;
	}
	

}
