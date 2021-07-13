package com.nt.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.CoronaVaccine;
import com.nt.repo.ICoronaVaccineRepo;

@Service("vaccineMgmtService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {
	@Autowired
	private ICoronaVaccineRepo  coronaRepo;
	
	@Override
	public List<CoronaVaccine> fetchVaccinesByCompany(String company) {
		System.out.println(coronaRepo.getClass()+" "+Arrays.toString(coronaRepo.getClass().getDeclaredMethods()));
		// use repo
		//return coronaRepo.findByCompany(company);
		//return coronaRepo.findByCompanyEquals(company);
		return coronaRepo.findByCompanyIs(company);
	}
	
	@Override
	public List<CoronaVaccine> fetchVaccinesByPriceLessThan(double price) {
		return coronaRepo.findByPriceLessThan(price);
	}
	
	@Override
	public List<CoronaVaccine> fetchVaccinesByPriceRange(double startPrice, double endPrice) {
	
		return coronaRepo.findByPriceBetween(startPrice, endPrice);
	}
	
	@Override
	public List<CoronaVaccine> fetchVaccinesByNameLike(String initChars) {
	   
		return coronaRepo.findByNameLike(initChars);
	}
	
	@Override
	public List<CoronaVaccine> fetchVaccinesByNameStartingWith(String startLetters) {
		return coronaRepo.findByNameStartingWith(startLetters);
	}
	
	@Override
	public List<CoronaVaccine> fetchVaccinesByNameEndingWith(String endLetters) {
		return coronaRepo.findByNameEndingWith(endLetters);
	}
	
	@Override
	public List<CoronaVaccine> fetchVaccinesByNameHaving(String letters) {
		return coronaRepo.findByNameContaining(letters);
	}
	
	@Override
	public List<CoronaVaccine> fetchVaccinesByCountries(String... countries) {
	    List<String> countriesList=Arrays.asList(countries);
		return coronaRepo.findByCountryIn(countriesList);
	}
	
	
	@Override
	public List<CoronaVaccine> searchVaccinesNotInCountries(List<String> countries) {
		return coronaRepo.findByCountryNotIn(countries);
	}
	
	@Override
	public List<CoronaVaccine> searchVaccinesByPriceAsc(double startPrice) {
		return coronaRepo.findByPriceGreaterThanOrderByPriceAsc(startPrice);
	}
	
	@Override
	public List<CoronaVaccine> fetchVaccineNotFromCountry(String country) {
		return coronaRepo.findByCountryIsNot(country);
	}
	
	@Override
	public Optional<CoronaVaccine> fetchVaccineByRegNo(Long regNo) {
		return coronaRepo.findByRegNo(regNo);
	}

	
}//class
