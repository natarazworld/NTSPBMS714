//OracleDBConfig.java
package com.nt.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.nt.repo.prod",
                                                      entityManagerFactoryRef = "oracleEMF",
                                                      transactionManagerRef = "oracleTxMgmr")
public class OracleDBConfig {
	
	
	@Bean
	@ConfigurationProperties(prefix = "oracle.datasource")
	@Primary
	public  DataSource  createOracleDs() {
	   return  DataSourceBuilder.create().build();		
	}
	
	@Bean(name="oracleEMF")
	@Primary
	public  LocalContainerEntityManagerFactoryBean 
	                            createOracleEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
		        //create Map object having  hibernate properties
		        Map<String,Object> props=new HashMap();
		        props.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		        props.put("hibernate.hbm2ddl.auto", "update");
		        //create and return LocalContainerEntityManagerFactoryBean class obj which makes
		         //EntityManagerFactory  as the sprign bean
		       return  builder.dataSource(createOracleDs())  // datasoruce 
		    		   .packages("com.nt.model.prod")   //model class pkg
		    		   .properties(props)  //hibernate properties 
		    		   .build();
	}
	
	@Bean(name="oracleTxMgmr")
	@Primary
	public  PlatformTransactionManager
	          createOracleTxMgmr(@Qualifier("oracleEMF")
	                                                                EntityManagerFactory  factory) {
		return  new JpaTransactionManager(factory);
	}

}
