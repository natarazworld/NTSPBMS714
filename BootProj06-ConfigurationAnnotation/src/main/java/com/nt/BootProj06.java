package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.beans.CompanyDetails;
import com.nt.beans.CompanyDetails1;


@SpringBootApplication
public class BootProj06 {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj06.class, args);
		//get spring bean class objs
		CompanyDetails  company1=ctx.getBean("company",CompanyDetails.class);
		System.out.println(company1);
		System.out.println("------------------------------");
		CompanyDetails1  company2=ctx.getBean("company1",CompanyDetails1.class);
		System.out.println(company2);
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}//main
}//class
