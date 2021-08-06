package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.Customer;
import com.nt.generator.IdGenerator;
import com.nt.service.ICustomerMgmtService;

@Component
public class MongoDBTestRunner implements CommandLineRunner {
	@Autowired
	private  ICustomerMgmtService service; 

	@Override
	public void run(String... args) throws Exception {
		/* Customer cust=new Customer();
		 cust.setCno(1001); cust.setCname("rajesh");
		 cust.setCadd("hyd"); cust.setBillAmt(5500.0);
		System.out.println(service.registerCustomer(cust));*/
		
		/*Customer cust1=new Customer();
		 cust1.setCno(1002); cust1.setCname("ramesh");
		System.out.println(service.registerCustomer(cust1));*/
		
		/*Customer cust2=new Customer();
		cust2.setCno(1003); cust2.setCname("sunil");
		cust2.setCadd("vizag"); cust2.setBillAmt(6500.0);
		cust2.setMobileNo(46665666L);
		System.out.println(service.registerCustomer(cust2));*/
		
		/*		//=================== update operation==============
				Customer cust2=new Customer();
				cust2.setId("610b45cbc2cb83629fa2594f");
				cust2.setCno(1003); cust2.setCname("sunil");
				cust2.setCadd("vizag"); cust2.setBillAmt(6500.0);
				cust2.setMobileNo(788888657L);
				System.out.println(service.registerCustomer(cust2));
		*/		
		
		/*	//=================== save  operation having Customer IdGenerator==============
			Customer cust2=new Customer();
			cust2.setId(IdGenerator.generateId());
			cust2.setCno(1004); cust2.setCname("mahesh");
			cust2.setCadd("vizag1"); cust2.setBillAmt(1500.0);
			cust2.setMobileNo(780888657L);
			System.out.println(service.registerCustomer(cust2));*/
		
		/*	service.findAllCustomers().forEach(cust->{
				System.out.println(cust);
			});*/
		  //System.out.println(service.removeCustomer("d0377c4663"));
		  
		  //==================== finder methods  ===================
		    //service.fetchCustomersByBillAmountRange(4000.0, 10000.0).forEach(System.out::println);
		    service.fetchCustomersByUsingCaddAndHavingMobileNo("vizag","delhi").forEach(System.out::println);
		    
		    
		  
	}//main
}//class
