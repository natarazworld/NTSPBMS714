package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService {
	 public  List<CoronaVaccine>  fetchVaccinesByCompany(String company);
	 public  List<CoronaVaccine>  fetchVaccinesByPriceLessThan(double price);
	 public  List<CoronaVaccine>  fetchVaccinesByPriceRange(double startPrice,double endPrice);
	 public  List<CoronaVaccine>  fetchVaccinesByNameLike(String initChars);   
	 public  List<CoronaVaccine>  fetchVaccinesByNameStartingWith(String startLetters);
	 public  List<CoronaVaccine>  fetchVaccinesByNameEndingWith(String endLetters);
	 public  List<CoronaVaccine>  fetchVaccinesByNameHaving(String letters);
	 public  List<CoronaVaccine>  fetchVaccinesByCountries(String ... countries);
	 public  List<CoronaVaccine>  searchVaccinesNotInCountries(List<String> countries);
	 public  List<CoronaVaccine>  searchVaccinesByPriceAsc(double startPrice);
	 public  List<CoronaVaccine>  fetchVaccineNotFromCountry(String country);
	 public  Optional<CoronaVaccine>  fetchVaccineByRegNo(Long regNo);
}
