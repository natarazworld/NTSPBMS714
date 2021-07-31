package com.nt.runner;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.service.IPersonMgmtService;

@Component
public class AssociationTestRunner implements CommandLineRunner {
	@Autowired
	private IPersonMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		service.fetchDataByJoinsUsingParent().forEach(row->{
			for(Object val:row) {
				System.out.print(val+"  ");
			}
			System.out.println();
		});

	}// run
}// class
