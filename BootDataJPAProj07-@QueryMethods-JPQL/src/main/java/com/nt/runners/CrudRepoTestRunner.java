package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.ICoronaVaccineMgmtService;
import com.nt.type.ResultView1;
import com.nt.type.ResultView2;
import com.nt.type.ResultView3;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {
	@Autowired
	private  ICoronaVaccineMgmtService  service;

	@Override
	public void run(String... args) throws Exception {
	
		 service.fetchVaccinesByCompany("pyzer").forEach(System.out::println);
		   
		
		}//main
}//class
