//AppConfig.java (Configuration class)
package com.nt.config;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.nt.beans")  //alternate to <context:component-scan />
public class AppConfig {
	
	public AppConfig() {
		System.out.println("AppConfig:: 0-param constructor");
	}
	
	@Bean(name="ldt")
	//@Scope("prototype")
	public    LocalDateTime  createLocalDateTime() {
		System.out.println("AppConfig.createLocalDateTime() (@Bean method)");
		LocalDateTime  ldt=LocalDateTime.now();  //gives system date and time
		  return ldt;
	}
	

}
