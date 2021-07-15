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
	
		   List<ResultView1> list1=service.searchVaccinesByCompany("pyzer",ResultView1.class);
		   list1.forEach(view1->System.out.println(view1.getName()+"  "+view1.getCountry()));
		   System.out.println("------------------------------------------");
		   service.searchVaccinesByCompany("Russie", ResultView2.class).
		                         forEach(view2->System.out.println(view2.getRegNo()+"  "+view2.getPrice()));
		   System.out.println("------------------------------------------");
		   service.searchVaccinesByCompany("Russie", ResultView3.class).
                                forEach(view3->System.out.println(view3.getName()+"  "+view3.getCountry()+"  "+view3.getPrice()));
	
		   
		
		}//main
}//class
