package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringBootMsProj06ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMsProj06ConfigServerApplication.class, args);
	}

}
