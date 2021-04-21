package com.nt.beans;

public class Printer {
    //static reference variable
	private  static  Printer  INSTANCE;  // -2
	//private constructor --1 
	private Printer() {
		System.out.println("Printer:: 0-param constructor");
	}
	
	// public static factory method -3
	public static  Printer  getInstance() {
		   if(INSTANCE==null)
			    INSTANCE=new Printer();
		   return INSTANCE;
	}
	
	//b.method
	public void print(String msg) {
		  System.out.println(msg);
	}
}//class
