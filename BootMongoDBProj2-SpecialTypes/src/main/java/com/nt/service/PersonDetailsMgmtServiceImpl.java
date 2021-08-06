package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.document.PersonDetails;
import com.nt.repository.IPersonDetailsRepo;

@Component("personService")
public class PersonDetailsMgmtServiceImpl implements IPersonDetailsMgmtService {
	@Autowired
	private  IPersonDetailsRepo  perRepo;

	@Override
	public String registerPerson(PersonDetails details) {
		return "Person is saved with ::"+perRepo.save(details).getPid();
	}
	
	@Override
	public List<PersonDetails> fetchAllPersons() {
		return perRepo.findAll();
	}

}
