package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class BootMvcProj18BeanNameViewResolverPdfExcelViewsApplication {
	
	@Bean
	public  BeanNameViewResolver  createViewResolver() {
		System.out.println("BootMvcProj18BeanNameViewResolverPdfExcelViewsApplication.createViewResolver()");
		 BeanNameViewResolver resolver=new BeanNameViewResolver();
		 resolver.setOrder(1);
		 return resolver;
	}
	
	@Bean
	public   InternalResourceViewResolver createIRVR() {
		System.out.println("BootMvcProj18BeanNameViewResolverPdfExcelViewsApplication.createIRVR()");
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(100);
		return resolver;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj18BeanNameViewResolverPdfExcelViewsApplication.class, args);
	}

}
