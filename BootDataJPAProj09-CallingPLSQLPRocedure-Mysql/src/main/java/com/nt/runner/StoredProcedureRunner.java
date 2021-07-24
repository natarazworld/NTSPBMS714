package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IEmpMgmtService;

@Component
public class StoredProcedureRunner implements CommandLineRunner {
	@Autowired
	private  IEmpMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		service.searchEmpsByDesgs("CLERK","MANAGER").forEach(System.out::println);
		}//run(-)
}//class
