//ConstructorInjectionTest.java
package com.nt.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.nt.beans.WishMessageGenerator;

public class ConstructorInjectionTest {

	public static void main(String[] args) {
	   //Locate and hold spring bean cfg file
		FileSystemResource res=new FileSystemResource("src/com/nt/cfgs/applicationContext.xml");
		//create IOC container
		XmlBeanFactory factory=new XmlBeanFactory(res);
		//get TargetBean class object
		Object obj=factory.getBean("wmg");
		//type casting
		WishMessageGenerator generator=(WishMessageGenerator)obj;
		//invoke the b.method
		String result=generator.generateWishMesage("raja");
		System.out.println("Result ::"+result);  
		
	
	}
}
