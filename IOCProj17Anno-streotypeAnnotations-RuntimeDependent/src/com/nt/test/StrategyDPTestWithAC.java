package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.comp.Flipkart;

public class StrategyDPTestWithAC {

	public static void main(String[] args) {
		//create IOC container
				ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
				//get Target class object
				Flipkart fpkt=ctx.getBean("fpkt",Flipkart.class);
				//invoke the b.method
				String result=fpkt.shopping(new String[] {"mangoes","tamarind","sugar canes"},
						                                                 new float[] {900.0f,300.0f, 100.0f }    );
				System.out.println(result);  

	}

}
