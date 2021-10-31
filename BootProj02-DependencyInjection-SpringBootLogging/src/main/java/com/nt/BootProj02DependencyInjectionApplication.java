package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.beans.Student;

@SpringBootApplication
@ImportResource("com/nt/cfgs/applicationContext.xml")
public class BootProj02DependencyInjectionApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj02DependencyInjectionApplication.class, args);
		//get Target Spring bean class object 
		 Student  st=ctx.getBean("stud",Student.class);
		 //invoke b.method
		 st.preparation("CTS-Interview");
		 //close container
		 ((ConfigurableApplicationContext) ctx).close();
	}//main
}//class
