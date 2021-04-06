package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;
import com.nt.beans.Person;
import com.nt.beans.Person1;

public class DepedencyInjectionTest1 {

	public static void main(String[] args) {
          // create IOC container
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Spring bean class obj
		Person  p1=factory.getBean("per",Person.class);
		System.out.println(p1);
		System.out.println("=======================");
		//get Spring bean class obj
		Person1 p2=factory.getBean("per1",Person1.class);
		System.out.println(p2);

	}

}
