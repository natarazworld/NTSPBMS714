package com.nt.runners;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.CoronaVaccine;
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
			/*service.fetchVaccinesByCompanies("pyzer", "Russie","bharat").forEach(System.out::println);
			service.fetchVaccinesDataByNames("pyzer","sputnik").forEach(vacc->System.out.println(vacc[0]+"  "+vacc[1]+"  "+vacc[2]));*/
		/*service.fetchVaccinesDataByNames("pyzer","sputnik").forEach(vacc->{
				   for(Object val:vacc)
					   System.out.print(val+"  ");
				   System.out.println();
			});*/
		/*service.fetchVaccinesDataByNames("pyzer","sputnik").forEach(vacc->{
		       Arrays.stream(vacc).forEach(val->System.out.print(val+" "));
		       System.out.println();
		});*/
		
		 //service.fetchVaccineNamesByPriceRange(400.0, 600.0).forEach(System.out::println);
		System.out.println("==============================================");
		/* Optional<CoronaVaccine> opt=service.fetchVaccineByName("sputnik");
		 if(opt.isPresent())
			 System.out.println(opt.get());
		 else
			 System.out.println("record not found");*/
		System.out.println("---------------------------------------------");
		/*Object obj=service.fetchVaccineDataByName("sputnik");
		Object details[]=(Object[])obj;
		for(Object val:details) {
			System.out.print(val+"  ");
		}
		System.out.println();
		*/
		/*System.out.println("-------------------------------------");
		System.out.println(service.fetchVaccineCountryByName("sputnik"));*/
		/*System.out.println("================For aggregate functions===============");
		System.out.println("vaccines count::"+service.fetchVaccinesCount());
		 System.out.println("------------------------------------");
		 Object result[]=(Object[])service.fetchVaccineAggregateDetailsByPriceRange(400.0, 600.0);
		 System.out.println("vaccines count of price range(400 to 600)::"+result[0]);
		 System.out.println("max price (400 to 600) ::"+result[1]);
		 System.out.println("min price  (400 to 600)::"+result[2]);
		 System.out.println("sum of price  (400 to 600)::"+result[3]);
		 System.out.println("avg of price  (400 to 600)::"+result[4]);*/
		
		System.out.println("================Non-Select Opeations===============");
		int count=service.modifyVaccinePriceByCountry(800.0,"Russia");
		System.out.println("no.of records updated::"+count);
		
		
		}//main
}//class
