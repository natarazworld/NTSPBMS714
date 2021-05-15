package com.nt.beans;

import java.util.Date;

public class VoterVerifier {
	private  String name;
	private  float age;
	private  Date  verficationDate;
	
	public VoterVerifier() {
		System.out.println("VoterVerifier:: 0-param constructor");
	}
	
	//setter methods for setter Injection 
	public void setName(String name) {
		System.out.println("VoterVerifier.setName(-)");
		this.name = name;
	}
	public void setAge(float age) {
		System.out.println("VoterVerifier.setAge(-)");
		this.age = age;
	}
	
	//init life cycle method /custom init method
	public    void  myInit() {
		System.out.println("VoterVerifier.myInit() (custom init method)");
		 verficationDate=new Date();  // initializing   bean property that is not particpating Injections
		 //validation
		 if(name==null  || age<=0)
			 throw  new IllegalArgumentException("invalid  inputs are given for  name , age propeties");
	}
	
	public void  myDestroy() {
		System.out.println("VoterVerifier.myDestroy()");
		//nullifying bean properties
		name=null;
		age=0;
		verficationDate=null;
	}
	
	//b.method
	public   String  checkVotingElgibility() {
		if(age<18)
			return  "Mr/Miss/Mrs."+ name +"   u  r not elgible for voting  .. wait "+(18-age)+"  years to cast u r vote  on -->"+verficationDate ;
		else
			return  "Mr/Miss/Mrs."+ name +"   u  r   elgible for voting  .. Do not wait  on--> "+verficationDate;
			
	}

}
