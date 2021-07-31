package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repository.IPersonRepo;
import com.nt.repository.IPhoneNumberRepo;

@Service("personService")
public class PersonMgmtServiceImpl implements IPersonMgmtService {
	@Autowired
	private  IPersonRepo  perRepo;
	@Autowired
	private  IPhoneNumberRepo  phoneRepo;

	@Override
	public String savePerson(Person per) {
	   int idVal=perRepo.save(per).getPid();
		return "Person and his PhoneNumbers are  is saved  with id value:"+idVal;
	}

	@Override
	public String savePhoneNumbers(Iterable<PhoneNumber> phonesSet) {
		for(PhoneNumber ph:phonesSet) {
			  phoneRepo.save(ph);
		}
		return  ((Set<PhoneNumber>) phonesSet).size()+" no.of phoneNumbers are saved";
	}
	
	@Override
	public Iterable<Person> fetchByPerson() {
		return perRepo.findAll();
	}
	
	@Override
	public Iterable<PhoneNumber> fetchByPhoneNumber() {
		return phoneRepo.findAll();
	}

	@Override
	public String deleteByPerson(int personId) {
		//Load Parent obj ...
		Optional<Person> opt=perRepo.findById(personId);
		if(opt.isPresent()) {
			  perRepo.delete(opt.get());
			  return "Person and his  PhoneNumbers are deleted";
		}
		return "Person not found";
	}
	
	@Override
	public String deleteAllPhoneNumbersOfAPerson(int personId) {
		//Load Parent obj
		Optional<Person> opt=perRepo.findById(personId);
		if(opt.isPresent()) {
			//get all childs of a parent
			Set<PhoneNumber>  childs=opt.get().getContactDetails();
			//delete all childs 
			childs.forEach(ph->{
				ph.setPerson(null);
			});
			phoneRepo.deleteAll(childs);
			return childs.size()+" Phonenumbers of "+personId +"Person are deleted";
		}
		return personId+" Person not found";
	}
	

}
