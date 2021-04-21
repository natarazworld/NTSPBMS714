//SetterInjectionTest.java
package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.Printer;
import com.nt.beans.WishMessageGenerator;

public class SetterInjectionTest {

	public static void main(String[] args) {
		//create IOC container
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
				//get Target Bean class obj ref
				WishMessageGenerator generator1=factory.getBean("wmg",WishMessageGenerator.class);
				WishMessageGenerator generator2=factory.getBean("wmg",WishMessageGenerator.class);
				System.out.println(generator1.hashCode()+"   "+generator2.hashCode());
				System.out.println("generator1==generator2?"+(generator1==generator2));
				
		
				/*   System.out.println("=======================================");
				  Printer p1=factory.getBean("p1",Printer.class);
				  Printer p11=factory.getBean("p1",Printer.class);
				  System.out.println(p1.hashCode()+"  "+p11.hashCode());
				     System.out.println("-------------------------------------");
				     Printer p2=factory.getBean("p2",Printer.class);
				     Printer p22=factory.getBean("p2",Printer.class);
				     System.out.println(p2.hashCode()+"  "+p22.hashCode());*/
		
	}//main
}//class
