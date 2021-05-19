package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt")
@PropertySource(value="com/nt/commons/jdbc.properties")
@ImportResource(locations = "com/nt/cfgs/applicationContext.xml")
public class AppConfig {
	@Autowired
	 private Environment env;
	
	
	@Bean(name="drds")
   public   DriverManagerDataSource   createDsForOracle() {
	     DriverManagerDataSource  drds=new DriverManagerDataSource();
	     //note: since  these   java method call statements , we can not use @Value with ${...}
	     drds.setDriverClassName(env.getRequiredProperty("jdbc.driver"));   // key is pass as agrument
	     drds.setUrl(env.getRequiredProperty("jdbc.url"));
	     drds.setUsername(env.getProperty("db.user"));
	     drds.setPassword(env.getProperty("db.pwd"));
	     return drds;
   }
	
	

}
