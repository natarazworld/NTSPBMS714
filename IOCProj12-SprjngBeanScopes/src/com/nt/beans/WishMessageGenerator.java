//WishMessageGenerator.java
package com.nt.beans;

import java.util.Date;

public class WishMessageGenerator {
   private  Date date;  //ctrl +shift+o :: To import pkg

   public WishMessageGenerator() {
	System.out.println("WishMessageGenerator:: 0-param consturctor");
}
   
   //alt+shift+s,r --> selet setters :: To get setter method 
public void setDate(Date date) {
	System.out.println("WishMessageGenerator.setDate(-)");
	this.date = date;
}
   
   // b.mehtod
  public String  generateWishMesage(String user) {
	  System.out.println("WishMessageGenerator.generateWishMesage()");
	  //get current hour of the day
	  int hour=date.getHours();  // 24 hrs format
	  if(hour<12)
		  return "GM::"+user;
	  else if(hour<16)
		  return "GA::"+user;
	  else if(hour<20)
		  return "GE::"+user;
	  else 
		  return "GN::"+user;
  }
   
}
