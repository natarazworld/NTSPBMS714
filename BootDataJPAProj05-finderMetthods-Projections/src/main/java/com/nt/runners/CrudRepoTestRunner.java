package com.nt.runners;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.ICoronaVaccineMgmtService;
import com.nt.type.ResultView;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {
	@Autowired
	private  ICoronaVaccineMgmtService  service;

	@Override
	public void run(String... args) throws Exception {
		
		  List<ResultView>  listVaccines=service.searchVaccinesByStartPrice(500.0);
		   listVaccines.forEach(vaccine->{
			   System.out.println(vaccine.getClass()+"  "+Arrays.toString(vaccine.getClass().getDeclaredMethods()));
			    System.out.println(vaccine.getName()+"   "+vaccine.getCountry());
		   });
		   
		
		}//main
}//class
