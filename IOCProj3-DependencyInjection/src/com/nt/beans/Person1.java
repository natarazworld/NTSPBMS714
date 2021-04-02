package com.nt.beans;

public class Person1 {
   //spring bean properties
	private  int pid;
   private  String pname;
   private  String paddrs;
   private  float  income;
   
   //ctrl+shift+s ,o
 public Person1(int pid, String pname, String paddrs, float income) {
	System.out.println("Person1:: 4-param/arg constructor");
	this.pid = pid;
	this.pname = pname;
	this.paddrs = paddrs;
	this.income = income;
}


//alt+shift+s,s 
@Override
public String toString() {
	return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + ", income=" + income + "]";
}


   
   
   
}
