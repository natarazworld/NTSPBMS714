package com.nt.comp;

import java.util.Arrays;
import java.util.Random;

public final class Flipkart {
	private  Courier courier;
	
	public Flipkart() {
		System.out.println("Flipkart:: 0-param constructor");
	}
	
	public void setCourier(Courier courier) {
		System.out.println("Flipkart.setCourier(-)");
		 this.courier=courier;
	}
	
	//b,method
	public  String  shopping(String [] items, float[] prices) {
		float billAmt=0.0f;
		for(float p:prices)
			billAmt+=p;  // billAmt=billAmt+p
		//generate order id
		  int oid=new Random().nextInt(1000);
		  //use courier
		  String msg=courier.deliver(oid);
		  return  Arrays.toString(items)+" with prices"+Arrays.toString(prices)+" having billamt"+billAmt +" :::: "+ msg;
	}
	

}
