//ConstructorInjectionTest.java
package com.nt.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.nt.beans.A;

public class CyclicInjectionTest {

	public static void main(String[] args) {
	   //Locate and hold spring bean cfg file
		FileSystemResource res=new FileSystemResource("src/com/nt/cfgs/applicationContext.xml");
		//create IOC container
		XmlBeanFactory factory=new XmlBeanFactory(res);
		//get Bean class object
		A  a=(A)factory.getBean("a1");
		System.out.println(a);
		
	
	}
}
