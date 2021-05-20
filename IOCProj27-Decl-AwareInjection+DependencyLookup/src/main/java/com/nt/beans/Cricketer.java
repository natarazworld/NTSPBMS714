package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Cricketer implements ApplicationContextAware {
	 private String batId;
	 private ApplicationContext ctx;
	 
	 @Override
		public void setApplicationContext(ApplicationContext ctx) throws BeansException {
			System.out.println("Cricketer.setApplicationContext(-)");
			this.ctx=ctx;
		}
	 
	public Cricketer(String batId) {
		this.batId=batId;
		System.out.println("Cricketer:: 1-param constructor" +batId);
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
		//perform Dependency Lookup to get Dependent class object
		CricketBat bat=ctx.getBean(batId,CricketBat.class);
		//use Dependent class obj
		int runs=bat.scoreRuns();
		System.out.println("Crickesr is doing batting and his current score is :: "+runs);
	}

	
}
