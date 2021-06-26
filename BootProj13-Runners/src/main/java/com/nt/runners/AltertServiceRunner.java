package com.nt.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AltertServiceRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("AltertServiceRunner.run().. The cmd line args are");
		for(String arg:args)
			System.out.println(arg);
	}

}
