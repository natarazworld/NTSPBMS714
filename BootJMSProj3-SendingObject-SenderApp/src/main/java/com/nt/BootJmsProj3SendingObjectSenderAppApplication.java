package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJms
public class BootJmsProj3SendingObjectSenderAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootJmsProj3SendingObjectSenderAppApplication.class, args);
	}

}
