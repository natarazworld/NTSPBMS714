package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Bank;

public class MethodReplacerTest {

	public static void main(String[] args) {
		//create IOC container
		ClassPathXmlApplicationContext  ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean class object
		Bank bank=ctx.getBean("bank",Bank.class);
		System.out.println(bank.getClass()+"      "+bank.getClass().getSuperclass());
		//invoke method
		 System.out.println("Intrest amount::"+bank.calculateIntrestAmount(100000,2, 12));
		
		 //close container
		 ctx.close();
		

	}

}
