package com.nt.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class AltertServiceRunner1 implements CommandLineRunner,Ordered {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("AltertServiceRunner1.run().. The cmd line args are");
		for(String arg:args)
			System.out.println(arg);
	}

	@Override
	public int getOrder() {
		return 15;
	}

}
