package com.nt.runners;

import java.util.Arrays;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
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
	
		 //service.fetchVaccinesByCompany("pyzer").forEach(System.out::println);
		//service.fetchVaccinesByPriceRange(400.0, 600.0).forEach(System.out::println);
		   service.fetchVaccinesByCompanies("pyzer", "Russie","bharat").forEach(System.out::println);
		service.fetchVaccinesDataByNames("pyzer","sputnik").forEach(vacc->System.out.println(vacc[0]+"  "+vacc[1]+"  "+vacc[2]));
		/*service.fetchVaccinesDataByNames("pyzer","sputnik").forEach(vacc->{
				   for(Object val:vacc)
					   System.out.print(val+"  ");
				   System.out.println();
			});*/
		service.fetchVaccinesDataByNames("pyzer","sputnik").forEach(vacc->{
               Arrays.stream(vacc).forEach(val->System.out.print(val+" "));
               System.out.println();
		});
		
		 service.fetchVaccineNamesByPriceRange(400.0, 600.0).forEach(System.out::println);
		
			
		
		}//main
}//class
