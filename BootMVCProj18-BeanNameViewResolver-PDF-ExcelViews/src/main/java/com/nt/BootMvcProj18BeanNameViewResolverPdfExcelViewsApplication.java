package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.nt.view.EmployeePdfView;

@SpringBootApplication
public class BootMvcProj18BeanNameViewResolverPdfExcelViewsApplication {
	
	@Bean
	public  BeanNameViewResolver  createViewResolver() {
		System.out.println("BootMvcProj18BeanNameViewResolverPdfExcelViewsApplication.createViewResolver()");
		 BeanNameViewResolver resolver=new BeanNameViewResolver();
		 resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
		 
		 return resolver;
	}
	
	/*@Bean
	public   InternalResourceViewResolver createIRVR() {
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(10);
		return  resolver;
	}*/
	
	
	
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj18BeanNameViewResolverPdfExcelViewsApplication.class, args);
	}

}
