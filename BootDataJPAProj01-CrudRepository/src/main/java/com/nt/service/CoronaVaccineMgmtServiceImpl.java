package com.nt.service;

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
	public String registerVaccine(CoronaVaccine vaccine) {
		System.out.println("InMemory Proxy class name ::"+coronaRepo.getClass());
		//use  repo
		CoronaVaccine savedVaccine=null;
		  if(vaccine!=null)
		    savedVaccine=coronaRepo.save(vaccine);
		return savedVaccine!=null?"Vaccine registred/updated successfully with "+savedVaccine.getRegNo():" Vaccine registration/updation failed";
	}

	@Override
	public Iterable<CoronaVaccine> registerInBatch(Iterable<CoronaVaccine> vaccines) {
		     if(vaccines!=null)
	  		     return  coronaRepo.saveAll(vaccines);
		     else
		    	 throw new IllegalArgumentException("batch insertion not done");
	}
	
	@Override
	public long getVaccinesCount() {
			return coronaRepo.count();
	}
	
	
	@Override
	public boolean checkVaccineAvailabilityByRegNo(long regNo) {
		return coronaRepo.existsById(regNo);
	}
	
	

}
