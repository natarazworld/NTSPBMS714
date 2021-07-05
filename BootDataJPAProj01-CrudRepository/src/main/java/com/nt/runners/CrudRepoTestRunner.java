package com.nt.runners;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.entity.CoronaVaccine;
import com.nt.service.ICoronaVaccineMgmtService;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {
	@Autowired
	private  ICoronaVaccineMgmtService  service;

	@Override
	public void run(String... args) throws Exception {
		
		 /*try {
		 //Bulk insertion/batch insertion
			 Iterable<CoronaVaccine> listVaccines= service.registerInBatch(List.of(new CoronaVaccine("sputnik", "Russie","Russia",567.8, 2),
				                                                                                                         new CoronaVaccine("pyzer", "pyzer","USA",678.8, 2),
				                                                                                                         new CoronaVaccine("moderena", "moderena","USA",455.8, 2)
				                                                                                                        ));*/
			 
			 /*Iterable<CoronaVaccine> listVaccines= service.registerInBatch(Arrays.asList(new CoronaVaccine("sputnik", "Russie","Russia",567.8, 2),
                                                                                                                                                new CoronaVaccine("pyzer", "pyzer","USA",678.8, 2),
                                                                                                                                                new CoronaVaccine("moderena", "moderena","USA",455.8, 2)
                                                                                                                             ));
			 
		   System.out.println("The regNos are ");
		   listVaccines.forEach(vaccine->System.out.println(vaccine.getRegNo()));
		 }
		 catch(DataAccessException dae) {
			 dae.printStackTrace();
		 }*/
			 try {
			 System.out.println("Recods count ::"+service.getVaccinesCount());
			 }
			 catch(DataAccessException dae) {
				 dae.printStackTrace();
			 }
			 
			 try {
				 System.out.println("21 regNo vaccine avaiable? ::"+service.checkVaccineAvailabilityByRegNo(21));
				 }
				 catch(DataAccessException dae) {
					 dae.printStackTrace();
				 }
		
		
		
		 //invoke methods
			/*try {
			   	//create Entity class obj
				CoronaVaccine vaccine=new CoronaVaccine("covishield","Serum","india",500.0,2);
				//call b.method
				System.out.println(service.registerVaccine(vaccine));
			}
			catch(DataAccessException dae) {
				dae.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		
		

	}

}
