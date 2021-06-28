package com.nt;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class BootProj13RunnersApplication {
	
	@Bean
	@Order(-20)
	public  CommandLineRunner  createRunner1() {
		CommandLineRunner clr=(String  ...crargs)->{
			System.out.println("Scheduling Runner");
		};
	  return clr;
	}
	@Bean
	@Order(50)
	public  ApplicationRunner  createRunner2() {
	   ApplicationRunner ar=(ApplicationArguments aars)->{
		System.out.println("Timer Runner");
	   };
	   return ar;
	}

	public static void main(String[] args) {
		SpringApplication.run(BootProj13RunnersApplication.class, args);
	}

}
