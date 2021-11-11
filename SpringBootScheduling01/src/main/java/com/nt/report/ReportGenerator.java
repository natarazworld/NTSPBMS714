package com.nt.report;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("report")
public class ReportGenerator {
	
	//@Scheduled(initialDelay = 2000,fixedDelay = 3000)                                      //1000ms = 1sec
	//@Scheduled(fixedDelay = 3000)
	//@Scheduled(fixedDelayString =  "3000")
	@Scheduled(fixedRate = 10000)
     public  void  generateSalesReport() {
		System.out.println("report start"+new Date());
		try {
			Thread.sleep(15000);
		}
		catch(Exception e) { e.printStackTrace(); }
		System.out.println("SalesReport on::"+new Date());
		System.out.println("Report end"+new Date());
	}

}
