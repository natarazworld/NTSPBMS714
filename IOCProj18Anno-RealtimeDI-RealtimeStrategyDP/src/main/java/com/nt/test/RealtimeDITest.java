package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.MainController;
import com.nt.vo.CustomerVO;

public class RealtimeDITest {

	public static void main(String[] args) {
		//Read inputs from enduser as string values
		Scanner sc=new Scanner(System.in);
		System.out.println("enter customer name::");
		String name=sc.next();
		System.out.println("enter customer addrs::");
		String addrs=sc.next();
		System.out.println("enter customer Principle amount::");
		String pAmt=sc.next();
		System.out.println("enter customer Rate of  intrest::");
		String rate=sc.next();
		System.out.println("enter  Time (In Months)::");
		String time=sc.next();
		
		//create CustomerVO clas obj
		CustomerVO vo=new CustomerVO();
		vo.setCustName(name);vo.setCustAddrs(addrs); vo.setPamt(pAmt);
		vo.setRate(rate); vo.setTime(time);
		//create IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		 //get Controller class obj 
		 MainController controller=ctx.getBean("controller",MainController.class);
		 //invoke the methods
		 try {
			 String result=controller.processCustomer(vo);
			 System.out.println(result);
		 }
		 catch(Exception e) {
			 //e.printStackTrace();
			 System.out.println("Internal Problem --Try Again:::"+e.getMessage());
		 }
	}
}
