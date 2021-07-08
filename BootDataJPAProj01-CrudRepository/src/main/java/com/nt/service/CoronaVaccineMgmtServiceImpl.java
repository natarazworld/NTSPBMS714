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
	
	@Override
	public Iterable<CoronaVaccine> fetchAllDetails() {
		return coronaRepo.findAll();
	}
	
	@Override
	public Iterable<CoronaVaccine> fetchAllDetailsByIds(List<Long> ids) {
		return coronaRepo.findAllById(ids);
	}
	
	@Override
	public Optional<CoronaVaccine> fetchVaccineById(Long regNo) {
		return coronaRepo.findById(regNo);
	}
	
	@Override
	public String removeVaccineById(Long id) {
		Optional<CoronaVaccine> opt=coronaRepo.findById(id);
		if(opt.isPresent()) {
			  coronaRepo.deleteById(id);
			  return "record deleted having id ::"+id;
		}
		else
			return "record not found for deletion";	
	}
	
	@Override
	public String removeVaccineByObject(CoronaVaccine vaccine) {
		  Optional<CoronaVaccine> opt=coronaRepo.findById(vaccine.getRegNo());
		  if(opt.isPresent()) {
			   coronaRepo.delete(vaccine);
			   return "record deleted having id ::"+vaccine.getRegNo();
		  }
		return  "record not found for deletion";
	}
	
	@Override
	public String removeVaccinesByIds(Iterable<Long> ids) {
		 Iterable<CoronaVaccine> listEntities=coronaRepo.findAllById(ids);
		 int count=((List)ids).size();
		   if(((List)listEntities).size()==((List)ids).size()) {
			   coronaRepo.deleteAllById(ids);
			   return count+" no.of records are deleted";
		   }
		return "Problem in deleting records";
	}
	
	@Override
	public String removeAllVaccines() {
		    long count=coronaRepo.count();
		   if(count!=0){
              coronaRepo.deleteAll();
              return count+" no.of records are deleted";
		   }
		   return "table is empty to delete records";
	}
	
	

}
