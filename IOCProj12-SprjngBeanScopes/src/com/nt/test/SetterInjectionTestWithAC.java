//SetterInjectionTest.java
package com.nt.test;

import java.util.Arrays;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Printer;
import com.nt.beans.WishMessageGenerator;

public class SetterInjectionTestWithAC {

	public static void main(String[] args) {
		//create IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		/*	//get Target Bean class obj ref
			WishMessageGenerator generator1=factory.getBean("wmg",WishMessageGenerator.class);
			WishMessageGenerator generator2=factory.getBean("wmg",WishMessageGenerator.class);
			System.out.println(generator1.hashCode()+"   "+generator2.hashCode());
			System.out.println("generator1==generator2?"+(generator1==generator2));
			
		
			   System.out.println("=======================================");
			  Printer p1=factory.getBean("p1",Printer.class);
			  Printer p11=factory.getBean("p1",Printer.class);
			  System.out.println(p1.hashCode()+"  "+p11.hashCode()); 
			  
			  System.out.println(" beans count::"+factory.getBeanDefinitionCount());
			  System.out.println("all bean ids "+Arrays.toString(factory.getBeanDefinitionNames()));*/
				 
		
	}//main
}//class
