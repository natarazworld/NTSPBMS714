package com.nt.runner;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.DrivingLicense;
import com.nt.document.Person;
import com.nt.service.IRtoMgmtService;

@Component
public class AssociationsTestRunner implements  CommandLineRunner {
	@Autowired
	  private IRtoMgmtService  service;
	@Override
	public void run(String... args) throws Exception {
		/*//=====prepare objects  for parent to child Assoicaiton ====== 
		  //prepare Parent object
		     Person per=new Person();
		     per.setPid(new Random().nextInt(100000));
		     per.setPname("rajesh");
		     per.setPadd("hyd");
		//prepare Child  object
		     DrivingLicense license=new DrivingLicense();
		     license.setLid(Long.valueOf(new Random().nextInt(500000)));
		     license.setType("two-wheeler");
		     license.setExpiryDate(LocalDateTime.of(2040, 10, 2, 2, 5));
		     //map objects
		     per.setLicense(license);
		     //invoke b.method
		     try {
		     System.out.println(service.savePersonWithLicense(per));
		     }
		     catch(Exception e) {
		  	   System.out.println(e.getMessage());
		     }*/
		
		/*////=====prepare objects  for child to parent Assoicaiton ====== 
		  //prepare Parent object
		     Person per=new Person();
		     per.setPid(new Random().nextInt(100000));
		     per.setPname("ramesh");
		     per.setPadd("delhi");
		//prepare Child  object
		     DrivingLicense license=new DrivingLicense();
		     license.setLid(Long.valueOf(new Random().nextInt(500000)));
		     license.setType("four-wheeler");
		     license.setExpiryDate(LocalDateTime.of(2040, 10, 2, 2, 5));
		     //map objects
		     license.setPerson(per);
		     //invoke b.method
		     try {
		     System.out.println(service.saveLicenseWithPerson(license));
		     }
		     catch(Exception e) {
		  	   System.out.println(e.getMessage());
		     }*/
		
		  //===========select operation parent to child ===============
		  service.fetchAllPersons().forEach(per->{
			  System.out.println("parent ::"+per);
			  DrivingLicense license=per.getLicense();
			  System.out.println("child::"+license);
		  });

		       
		       
		
	}//main
}//class
