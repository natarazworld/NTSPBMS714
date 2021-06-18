package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.model.Employee;

@SpringBootApplication
public class BootProj06InjectingValuesAllTypesOfSpringBeanPropertiesApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj06InjectingValuesAllTypesOfSpringBeanPropertiesApplication.class, args);
		//get SpringBean class obj
		Employee emp=ctx.getBean("emp",Employee.class);
		System.out.println(emp);
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
