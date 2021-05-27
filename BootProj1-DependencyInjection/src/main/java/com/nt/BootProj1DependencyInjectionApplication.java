//BootProj1DependencyInjectionApplication.java
package com.nt;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class BootProj1DependencyInjectionApplication {
	
	@Bean
	@Scope("prototype")
	public   LocalDateTime   createLocalDateTime() {
		System.out.println("BootProj1DependencyInjectionApplication.createLocalDateTime()");
		LocalDateTime  ldt=LocalDateTime.now();
		return ldt;
	}
	
	@Bean(name="ldt1")
	@Scope("prototype")
	public   LocalDateTime   createLocalDateTime1() {
		System.out.println("BootProj1DependencyInjectionApplication.createLocalDateTime1()");
		LocalDateTime  ldt=LocalDateTime.now();
		return ldt;
	}


	public static void main(String[] args) {
		// get IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj1DependencyInjectionApplication.class, args);
		BootProj1DependencyInjectionApplication  bean=ctx.getBean("bootProj1DependencyInjectionApplication",BootProj1DependencyInjectionApplication.class);
		System.out.println(bean.getClass()+"   "+bean.hashCode());
		System.out.println("========================================");
		LocalDateTime  ldt=ctx.getBean("createLocalDateTime",LocalDateTime.class);
		System.out.println(ldt.getClass()+"  "+ldt.hashCode());
		
		System.out.println("all bean ids "+Arrays.toString(ctx.getBeanDefinitionNames()));
		System.out.println("beans count::"+ctx.getBeanDefinitionCount());
		
		//get Taraget spring bean class from IOC container
	/*	WishMessageGenerator generator=ctx.getBean("wmg",WishMessageGenerator.class);
		//invoke methods
		String result=generator.generateWishMessage("raja");
		System.out.println(result);
		System.out.println("=================");
		WishMessageGenerator generator1=ctx.getBean("wmg",WishMessageGenerator.class);
		System.out.println(generator.hashCode()+"   "+generator1.hashCode());
		//close  container
		((ConfigurableApplicationContext) ctx).close(); */
	}

}
