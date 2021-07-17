package com.nt.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}//class
