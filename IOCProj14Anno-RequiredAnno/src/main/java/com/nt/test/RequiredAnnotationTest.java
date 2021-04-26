package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Robot;

public class RequiredAnnotationTest {

	public static void main(String[] args) {
		//create IOC container 
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		Robot robot1=ctx.getBean("robot",Robot.class);
		System.out.println(robot1);


	} //main
}//class
