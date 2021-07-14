package com.nt.runners;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hibernate.exception.DataException;
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
		
		//service.fetchVaccinesByCompany("pyzer").forEach(System.out::println);
		//service.fetchVaccinesByPriceLessThan(600.0).forEach(System.out::println);
		//service.fetchVaccinesByPriceRange(500.0,700.00).forEach(System.out::println);
		 //service.fetchVaccinesByNameLike("______").forEach(System.out::println);  (or)
		 //service.fetchVaccinesByNameLike("p%").forEach(System.out::println);
		//service.fetchVaccinesByNameStartingWith("s").forEach(System.out::println);
		//service.fetchVaccinesByNameEndingWith("na").forEach(System.out::println);
		//service.fetchVaccinesByNameHaving("e").forEach(System.out::println);
		//service.fetchVaccinesByCountries("India","Russia","USA").forEach(System.out::println);
		  //service.searchVaccinesNotInCountries(List.of("china","pakistan")).forEach(System.out::println);
		 // service.searchVaccinesByPriceAsc(400.0).forEach(System.out::println);
		 //service.fetchVaccineNotFromCountry("china").forEach(System.out::println);
		/*Optional<CoronaVaccine> opt=service.fetchVaccineByRegNo(44L);
		if(opt.isPresent())
			System.out.println(opt.get());
		else
			System.out.println("record not found");*/
		//==================================================================
		   //service.searchVaccincesByNameAndCountry("pyzer","USA").forEach(System.out::println);
		   //service.searchVaccincesByNameInitCharaOrPriceRange("p%",400.0, 500.0).forEach(System.out::println);
		   //service.searchVaccincesByCountriesAndPriceRange(List.of("USA","Russia","India"), 500.0, 700.0).forEach(System.out::println);
		     service.searchVaccincesByCountriesAndNamesOrByPriceRange(List.of("India","USA","Russia"), 
		    		                                                                                                                         List.of("sputnik","pyzer"), 
		    		                                                                                                                         500.0).forEach(System.out::println);
		}//main
}//class
