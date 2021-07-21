package com.nt.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.CoronaVaccine;
import com.nt.repo.ICoronaVaccineRepo;
import com.nt.type.View;

@Service("vaccineMgmtService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {
	@Autowired
	private ICoronaVaccineRepo  coronaRepo;
	
	@Override
	public List<CoronaVaccine> fetchVaccinesByCompany(String company) {
		return coronaRepo.searchVaccinesByCompany(company);
	}
	
	@Override
	public List<CoronaVaccine> fetchVaccinesByPriceRange(double min, double max) {
		return coronaRepo.searchVaccinesByPriceRange(min, max);
	}

	@Override
	public List<CoronaVaccine> fetchVaccinesByCompanies(String company1, String company2, String company3) {
		return coronaRepo.searchVaccinesByCompanies(company1, company2, company3);
	}
	
	@Override
	public List<Object[]> fetchVaccinesDataByNames(String name1, String name2) {
		return coronaRepo.searchVaccineDetailsByNames(name1, name2);
	}
	
	@Override
	public List<String> fetchVaccineNamesByPriceRange(double min, double max) {
		return coronaRepo.searchVaccineNamesByPriceRange(min, max);
	}
	
	@Override
	public Optional<CoronaVaccine> fetchVaccineByName(String name) {
		return coronaRepo.searchVaccineByName(name);
	}
	
	@Override
	public Object fetchVaccineDataByName(String name) {
		return coronaRepo.searchVaccineDataByName(name);
	}
	
	@Override
	public String fetchVaccineCountryByName(String name) {
		return coronaRepo.searchVaccineCountryByName(name);
	}
	
	@Override
	public long fetchVaccinesCount() {
		return coronaRepo.getVaccinesCount();
	}
	
	@Override
	public Object fetchVaccineAggregateDetailsByPriceRange(double min, double max) {
		return coronaRepo.getVaccinesAggregateDataByPriceRange(min, max);
	}
	
	@Override
	@Transactional
	public int modifyVaccinePriceByCountry(double newPrice, String country) {
		return coronaRepo.updatePriceByCountry(newPrice, country);
	}
	
	@Override
	public int removeVaccinesByPriceRange(double startPrice, double endPrice) {
		return coronaRepo.deleteVaccincesByPriceRange(startPrice, endPrice);
	}
	
	@Override
	public int registerVaccine(String company, String country, String name, double price, int dosesCount) {
		return coronaRepo.insertVaccine( company, country, name, price, dosesCount);
	}
	
	@Override
	public Date fetchSystemDate() {
		return coronaRepo.getSystemDate();
	}
	
	@Override
	public int createTempTable() {
		return coronaRepo.createTempTable();
	}
	
}//class
