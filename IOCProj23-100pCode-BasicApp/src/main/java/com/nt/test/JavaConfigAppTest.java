//JavaConfigAppTest.java
package com.nt.test;

import java.time.LocalDateTime;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.beans.WishMessageGenerator;
import com.nt.config.AppConfig;

public class JavaConfigAppTest {

	public static void main(String[] args) {
		// create IOC container
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get taget class object
		WishMessageGenerator generator=ctx.getBean("wmg",WishMessageGenerator.class);
		//invoke b.method
		System.out.println(generator.generate("raja"));
		
		// get LocalDateTime class obj from  IOC container
		LocalDateTime    dt=ctx.getBean("createLocalDateTime",LocalDateTime.class);
		System.out.println("data ::"+dt);
		
		//close container
		ctx.close();

	}

}
