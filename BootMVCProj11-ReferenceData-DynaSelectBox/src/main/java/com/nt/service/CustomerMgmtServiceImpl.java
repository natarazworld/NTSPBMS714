package com.nt.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.nt.repository.IHumanActiviesRepo;

@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	@Autowired
	private IHumanActiviesRepo  humanRepo;
	@Autowired
	private Environment  env;
	
	

	@Override
	public Set<String> getAllCountries() {
		Locale[] locales=Locale.getAvailableLocales();
		Set<String> counstriesSet=new TreeSet();
		for(Locale l:locales) {
			counstriesSet.add(l.getDisplayCountry());
		}
		return counstriesSet;
	}
	
	@Override
	public Set<String> getAllLanguages() {
		Locale[] locales=Locale.getAvailableLocales();
		Set<String> languagesSet=new TreeSet();
		for(Locale l:locales) {
			languagesSet.add(l.getDisplayLanguage());
		}
		return languagesSet;
	}
	
	@Override
	public Set<String> getAllHobbies() {
     	return humanRepo.getAllHobbies();
	}
	
	@Override
	public List<String> getStatesByCountry(String country) {
		   //get States from Properties file using Environment object
		     String statesInfo=env.getRequiredProperty(country);
		     System.out.println(statesInfo);
		     List<String> statesList=Arrays.asList(statesInfo.split(","));
		     System.out.println(statesList);
		         Collections.sort(statesList);
		return statesList;
	}

}
