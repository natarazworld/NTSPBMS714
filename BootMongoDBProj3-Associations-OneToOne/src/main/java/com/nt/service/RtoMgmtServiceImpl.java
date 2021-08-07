package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.DrivingLicense;
import com.nt.document.Person;
import com.nt.repository.IDrivingLicenseRepo;
import com.nt.repository.IPersonRepo;

@Service("RTOService")
public class RtoMgmtServiceImpl implements IRtoMgmtService {
	@Autowired
	private IPersonRepo  perRepo;
	@Autowired
	private IDrivingLicenseRepo  licenseRepo;

	@Override
	public String savePersonWithLicense(Person person) {
		 Person p1=perRepo.save(person);
		 int idVal=p1.getPid();
		 return  "Person object having  License is saved with id value ::"+idVal;
		//return  "Person object having  License is saved with id value ::"+  perRepo.save(person).getPid(); 
	}
	
	@Override
	public String saveLicenseWithPerson(DrivingLicense license) {
		return  "License object having Person is saved with id value ::"+  licenseRepo.save(license).getLid();
	}

	@Override
	public List<Person> fetchAllPersons() {
		return perRepo.findAll();
	}

}
