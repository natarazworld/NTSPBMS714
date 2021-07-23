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
		//service.searchVaccinesByPriceRange(400.0f, 900.0f).forEach(System.out::println);
		//System.out.println("Result::"+service.authenticate("raja", "rani1"));
		 Object result[]=service.getEmpDetailsByEno(7499);
		 System.out.println("Emp name::"+result[1]);
		 System.out.println("Emp Desg::"+result[2]);
		 System.out.println("Emp Salary::"+result[3]);
		 System.out.println("Emp DeptNo::"+result[0]);
	}//run(-)
}//class
