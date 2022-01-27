package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class BootMsProj08HystrixCircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj08HystrixCircuitBreakerApplication.class, args);
	}

}
