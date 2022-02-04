package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootJmsProj1ProducerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootJmsProj1ProducerAppApplication.class, args);
	}

}
