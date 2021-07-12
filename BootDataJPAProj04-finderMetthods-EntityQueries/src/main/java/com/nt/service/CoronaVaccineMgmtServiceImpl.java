package com.nt.service;

import java.util.Arrays;
import java.util.List;

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

	
}//class
