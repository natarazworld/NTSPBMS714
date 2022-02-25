package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class SpringBootMsProj08ZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMsProj08ZuulServerApplication.class, args);
	}

}
