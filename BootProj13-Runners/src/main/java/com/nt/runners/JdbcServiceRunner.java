package com.nt.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(10)
public class JdbcServiceRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("JdbcServiceRunner.run().. The cmd line args are");
		for(String arg:args)
			System.out.println(arg);
	}

}
