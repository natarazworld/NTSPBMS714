package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class PersistenceConfig {
	@Autowired
	private   Environment  env;
	
	@Bean(name="c3P0Ds")
	public  ComboPooledDataSource   createDS() throws Exception{
		System.out.println("PersistenceConfig.createDS()");
		 ComboPooledDataSource  c3PODs=new ComboPooledDataSource();
		 c3PODs.setDriverClass(env.getProperty("spring.datasource.driver-class-name"));
		 c3PODs.setJdbcUrl(env.getProperty("spring.datasource.url"));
		 c3PODs.setUser(env.getProperty("spring.datasource.username"));
		 c3PODs.setPassword(env.getProperty("spring.datasource.password"));
		 return c3PODs;
	}

}
