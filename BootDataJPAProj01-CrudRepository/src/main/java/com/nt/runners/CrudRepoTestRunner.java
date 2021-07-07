package com.nt.runners;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
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
				/* try {
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
					 }*/
				/*try {
				  System.out.println("==============findAll()=====================");
				   Iterable<CoronaVaccine> itList=service.fetchAllDetails();
						    itList.forEach(vaccine->{     //forEach with Lambda
						    	System.out.println(vaccine);
						    });
				    System.out.println("...........................");
				       service.fetchAllDetails().forEach(vaccine->System.out.println(vaccine));  //improved forEach with LAMDA
				       System.out.println("-----------------------");
				       service.fetchAllDetails().forEach(System.out::println);  //forEach with method reference
				       System.out.println(".......................");
				       Arrays.asList(service.fetchAllDetails()).stream().forEach(System.out::println);  //using streaming api
				       System.out.println(".......................");
				       Arrays.asList(service.fetchAllDetails()).stream().map(vac1->vac1).forEach(System.out::println); //using streaming api
				}
				catch(DataAccessException dae) {
					dae.printStackTrace();
				}*/
		
				/*System.out.println("============================================");
				try {
					  System.out.println("==============findAllById(-)=====================");
					   Iterable<CoronaVaccine> itList=service.fetchAllDetailsByIds(List.of(21L,23L,22L));
							    itList.forEach(vaccine->{     //forEach with Lambda
							    	System.out.println(vaccine);
							    });
					    System.out.println("...........................");
					       service.fetchAllDetailsByIds(List.of(21L,23L,22L)).forEach(vaccine->System.out.println(vaccine));  //improved forEach with LAMDA
					       System.out.println("-----------------------");
					       service.fetchAllDetailsByIds(List.of(21L,23L,22L)).forEach(System.out::println);  //forEach with method reference
					       System.out.println(".......................");
					       Arrays.asList(service.fetchAllDetailsByIds(List.of(21L,23L,22L))).stream().forEach(System.out::println);  //using streaming api
					       System.out.println(".......................");
					       Arrays.asList(service.fetchAllDetailsByIds(List.of(21L,23L,22L))).stream().map(vac1->vac1).forEach(System.out::println); //using streaming api
					}
					catch(DataAccessException dae) {
						dae.printStackTrace();
					}*/
		
				/*try {
				  System.out.println("============== findById(-)==================");
				     Optional<CoronaVaccine> opt=service.fetchVaccineById(12L);
				     if(opt.isPresent())
				    	 System.out.println(opt.get());
				     else
				    	 System.out.println("record not found");
				}
				catch(DataAccessException dae) {
					dae.printStackTrace();
				}*/
		
				/*try {
					  System.out.println("============== findById(-)==================");
					     Optional<CoronaVaccine> opt=service.fetchVaccineById(22L);
					     if(opt.isPresent())
					    	 System.out.println(opt.get());
					         opt.orElseThrow(()-> new IllegalArgumentException("record not found"));
					    	 
					}
					catch(DataAccessException dae) {
						dae.printStackTrace();
					}*/
		            
		            CoronaVaccine vaccine=service.fetchVaccineById(22L).orElseThrow(()->new IllegalArgumentException("not available"));
		            System.out.println(vaccine);
		            System.out.println("=========================");
		            CoronaVaccine vaccine1=service.fetchVaccineById(12L).orElse(new CoronaVaccine());
		             System.out.println(vaccine1);
		             System.out.println("=========================");
		             
			            CoronaVaccine vaccine3=service.fetchVaccineById(12L).orElseGet(()-> new CoronaVaccine());
			             System.out.println(vaccine3);

		             
		
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
