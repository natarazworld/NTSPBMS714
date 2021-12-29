package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootRestProj15MvcConsumerAppForMiniProjectApplication {

	@Bean
	public  RestTemplate   createTemplate() {
		return new RestTemplate();
	}

	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestProj15MvcConsumerAppForMiniProjectApplication.class, args);
	}

}
