package com.nt.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.nt.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService {
	      public  List<CoronaVaccine> fetchVaccinesByCompany(String company);
	      public  List<CoronaVaccine> fetchVaccinesByPriceRange(double min,double max);
	      public  List<CoronaVaccine> fetchVaccinesByCompanies(String company1,String company2,String company3);
	      public  List<Object[]> fetchVaccinesDataByNames(String name1,String name2);
	      public  List<String> fetchVaccineNamesByPriceRange(double min,double max);
	      public  Optional<CoronaVaccine>  fetchVaccineByName(String name);
	      public   Object  fetchVaccineDataByName(String name);
	      public String  fetchVaccineCountryByName(String name);
	      public long  fetchVaccinesCount();
	      public  Object fetchVaccineAggregateDetailsByPriceRange(double min ,double max);
	      public  int modifyVaccinePriceByCountry(double newPrice ,String country);
	      public   int removeVaccinesByPriceRange(double startPrice,double endPrice);
	      public  int  registerVaccine(String company,String country,String name, double price, int dosesCount);
	      public  Date   fetchSystemDate();
	      public int   createTempTable();
	 }
