package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
		
		   service.fetchCustomersDataByBillAmtRange(5000,10000).forEach(doc->{
			   for(Object attr:doc) {
				   System.out.print(attr+"  ");
			   }
			   System.out.println();
		  });
		  

	}

}
