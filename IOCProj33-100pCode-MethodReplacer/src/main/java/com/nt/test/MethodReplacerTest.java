package com.nt.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Bank;
import com.nt.config.AppConfig;

public class MethodReplacerTest {

	public static void main(String[] args) {
		//create IOC container
	   AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get Bean class object
		Bank bank=ctx.getBean("bank",Bank.class);
		System.out.println(bank.getClass()+"      "+bank.getClass().getSuperclass());
		//invoke method
		 System.out.println("Intrest amount::"+bank.calculateIntrestAmount(100000,2, 12));
		
		 //close container
		 ctx.close();
		

	}

}
