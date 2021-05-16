package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.VoterVerifier;

public class SpringBeanLifeCycleTest {

	public static void main(String[] args) {
		// IOC container
		ClassPathXmlApplicationContext ctx=new  ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get  Spring bean object
		VoterVerifier  voter=ctx.getBean("voter",VoterVerifier.class);
		//invoke method
		try {
			System.out.println(voter.checkVotingElgibility());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close contianer
		ctx.close();

	}

}
