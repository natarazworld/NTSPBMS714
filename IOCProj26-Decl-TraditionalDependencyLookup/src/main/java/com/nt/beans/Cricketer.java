package com.nt.beans;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Cricketer {
	 private String batId;
	public Cricketer(String batId) {
		this.batId=batId;
		System.out.println("Cricketer:: 1-param constructor");
	}
	
	public  void  fielding() {
		System.out.println("Cricketer is doing fielding ");
	}
	
	public  void  bowling() {
		System.out.println("Cricketer is doing bolwing ");
	}
	
	public  void  wicketKeeping() {
		System.out.println("Cricketer is doing wicketkeeping ");
	}
	
	public  void batting() {
		System.out.println("Cricketer.batting()");
		//create an extra IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		 System.out.println("Cricketer:: 2nd IOC container creation");
		//perform Dependency Lookup to get Dependent class object
		CricketBat bat=ctx.getBean(batId,CricketBat.class);
		//use Dependent class obj
		int runs=bat.scoreRuns();
		System.out.println("Crickesr is doing batting and his current score is :: "+runs);
	}
}
