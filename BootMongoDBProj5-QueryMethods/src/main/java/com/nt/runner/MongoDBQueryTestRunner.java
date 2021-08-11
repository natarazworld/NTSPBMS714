package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repo.ICustomerRepo;
import com.nt.service.ICustomerMgmtService;

import ch.qos.logback.core.net.SyslogOutputStream;

@Component	
public class MongoDBQueryTestRunner implements CommandLineRunner {
	@Autowired
	private ICustomerMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		//invoke methodds
		/*service.fetchCustomersDataByCadd("hyd").forEach(doc->{
			   for(Object attr:doc) {
				   System.out.print(attr+"  ");
			   }
			   System.out.println();
		});*/
		
		/*	service.fetchCustomersByCadd("hyd").forEach(cust->{
				System.out.println(cust);
			});*/
		/*	   service.fetchCustomersDataByCaddAndCname("hyd", "rajesh").forEach(doc->{
				   for(Object attr:doc) {
					   System.out.print(attr+"  ");
				   }
				   System.out.println();
			   });*/
		
		/*  service.fetchCustomersDataByCaddOrCname("hyd", "sunil").forEach(doc->{
			   for(Object attr:doc) {
				   System.out.print(attr+"  ");
			   }
			   System.out.println();
		  });*/
		
		/* service.fetchCustomersDataByBillAmtRange(5000,10000).forEach(doc->{
		   for(Object attr:doc) {
			   System.out.print(attr+"  ");
		   }
		   System.out.println();
		});
		*/
		
		  //service.fetchCustomersByRegCadd("^h").forEach(System.out::println);
		//service.fetchCustomersByRegCadd("g$").forEach(System.out::println);
		//service.fetchCustomersByRegCadd("a").forEach(System.out::println);
		System.out.println("========================");
		//System.out.println("count of docs having billAmount range 6000 to 10000 ::"+service.fetchCustomersCountByBillAmountRange(6000,10000));
		
		//=================================
		 // service.fetchCustomersSortedByBillAmount().forEach(System.out::println);
		 //===========================
		     //System.out.println(" no.of docs deleted are "+service.removeCustomersWithNoBillAmt());
		 //=============================
		   System.out.println("IsCustomersExist with Bill amount range 16000 to 100000"+service.checkCustomersExisitenceWithBillAmountRange(16000, 100000));
	}

}
