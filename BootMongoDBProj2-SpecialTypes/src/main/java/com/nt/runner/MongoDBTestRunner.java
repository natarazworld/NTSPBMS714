package com.nt.runner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.PersonDetails;
import com.nt.repository.IPersonDetailsRepo;
import com.nt.service.IPersonDetailsMgmtService;

@Component
public class MongoDBTestRunner implements CommandLineRunner {
	@Autowired
	private  IPersonDetailsMgmtService   service;

	@Override
	public void run(String... args) throws Exception {
		//prepare Document object
		 PersonDetails details=new PersonDetails();
		 details.setPid(new Random().nextInt(100000));
		 details.setPname("raja");
		 details.setMartialStatus(false);
		 details.setPaddrs("hyd");
		 details.setDob(LocalDateTime.of(1988,11,24,17,54));
		 details.setNickNames(new String[]{"raj","king"});
		 details.setMobileNumbers(Set.of(5435435345L,355435354L));
		 details.setAcademics(List.of("10th","+2","BE","ME"));
		 details.setBankAccounts(Map.of("SBI",5535354L,"ICICI",45435345L));
		 Properties props=new Properties();
		 props.put("aadhar", "534543534"); props.put("panNo","4AA354555");
		 details.setIdDetails(props);
		 
		 System.out.println(service.registerPerson(details));
		 
		  service.fetchAllPersons().forEach(System.out::println);
		
	}

}//class
