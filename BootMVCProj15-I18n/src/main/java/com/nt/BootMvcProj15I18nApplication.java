package com.nt;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class BootMvcProj15I18nApplication {

	@Bean("messageSource")  //fixed bean id
	public  ResourceBundleMessageSource  createRBMS() {
		 ResourceBundleMessageSource source=new ResourceBundleMessageSource();
		 source.setBasename("com/nt/commons/App");
		 return source;
	}
	
	@Bean("localeResolver") //fixed bean id
	public SessionLocaleResolver  createSLResolver() {
		 SessionLocaleResolver resolver=new SessionLocaleResolver();
		 resolver.setDefaultLocale(Locale.ENGLISH);
		 return resolver;
	}
	
	@Bean("lci") // not a fixed bean id
	public  LocaleChangeInterceptor createLCInterceptor() {
		LocaleChangeInterceptor interceptor=new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj15I18nApplication.class, args);
	}

}
