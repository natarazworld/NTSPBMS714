package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms  //optional
public class BootJmsProj1RecieverAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootJmsProj1RecieverAppApplication.class, args);
	}

}
