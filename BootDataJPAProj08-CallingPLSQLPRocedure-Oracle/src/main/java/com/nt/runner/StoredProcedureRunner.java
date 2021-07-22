package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IVaccineMgmtService;

@Component
public class StoredProcedureRunner implements CommandLineRunner {
	@Autowired
	private  IVaccineMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		service.searchVaccinesByPriceRange(400.0f, 900.0f).forEach(System.out::println);
	}//run(-)
}//class
