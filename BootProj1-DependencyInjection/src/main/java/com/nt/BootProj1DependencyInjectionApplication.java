//BootProj1DependencyInjectionApplication.java
package com.nt;

import java.io.PrintStream;
import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.beans.WishMessageGenerator;

@SpringBootApplication
public class BootProj1DependencyInjectionApplication {
	
	@Bean(name="ldt")
	public   LocalDateTime   createLocalDateTime() {
		System.out.println("BootProj1DependencyInjectionApplication.createLocalDateTime()");
		LocalDateTime  ldt=LocalDateTime.now();
		return ldt;
	}

	public static void main(String[] args) {
		// get IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj1DependencyInjectionApplication.class, args);
		//get Taraget spring bean class from IOC container
		WishMessageGenerator generator=ctx.getBean("wmg",WishMessageGenerator.class);
		//invoke methods
		String result=generator.generateWishMessage("raja");
		System.out.println(result);
		//close  container
		((ConfigurableApplicationContext) ctx).close();
	}

}
