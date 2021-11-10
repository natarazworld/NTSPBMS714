//MultiDataSourceRunner.java
package com.nt.runners;
import java.time.LocalDateTime;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.model.prod.Product;
import com.nt.model.promotions.Offers;
import com.nt.repo.prod.IProductRepo;
import com.nt.repo.promotions.IOffersRepo;


@Component
public class MultiDataSourceRunner implements CommandLineRunner {
	@Autowired
	private IProductRepo  prodRepo;
	@Autowired
	private  IOffersRepo   offersRepo;

	@Override
	public void run(String... args) throws Exception {
	   //save objects
		prodRepo.saveAll(Arrays.asList(new Product("table",100.0,60000.0),
				                                                        new Product("chair",10.0,6000.0),
				                                                        new Product("sofa",11.0,62000.0)
			                                                             	));
		System.out.println("Products are saved");
		System.out.println("==========================");
		offersRepo.saveAll(Arrays.asList(new Offers("Buy-1-Get-1","B1G1",100.0,LocalDateTime.of(2021,11,20, 10, 11)),
				new Offers("Buy-1-Get-2","B1G2",200.0,LocalDateTime.of(2021,11,20, 10, 11)),
				new Offers("Buy-2-Get-2","B2G2",100.0,LocalDateTime.of(2021,11,20, 10, 11))
                 	));
		System.out.println("offers  are saved");
		System.out.println("=========================");
		System.out.println("===========display records(product) ==========");
		prodRepo.findAll().forEach(System.out::println);
		System.out.println("----------------------------------");
		System.out.println("===========display records(offers) ==========");
		offersRepo.findAll().forEach(System.out::println);
		

	}

}
