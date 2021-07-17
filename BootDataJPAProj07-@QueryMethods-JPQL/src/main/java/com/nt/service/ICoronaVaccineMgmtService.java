package com.nt.service;

import java.util.List;

import com.nt.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService {
	      public  List<CoronaVaccine> fetchVaccinesByCompany(String company);
	      public  List<CoronaVaccine> fetchVaccinesByPriceRange(double min,double max);
	      public  List<CoronaVaccine> fetchVaccinesByCompanies(String company1,String company2,String company3);
	      public  List<Object[]> fetchVaccinesDataByNames(String name1,String name2);
	      public  List<String> fetchVaccineNamesByPriceRange(double min,double max);
	      
	 }
