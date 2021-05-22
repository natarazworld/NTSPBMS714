package com.nt.test;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.beans.Cricketer;
import com.nt.config.AppConfig;

public class AwareInjectionAndlDependencyLookupTest {

	public static void main(String[] args) {
		//create IOC container
		 AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("========================");
		//get target spring bean class object
		Cricketer cricketer=ctx.getBean("cktr",Cricketer.class);
		System.out.println(cricketer.getClass()+" .....  "+cricketer.getClass().getSuperclass()+" ... "+Arrays.toString(cricketer.getClass().getDeclaredMethods()));
		System.out.println("............................");
		//invoke method b.methods
		cricketer.fielding();
		cricketer.bowling();
		cricketer.batting();
		
		//close container
		ctx.close();
	}

}
